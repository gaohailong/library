package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.UserDao;
import cbf.domain.User;
import cbf.formbean.PersonFormBean;
import cbf.formbean.PersonPwd;
import cbf.service.IsSessionService;
import cbf.utils.WebUtils;

public class PersonPwdModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		User user = (User) request.getSession().getAttribute("user");
		PersonPwd personPwd = WebUtils.request2Bean(request, PersonPwd.class);
		//校验
		boolean b1 = personPwd.validate(user.getUid());
		if (!b1) {
			Map<String,String> errosMap = personPwd.getErrors();
			String errorValue = errosMap.get("password");
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('"+errorValue+"');");
			response.getWriter().print("top.location.href='../servlet/PersonDataUIservlet';");
			response.getWriter().print("</script>");
			return;
		}
		// 将 formBean 的数据批量导入 userBean
		WebUtils.copyBean(user, personPwd);
		
		UserDao userDao = new UserDao();
		boolean b = userDao.update(user);
		if(b) {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，修改成功!');");
			response.getWriter().print("top.location.href='../servlet/LoginUIServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，修改失败!');");
			response.getWriter().print("top.location.href='../servlet/PersonDataUIservlet';");
			response.getWriter().print("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
