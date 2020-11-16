package cbf.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cbf.dao.BookDao;
import cbf.dao.BorrowInfoDao;
import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class BorrowChaKanServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String chakan_info1 = request.getParameter("chakan1");
		String chakan_info2 = request.getParameter("chakan2");
//		System.out.println("chakan1="+chakan_info1+" chakan2="+chakan_info2); 
		
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = borrowInfoDao.find_UidSid(chakan_info1, chakan_info2);
		DataToJsonService service = new DataToJsonService();
		String s = service.jsonBorrowChakan(borrowInfo);
//		System.out.println("s="+s);
		String fileName = "borrowdata_chakan.json";
		String filePath = request.getRealPath("/json_save/") +java.io.File.separator+ fileName;
//		System.out.println("filePath="+filePath);
		FileUtils.writeStringToFile(new File(filePath), s, "UTF-8",false); 
		
		request.getRequestDispatcher("/WEB-INF/jsp/borrowdata_chakan.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
