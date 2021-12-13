package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import net.coobird.thumbnailator.Thumbnails;
import service.ProductService;
import service.ProductServiceImpl;

@WebServlet("/prodCtrl/*")
public class ProductController extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	private final ProductService psv;
	private RequestDispatcher rdp;
	private final String UTF8 = "utf-8";

	public ProductController() {
		psv = new ProductServiceImpl();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String savePath = getServletContext().getRealPath("/_fileUpload");
		File fileDir = new File(savePath);
		ProductVO pvo;
		int isUp = 0;
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>>path = {}", path);

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
			pvo = new ProductVO();
			try {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1 * 1024 * 1024);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				List<FileItem> items = fileUpload.parseRequest(req);
				for (FileItem item : items) {
					switch (item.getFieldName()) {
					case "pno":
						pvo.setPno(Long.parseLong(item.getString(UTF8)));
						break;
					case "readCount":
						pvo.setReadCount(Integer.parseInt(item.getString(UTF8)));
						break;
					case "pname":
						pvo.setPname(item.getString(UTF8));
						break;
					case "price":
						pvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "madeBy":
						pvo.setMadeBy(item.getString(UTF8));
						break;
					case "category":
						pvo.setCategory(item.getString(UTF8));
						break;
					case "description":
						pvo.setDescription(item.getString(UTF8));
						break;
					case "imgFile":
						log.info(item.getString(UTF8));
						pvo.setImgFile(item.getString(UTF8));
						break;
					case "new_imgFile":
						log.info("new file: {} ", item.getName());
						if (item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							log.info(">>> new upload file : {}", uploadFilePath);
							log.info("new upload 될때 이전 파일 명 : {}", pvo.getImgFile());
							File removeFile = new File(fileDir + File.separator + pvo.getImgFile());
							File removeFileThumb = new File(fileDir + File.separator + "th_" + pvo.getImgFile());
							removeFile.delete();
							removeFileThumb.delete();
							try {
								item.write(uploadFilePath);
								pvo.setImgFile(fileName);
								Thumbnails.of(uploadFilePath).size(75, 75)
										.toFile(new File(fileDir + File.separator + "th_" + fileName));
							} catch (Exception e) {
								log.info(">>> file write > fail");
								e.printStackTrace();
							}
						}
						break;
					default:
						break;
					}
				}

				log.info(">>> pvo > {} ", pvo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.info(">>> e : {}", e);
			}
			isUp = psv.modify(pvo);
			log.info(">>> update > {}", isUp > 0 ? "success" : "fail");
			req.getRequestDispatcher("/prodCtrl/detail?pno=" + pvo.getPno()).forward(req, res);

			break;
		case "remove":
			File removeFile = new File(fileDir + File.separator + req.getParameter("imgFile"));
			File removeFileThumb = new File(fileDir + File.separator + "th_" + req.getParameter("imgFile"));
			boolean rm = true;
			if (removeFile.exists() || removeFileThumb.exists()) {
				rm = removeFile.delete();
				if (rm) {
					removeFileThumb.delete();
				}
			}
			if (rm) {
				rm = psv.remove(Long.valueOf(req.getParameter("pno"))) > 0 ? true : false;
			}
			log.info(">>> delete > {} ", rm ? "success" : "fail");
			req.getRequestDispatcher("/prodCtrl/list").forward(req, res);
			break;
		case "insert":

			try {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1 * 1024 * 1024);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				pvo = new ProductVO();
				List<FileItem> items = fileUpload.parseRequest(req);
				for (FileItem item : items) {
					switch (item.getFieldName()) {
					case "pname":
						pvo.setPname(item.getString(UTF8));
						break;
					case "price":
						pvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "madeBy":
						pvo.setMadeBy((item.getString(UTF8)));
						break;
					case "description":
						pvo.setDescription((item.getString(UTF8)));
						break;
					case "writer":
						pvo.setWriter((item.getString(UTF8)));
						break;
					case "imgFile":
						if (item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							try {
								item.write(uploadFilePath);
								pvo.setImgFile(fileName);
								Thumbnails.of(uploadFilePath).size(75, 75)
										.toFile(new File(fileDir + File.separator + "th_" + fileName));
							} catch (Exception e) {
								log.info(">>> file write > fail");
								e.printStackTrace();
							}
						}
						break;
					case "category":
						pvo.setCategory((item.getString(UTF8)));
						break;

					default:
						break;
					}
				}
				log.info(">>> pvo > {}", pvo);
				psv.register(pvo);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("/prodCtrl/list").forward(req, res);
			break;

		default:
			break;
		}

	}
}
