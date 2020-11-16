package cbf.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cbf.dao.BookDao;
import cbf.domain.Book;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;
import cbf.utils.WebUtils;

public class BookModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		response.setContentType("text/html;charset=utf-8");
		Book book = WebUtils.request2Bean(request, Book.class);
		BookDao bookDao = new BookDao();
		boolean b = bookDao.update(book);
		if(b) {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，修改成功!');");
			response.getWriter().print("top.location.href='../servlet/MainUIServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，修改失败!');");
			response.getWriter().print("top.location.href='../servlet/BookModifyUIServlet';");
			response.getWriter().print("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
