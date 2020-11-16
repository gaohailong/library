package cbf.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.BookDao;
import cbf.dao.UserDao;
import cbf.domain.Book;
import cbf.domain.User;
import cbf.service.IsSessionService;

public class UserModifyUIServlet extends HttpServlet {
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
		
		UserDao userDao = new UserDao();
		User user = userDao.find(modify_info);
		request.setAttribute("userModifyHuixian", user);
		request.getRequestDispatcher("/WEB-INF/jsp/userdata_modify.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
