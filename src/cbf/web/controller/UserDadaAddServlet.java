package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.domain.User;
import cbf.formbean.RegisterFormBean;
import cbf.service.IsSessionService;
import cbf.service.UserService;
import cbf.utils.WebUtils;

public class UserDadaAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		// 对表单的数据进行校验
		// 将请求参数封装至  formbean
		RegisterFormBean formBean = WebUtils.request2Bean3(request, RegisterFormBean.class);
//		System.out.println("beforlevel="+formBean.getLevel());
		
		// 校验
		boolean b = formBean.validateAdd();
//		System.out.println("afterlevel="+formBean.getLevel());
//		System.out.println("b="+b);
		if(!b) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/WEB-INF/jsp/userdata_add.jsp").forward(request, response);
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
			request.getRequestDispatcher("/WEB-INF/jsp/userdata_add.jsp").forward(request, response);
		}else {
			// 添加成功  
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，添加用户成功!');");
			response.getWriter().print("top.location.href='../servlet/UserDataUIListServlet';");
			response.getWriter().print("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
