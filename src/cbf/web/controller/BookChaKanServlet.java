package cbf.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cbf.dao.BookDao;
import cbf.domain.Book;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class BookChaKanServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String chakan_info = request.getParameter("chakan");
//		System.out.println("chakan_info="+chakan_info);
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.find(chakan_info);
		DataToJsonService service = new DataToJsonService();
		String s = service.jsonBookChakan(book);
//		System.out.println("s="+s);
		String fileName = "bookdata_chakan.json";
		String filePath = request.getRealPath("/json_save/") +java.io.File.separator+ fileName;
//		System.out.println("filePath="+filePath);
		FileUtils.writeStringToFile(new File(filePath), s, "UTF-8",false); 
		
		request.getRequestDispatcher("/WEB-INF/jsp/bookdata_chakan.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
