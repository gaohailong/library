package cbf.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbf.dao.BorrowInfoDao;
import cbf.domain.BorrowInfo;
import cbf.service.BRunctionService;
import cbf.service.IsSessionService;

public class ReturnFunctionServlet_1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String chakan_info1 = request.getParameter("chakan1");
		String chakan_info2 = request.getParameter("chakan2");
		BorrowInfo borrowInfo = new BorrowInfoDao().find_UidSid(chakan_info1, chakan_info2);
		BRunctionService service = new BRunctionService();
		boolean b = service.successReturn_1(borrowInfo);//处理还书申请的请求
	
		if(b){
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，确认其还书成功');");
			response.getWriter().print("top.location.href='../servlet/Borrow_WSAll_UIListServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，确认其还书失败!');");
			response.getWriter().print("top.location.href='../Borrow_WSAll_UIListServlet';");
			response.getWriter().print("</script>");
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}