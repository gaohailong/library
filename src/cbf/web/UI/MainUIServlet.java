package cbf.web.UI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cbf.dao.BookDao;
import cbf.domain.Book;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class MainUIServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String search_info = request.getParameter("searchBookInfo");
//		System.out.println("searchBookInfo="+search_info);
		String whereInfo1 = "";
		String whereInfo2 = "";
		String select_sql = null;

		if (search_info != null && search_info.length() > 0) {
			whereInfo1 = whereInfo1 + " (bookname like '%" + search_info + "%') ";
			whereInfo2 = whereInfo2 + " (publication like '%" + search_info + "%') ";

			select_sql = "select * from books where (" + whereInfo1 + " or "
					+ whereInfo2 + ") order by bid desc";
		} else {
			select_sql = "select * from books order by bid desc";
		}
//		System.out.println("searchBookInfosql="+select_sql);
		
		BookDao bookDao = new BookDao();
		List<Book> booklist = bookDao.getAll(select_sql);
		DataToJsonService service = new DataToJsonService();
		String s = service.jsonBookList(booklist);
//		System.out.println("searchBookString="+s);
		String fileName = "bookdatalist.json";
		String filePath = request.getRealPath("/json_save/") +java.io.File.separator+ fileName;
//		System.out.println("filePath="+filePath);
		FileUtils.writeStringToFile(new File(filePath), s, "UTF-8",false); 
		
		// 设置显示样式
		String ErrorString = "{\"data\":[" + "[\"  \"," + "\"  \","
				+ "\"对不起\"," + "\"未搜索到，请重试！\","+ "\"  \"]]}";
		if (ErrorString.equals(s)) {
			request.setAttribute("sError", 0);
		}else {
			request.setAttribute("sError", 1);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
