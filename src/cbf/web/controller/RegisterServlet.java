package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.domain.User;
import cbf.formbean.RegisterFormBean;
import cbf.service.UserService;
import cbf.utils.WebUtils;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 对表单的数据进行校验
		// 将请求参数封装至  formbean
		RegisterFormBean formBean = WebUtils.request2Bean(request, RegisterFormBean.class);
		
		// 校验
		boolean b = formBean.validate();
		
		if(!b) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		
		// 验证通过
		// 将 formBean 的数据批量导入 userBean
		User bean = new User();
		WebUtils.copyBean(bean, formBean);
		
		// 找 service 做注册
		UserService service = new UserService();
		b = service.registerUser(bean);
		if(!b) {
			// 用户名已存在
			request.setAttribute("errorMsg", "用户名已存在");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}else {
			// 注册成功  user存入session 跳转至首页
			request.getSession().setAttribute("user", bean);
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，注册成功，正跳转到登录页面!');");
			response.getWriter().print("top.location.href='../servlet/LoginUIServlet';");
			response.getWriter().print("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
