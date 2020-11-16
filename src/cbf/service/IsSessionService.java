package cbf.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cbf.domain.User;

public class IsSessionService {
	public boolean isHaveUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
//		System.out.println("user="+user);
		if (user == null) {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('登录超时，请重新登录!');");
			response.getWriter().print("top.location.href='../index.html';");
			response.getWriter().print("</script>");
			return true;
		}
		return false;
	}
	public void exitSystem(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();
		s.removeAttribute("user");
		response.getWriter().print("<script type=\"text/javascript\">");
		response.getWriter().print("alert('您确定要退出本系统吗？');");
		response.getWriter().print("top.location.href='../index.html';");
		response.getWriter().print("</script>");
	}
}
