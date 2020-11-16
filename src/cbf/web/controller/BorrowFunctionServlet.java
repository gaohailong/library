package cbf.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cbf.dao.BookDao;
import cbf.dao.BorrowInfoDao;
import cbf.dao.UserDao;
import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.domain.User;
import cbf.service.BRunctionService;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class BorrowFunctionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		User user = (User) request.getSession().getAttribute("user");
		String chakan_info = request.getParameter("chakan");
//		System.out.println("chakan_info="+chakan_info);
		BookDao bookDao = new BookDao();
		Book book = bookDao.find(chakan_info);
		if (book.getIsBorrowed() == 1) {	//表示已经借出，所以不能再借
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('该书已经被订阅，请重新选择!');");
			response.getWriter().print("top.location.href='../servlet/Main_WS_UIServlet';");
			response.getWriter().print("</script>");
			return;
		}
		BRunctionService service = new BRunctionService();
		boolean b = service.successBorrow(user, book);//处理订阅请求
	
		if(b){
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('恭喜，订阅成功');");
			response.getWriter().print("top.location.href='../servlet/Borrow_WS_UIListServlet';");
			response.getWriter().print("</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">");
			response.getWriter().print("alert('对不起，订阅失败!');");
			response.getWriter().print("top.location.href='../servlet/Main_WS_UIServlet';");
			response.getWriter().print("</script>");
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}