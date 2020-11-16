package cbf.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.domain.User;
import cbf.service.IsSessionService;

public class PersonDataUIservlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		User user = (User) request.getSession().getAttribute("user");//获得登录用户的信息
		request.setAttribute("userModifyHuixian", user);
		request.getRequestDispatcher("/WEB-INF/jsp/persondata_modify.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
