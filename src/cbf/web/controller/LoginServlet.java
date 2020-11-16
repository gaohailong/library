package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.domain.User;
import cbf.service.UserService;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得用户名和密码
		request.setCharacterEncoding("utf-8");
		
		String uid = request.getParameter("uid");
		String password = request.getParameter("password");
		String level_temp = request.getParameter("level");
		int level = -1;
		if (level_temp != null) 
			level = Integer.parseInt(level_temp);
//		System.out.println("uid="+uid);
//		System.out.println("password="+password);
//		System.out.println("level="+level_temp);
		
		// 找 service 做注册
		UserService service = new UserService();
		User user = service.loginUser(uid, password,level);

		// 响应
		if(user==null) {
			// 登陆失败  跳回登陆页面
			request.setAttribute("errorMsg", "请核实用户名或密码或身份！");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else if(user.getLevel() == 2){
			// 登陆成功  user 存入session 跳转至首页
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/servlet/MainUIServlet");
		}
//		else if(user.getLevel() == 1){
//			// 登陆成功  user 存入session 跳转至首页
//			request.getSession().setAttribute("user", user);
//			response.sendRedirect(request.getContextPath()+"/servlet/Main_WS_UIServlet");
//		}
		else{
			// 登陆成功  user 存入session 跳转至首页
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/servlet/Main_WS_UIServlet");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
