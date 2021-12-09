package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImpl;

@WebServlet("/prodCtrl/*")
public class ProductController extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	private final ProductService psv;
	private RequestDispatcher rdp;

	public ProductController() {
		psv = new ProductServiceImpl();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int isUp;
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		log.info(">>>uri = {}", uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>>path = {}", path);
		log.info(">>>param = {}", req.getParameter("key"));

		switch (path) {
		case "register":
			req.getRequestDispatcher("/product/register.jsp").forward(req, res);
			break;
		case "list":
			req.setAttribute("list", psv.getList());
			req.getRequestDispatcher("/product/list.jsp").forward(req, res);
			break;
		case "detail":
			req.setAttribute("pvo", psv.getOneAndUp(Long.valueOf(req.getParameter("pno"))));
			req.getRequestDispatcher("/product/detail.jsp").forward(req, res);
			break;
		case "modify":
			req.setAttribute("pvo", psv.getOne(Long.valueOf(req.getParameter("pno"))));
			req.getRequestDispatcher("/product/modify.jsp").forward(req, res);
			break;
		case "update":
			isUp = psv.modify(new ProductVO(Long.valueOf(req.getParameter("pno")), req.getParameter("pname"),
					Integer.parseInt(req.getParameter("price")), req.getParameter("madeBy"),
					req.getParameter("category"), req.getParameter("description"), req.getParameter("imgFile")));
			log.info(">>> update > {}", isUp > 0 ? "success" : "fail");
			req.getRequestDispatcher("/prodCtrl/detail?pno=" + req.getParameter("pno")).forward(req, res);

			break;
		case "remove":
			isUp = psv.remove(Long.valueOf(req.getParameter("pno")));
			log.info(">>> delete > {} " , isUp >0 ? "success" : "fail");
			req.getRequestDispatcher("/prodCtrl/list").forward(req, res);
			break;
		case "insert":
			isUp = psv.register(new ProductVO(req.getParameter("pname"), Integer.parseInt(req.getParameter("price")),
					req.getParameter("madeBy"), req.getParameter("writer"), req.getParameter("category"),
					req.getParameter("description"), req.getParameter("imgFile")));
			log.info(">>> insert > {}", isUp > 0 ? "success" : "fail");
			req.getRequestDispatcher("/prodCtrl/list").forward(req, res);
			break;

		default:
			break;
		}

	}
}
