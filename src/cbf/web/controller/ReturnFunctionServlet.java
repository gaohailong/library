package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.BookDao;
import cbf.dao.BorrowInfoDao;
import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.domain.User;
import cbf.service.BRunctionService;
import cbf.service.IsSessionService;

public class ReturnFunctionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
//		User user = (User) request.getSession().getAttribute("user");
		String chakan_info1 = request.getParameter("chakan1");
		String chakan_info2 = request.getParameter("chakan2");
//		System.out.println("chakan_info="+chakan_info);
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = borrowInfoDao.find_UidSid(chakan_info1, chakan_info2);
		BRunctionService service = new BRunctionService();
		boolean b = service.successReturn(borrowInfo);//处理退订请求
		
//		System.out.println(request.getRequestURI());
		
		if(b){
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，还书成功');");
			response.getWriter().print("top.location.href='../servlet/Borrow_WS_UIListServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，还书失败!');");
			response.getWriter().print("top.location.href='../servlet/Borrow_WS_UIListServlet';");
			response.getWriter().print("</script>");
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}