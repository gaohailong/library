package cbf.web.controller;

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
import cbf.utils.WebUtils;

public class UserModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		response.setContentType("text/html;charset=utf-8");
		User user = WebUtils.request2Bean(request, User.class);
		UserDao userDao = new UserDao();
		boolean b = userDao.update(user);
		if(b) {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，修改成功!');");
			response.getWriter().print("top.location.href='../servlet/UserDataUIListServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，修改失败!');");
			response.getWriter().print("top.location.href='../servlet/UserModifyUIServlet';");
			response.getWriter().print("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
