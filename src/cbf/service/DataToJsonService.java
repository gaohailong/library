package cbf.service;

import java.util.List;

import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.domain.User;
import javax.servlet.http.HttpServletRequest;

public class DataToJsonService {
	//显示图书列表的信息
	public String jsonBookList(List<Book> list) {
		String s = "";
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			String isBorrowed = (book.getIsBorrowed()==1)?"已借出":"未借出";
			if(i == 0){
				s=s+"{\"data\":["+"[\""+book.getBid()+"\","+"\""+book.getBookname()+"\","+"\""+book.getWriter()+"\","+
				"\""+book.getPublication()+"\","+"\""+isBorrowed+"\"]";
			}else {
				s=s+",[\""+book.getBid()+"\","+"\""+book.getBookname()+"\","+"\""+book.getWriter()+"\","+
						"\""+book.getPublication()+"\","+"\""+isBorrowed+"\"]";
			}
		}
		if (i > 0) {
			s=s+"]}";
		}else {
			s=s+"{\"data\":["+"[\"  \","+"\"  \","+"\"对不起\","+"\"未搜索到，请重试！\","+"\"  \"]]}";
		}
		return s;
	}
	//显示图书具体查看列表的信息
	public String jsonBookChakan(Book book) {
		String isBorrowed = (book.getIsBorrowed()==1)?"已借出":"未借出";
		String s = "{\"data\":["+"[\"图书编号\",\""+book.getBid()+"\"],"
					+"[\"图书名称\",\""+book.getBookname()+"\"],"
					+"[\"图书作者\",\""+book.getWriter()+"\"],"
					+"[\"图书出版社\",\""+book.getPublication()+"\"],"
					+"[\"是否被借出\",\""+isBorrowed+"\"]"+"]}";
		return s;
	}
	//显示借阅列表数据
	public String jsonBorrowList(List<BorrowInfo> list) {
		String s = "";
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			BorrowInfo borrowInfo = list.get(i);
			String level = (borrowInfo.getLevel()==1)?"工作者":"学生";
			int tem = borrowInfo.getInhistory();
			String inhistory ="";
			if (tem == 1) inhistory = "借过已还"; 
			else if (tem == 0) inhistory = "借过未还";
			else if(tem == -1) inhistory = "申请借书中"; 
			else inhistory = "申请还书中";
			if(i == 0){
				s=s+"{\"data\":["+"[\""+borrowInfo.getUid()+"\","+"\""+borrowInfo.getName()+"\","
						+"\""+level+"\","+"\""+borrowInfo.getBid()+"\","+
						"\""+borrowInfo.getBookname()+"\","+"\""+inhistory+"\"]";
			}else {
				s=s+",[\""+borrowInfo.getUid()+"\","+"\""+borrowInfo.getName()+"\","
						+"\""+level+"\","+"\""+borrowInfo.getBid()+"\","+
						"\""+borrowInfo.getBookname()+"\","+"\""+inhistory+"\"]";
			}
		}
		if (i > 0) {
			s=s+"]}";
		}else {
			s=s+"{\"data\":["+"[\"  \","+"\"  \","+"\"对不起\","+"\"未搜索到，请重试！\","+"\"  \","+"\"  \"]]}";
		}
		return s;
	}
	//显示借阅某一项具体信息
	public String jsonBorrowChakan(BorrowInfo borrowInfo) {
		String level = (borrowInfo.getLevel()==1)?"工作者":"学生";
		int tem = borrowInfo.getInhistory();
		String inhistory ="";
		if (tem == 1) inhistory = "借过已还"; 
		else if (tem == 0) inhistory = "借过未还";
		else if(tem == -1) inhistory = "申请借书中"; 
		else inhistory = "申请还书中";
		String s = "{\"data\":["+"[\"用户编号\",\""+borrowInfo.getUid()+"\"],"
				+"[\"用户姓名\",\""+borrowInfo.getName()+"\"],"
				+"[\"用户身份\",\""+level+"\"],"
				+"[\"图书编号\",\""+borrowInfo.getBid()+"\"],"
				+"[\"图书名称\",\""+borrowInfo.getBookname()+"\"],"
				+"[\"图书作者\",\""+borrowInfo.getWriter()+"\"],"
				+"[\"图书出版社\",\""+borrowInfo.getPublication()+"\"],"
				+"[\"借出时间\",\""+borrowInfo.getBorrowTime()+"\"],"
				+"[\"还书时间\",\""+borrowInfo.getReturnTime()+"\"],"
				+"[\"借阅情况\",\""+inhistory+"\"]"+"]}";
		return s;
	}
	//显示用户列表的信息
		public String jsonUserList(List<User> list,String userLoginUid) {
			String s = "";
			int i = 0;boolean flag = true;
			for (i = 0; i < list.size(); i++) {
				if (list.get(i).getUid().equals(userLoginUid)) continue; 
				User user = list.get(i);
				String level = (user.getLevel()==2)?"管理员":(user.getLevel()==1)?"工作者":"学生";
				if(i == 0){
					s=s+"{\"data\":["+"[\""+user.getUid()+"\","+"\""+user.getName()+"\","+"\""+user.getPassword()+"\","+
					"\""+user.getTel()+"\","+"\""+level+"\"]";
				}else {
					s=s+",[\""+user.getUid()+"\","+"\""+user.getName()+"\","+"\""+user.getPassword()+"\","+
							"\""+user.getTel()+"\","+"\""+level+"\"]";
				}
			}
			if (i > 0 && s.length() > 1) {
				s=s+"]}";
			}else {
				s=s+"{\"data\":["+"[\"  \","+"\"  \","+"\"对不起\","+"\"未搜索到，请重试！\","+"\"  \"]]}";
			}
			return s;
		}
		//显示图书具体查看列表的信息
		public String jsonUserChakan(User user) {
			String level = (user.getLevel()==2)?"管理员":(user.getLevel()==1)?"工作者":"学生";
			String s = "{\"data\":["+"[\"用户编号\",\""+user.getUid()+"\"],"
						+"[\"用户名称\",\""+user.getName()+"\"],"
						+"[\"用户密码\",\""+user.getPassword()+"\"],"
						+"[\"用户电话\",\""+user.getTel()+"\"],"
						+"[\"用户身份\",\""+level+"\"]"+"]}";
			return s;
		}
}
