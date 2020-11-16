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
import cbf.dao.UserDao;
import cbf.domain.Book;
import cbf.domain.User;
import cbf.service.DataToJsonService;
import cbf.service.IsSessionService;

public class UserDataUIListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IsSessionService isSessionService = new IsSessionService();
		boolean flag = isSessionService.isHaveUser(request, response);
		if (flag) return;
		
		String search_info = request.getParameter("searchUserInfo");
//		System.out.println("searchUserInfo="+search_info);
		String userLoginUid = ((User)request.getSession().getAttribute("user")).getUid();
		
		String whereInfo = "";
		String select_sql = null;

		if (search_info != null && search_info.length() > 0) {
			whereInfo = whereInfo + " (name like '%" + search_info + "%') ";

			select_sql = "select * from user where (" + whereInfo + ") order by uid desc";
		} else {
			select_sql = "select * from user order by uid desc";
		}
//		System.out.println("searchUserInfosql="+select_sql);
		
		UserDao userDao = new UserDao();
		List<User> userlist = userDao.getAll(select_sql);
		DataToJsonService service = new DataToJsonService();
		String s = service.jsonUserList(userlist,userLoginUid);
//		System.out.println("searchBookString="+s);
		String fileName = "userdatalist.json";
		String filePath = request.getRealPath("/json_save/") +java.io.File.separator+ fileName;
//		System.out.println("filePath="+filePath);
		FileUtils.writeStringToFile(new File(filePath), s, "UTF-8",false); 
		
		//设置Cookie
		String ErrorString = "{\"data\":[" + "[\"  \"," + "\"  \","
				+ "\"对不起\"," + "\"未搜索到，请重试！\","+ "\"  \"]]}";
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
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/userdatalist.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
