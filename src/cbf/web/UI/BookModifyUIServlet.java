package cbf.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.BookDao;
import cbf.domain.Book;
import cbf.service.IsSessionService;

public class BookModifyUIServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String modify_info = request.getParameter("xiugai");
		if (modify_info != null) {
			request.getSession().setAttribute("xiugai", modify_info);
		}
//		System.out.println("modify_info="+(String)request.getSession().getAttribute("xiugai"));
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.find((String)request.getSession().getAttribute("xiugai"));
		request.setAttribute("bookHuixian", book);
		request.getRequestDispatcher("/WEB-INF/jsp/bookdata_modify.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
