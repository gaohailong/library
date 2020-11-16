package cbf.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.service.IsSessionService;

public class RegisterUIServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 转发 注册表单
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
				request, response);
//		response.sendRedirect(request.getContextPath()+"/register.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
