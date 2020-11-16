package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.UserDao;
import cbf.domain.User;
import cbf.formbean.PersonFormBean;
import cbf.service.IsSessionService;
import cbf.utils.WebUtils;

public class PersonModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		PersonFormBean userFormBean = WebUtils.request2Bean2(request, PersonFormBean.class);
		User user = (User) request.getSession().getAttribute("user");
		// 将 formBean 的数据批量导入 userBean
		WebUtils.copyBean(user, userFormBean);
//		System.out.println("level="+user.getLevel());
		UserDao userDao = new UserDao();
		boolean b = userDao.update(user);
		if(b) {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，修改成功!');");
			response.getWriter().print("top.location.href='../servlet/PersonDataUIservlet';");
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
