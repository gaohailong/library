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
import cbf.dao.BorrowInfoDao;
import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class BorrowUIListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String search_info = request.getParameter("searchBorroeInfo");
//		System.out.println("searchBorroeInfo="+search_info);
		String whereInfo1 = "";
		String whereInfo2 = "";
		String select_sql = null;

		if (search_info != null && search_info.length() > 0) {
			whereInfo1 = whereInfo1 + " (books.bookname like '%" + search_info
					+ "%') ";
			whereInfo2 = whereInfo2 + " (user.name like '%" + search_info
					+ "%') ";

			select_sql = "select borrowinfo.bid,books.bookname,books.writer,"
					+ "books.publication,borrowinfo.uid,user.name,user.level,"
					+ "borrowinfo.borrowtime,borrowinfo.returntime,borrowinfo.ishistory"
					+ " from books,user,borrowinfo"
					+ " where borrowinfo.uid=user.uid and borrowinfo.bid = books.bid"
					+ " and (" + whereInfo1 + " or " + whereInfo2
					+ ") order by bid desc";
		} else {
			select_sql = "select borrowinfo.bid,books.bookname,books.writer,"
					+ "books.publication,borrowinfo.uid,user.name,user.level,"
					+ "borrowinfo.borrowtime,borrowinfo.returntime,borrowinfo.ishistory"
					+ " from books,user,borrowinfo where borrowinfo.uid=user.uid and borrowinfo.bid = books.bid"
					+ " order by bid desc";
		}
//		System.out.println("searchBorroeInfosql="+select_sql);

		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		List<BorrowInfo> borrowlist = borrowInfoDao.getAll(select_sql);
		DataToJsonService service = new DataToJsonService();
		String s = service.jsonBorrowList(borrowlist);
//		System.out.println("searchBorroeString="+s);
		
		String fileName = "bookborrowlist.json";
		String filePath = request.getRealPath("/json_save/")
				+ java.io.File.separator + fileName;
		// System.out.println("filePath="+filePath);		
		FileUtils.writeStringToFile(new File(filePath), s, "UTF-8", false);
		
		// 设置Cookie
		String ErrorString = "{\"data\":[" + "[\"  \"," + "\"  \","
				+ "\"对不起\"," + "\"未搜索到，请重试！\"," + "\"  \"," + "\"  \"]]}";
		if (ErrorString.equals(s)) {
			// cookie 有一个名字 String 有一个值 String
			Cookie cookie = new Cookie("sError", "0");
			// 希望 cookie 缓存至客户端硬盘 cookie默认只在浏览器进程有效，需要缓存要设置有效时间
			cookie.setMaxAge(60);// 这里是以秒为单位！
			// cookie 默认情况下只在当前路径有效
			cookie.setPath(request.getRealPath("")+"/WEB-INF/jsp");
			// 将 cookie 发送给客户端浏览器
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies(); // 如果没发Cookie过来，为null
			// 遍历数组 找 名称为sError
			for (int i = 0; cookies != null && i < cookies.length; i++) {
				// 遍历Cookie时，一定要注意IE客户端有没有发送Cookie过来，否则将会发生空指针异常
				if ("sError".equals(cookies[i].getName())) {
//					System.out.println(cookies[i].getValue());
					cookies[i].setValue("1");
					cookies[i].setMaxAge(60);
					cookies[i].setPath(request.getRealPath("")+"/WEB-INF/jsp");
					response.addCookie(cookies[i]);
					break;
				}
			}
		}

		request.getRequestDispatcher("/WEB-INF/jsp/borrowlist.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
