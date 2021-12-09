package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/memCtrl/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final MemberService msv;
	private RequestDispatcher rdp;
	private int isUp;

	public MemberController() {
		msv = new MemberServiceImpl();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>>path = {}", path);
		switch (path) {
		case "register":
			rdp = req.getRequestDispatcher("/member/register.jsp");
			rdp.forward(req, res);
			break;
		case "list":
			req.setAttribute("list", msv.getList());
			System.out.println(msv.getList());
			req.getRequestDispatcher("/member/list.jsp").forward(req, res);

			break;
		case "detail":
			
			req.setAttribute("mvo", msv.getOne(req.getParameter("email")));
			req.getRequestDispatcher("/member/detail.jsp").forward(req, res);
			break;
		case "modify":
			isUp = msv.modify(new MemberVO(req.getParameter("email"), req.getParameter("pwd"), req.getParameter("nickName")));
			log.info(">>> Modify > {}", isUp > 0 ? "success" : "fail");
			req.getRequestDispatcher("/memCtrl/detail?email=" + req.getParameter("email")).forward(req, res);
			
			break;
		case "remove":
			isUp = msv.remove(req.getParameter("email"));
			log.info(">>> logout > {}", isUp > 0 ? "success" : "fail");
			
			HttpSession curr_session1 = req.getSession();
			curr_session1.invalidate();
			req.setAttribute("msg_resign", 1);
			req.getRequestDispatcher("/").forward(req, res);
			
			break;
		case "insert":
			isUp = msv.register(
					new MemberVO(req.getParameter("email"), req.getParameter("pwd"), req.getParameter("nickName")));
			log.info(">>> JOIN > {}", isUp > 0 ? "success" : "fail");
			req.setAttribute("msg_reg", isUp > 0 ? 1 : 0);
			req.getRequestDispatcher("/index.jsp").forward(req, res);
			break;
		case "login":
			MemberVO mvo = msv.login(new MemberVO(req.getParameter("email"), req.getParameter("pwd")));
			System.out.println(mvo);
			if(mvo != null) {
				HttpSession session = req.getSession();
				session.setAttribute("mvo", mvo);
				session.setMaxInactiveInterval(60*10);
			}else {
				req.setAttribute("msg_login", 0);
			}
			req.setAttribute("mvo", mvo);
			req.getRequestDispatcher("/").forward(req, res);
			break;
		case "logout":
			HttpSession curr_session = req.getSession();
			curr_session.invalidate();
			req.setAttribute("msg_out", 1);
			req.getRequestDispatcher("/").forward(req, res);
			break;
		default:
			break;
		}

	}

}
