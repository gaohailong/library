package cbf.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import cbf.dao.BookDao;
import cbf.dao.BorrowInfoDao;
import cbf.dao.UserDao;
import cbf.domain.Book;
import cbf.domain.BorrowInfo;
import cbf.domain.User;

public class BRunctionService {
	//处理借书
	public boolean successBorrow(User user,Book book) {
		int userLevel = user.getLevel();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String borrowTime = df.format(new Date());
		
		BookDao bookDao = new BookDao();
		book.setIsBorrowed(1);
		boolean a = bookDao.update(book);
		
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = new BorrowInfo();
		
		borrowInfo.setUid(user.getUid());
		borrowInfo.setBid(book.getBid());
		borrowInfo.setBorrowTime(borrowTime);
		borrowInfo.setReturnTime("");
		if (userLevel == 1){
			borrowInfo.setInhistory(0);
		} 
		else borrowInfo.setInhistory(-1);//申请借书
		
		boolean b = false;
		if (borrowInfoDao.find_UidSid(user.getUid(), book.getBid()) == null) {
			b = borrowInfoDao.save(borrowInfo);
		}else {
			borrowInfo.setReturnTime("");
			b = borrowInfoDao.update(borrowInfo);
		}
		
//		System.out.println("a="+a+" b="+b);
		
		if (a && b) {
			return true;
		}else {
			book.setIsBorrowed(0);
			bookDao.update(book);
			return false;
		}
	}
	//确认学生借书的申请
		public boolean successBorrow(BorrowInfo borrowInfo) {
			BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
			int ishistory = borrowInfo.getInhistory();
			
			boolean b = false;
			
			if (ishistory == -1){
				borrowInfo.setInhistory(0);
				b = borrowInfoDao.update(borrowInfo);
			}
			
			if (b) {
				return true;
			}else {
				borrowInfo.setInhistory(ishistory);
				borrowInfoDao.update(borrowInfo);
				return false;
			}
		}
	//处理还书
	public boolean successReturn(BorrowInfo borrowInfo) {//参数待定
		UserDao userDao = new UserDao();
		User user = userDao.find(borrowInfo.getUid());
		int userLevel = user.getLevel();
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.find(borrowInfo.getBid());
		book.setIsBorrowed(0);
		boolean a = bookDao.update(book);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String returnTime = df.format(new Date());
		
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		borrowInfo.setReturnTime(returnTime);
		if (userLevel == 1){
			borrowInfo.setInhistory(1);
		} 
		else borrowInfo.setInhistory(-2);//申请还书
		boolean b = borrowInfoDao.update(borrowInfo);
		
//		System.out.println("a="+a+" b="+b);
		
		if (a && b) {
			return true;
		}else {
			book.setIsBorrowed(1);
			bookDao.update(book);
			borrowInfo.setInhistory(0);
			borrowInfoDao.update(borrowInfo);
			return false;
		}
	}

	//确认学生或者工作者还书的申请
	public boolean successReturn_1(BorrowInfo borrowInfo) {//参数待定
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		int ishistory = borrowInfo.getInhistory();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String returnTime = df.format(new Date());
		
		boolean b = false;
		int level = borrowInfo.getLevel();
		if (level == 1) {
			if (ishistory == 0){
				borrowInfo.setInhistory(1);
				borrowInfo.setReturnTime(returnTime);
				b = borrowInfoDao.update(borrowInfo);
			}
		}
		if (level == 0) {
			if (ishistory == -2){
				borrowInfo.setInhistory(1);
				borrowInfo.setReturnTime(returnTime);
				b = borrowInfoDao.update(borrowInfo);
			}
		}
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.find(borrowInfo.getBid());
		book.setIsBorrowed(0);
		boolean a = bookDao.update(book);
		
		if (a && b) {
			return true;
		}else {
			borrowInfo.setInhistory(ishistory);
			borrowInfo.setReturnTime("");
			borrowInfoDao.update(borrowInfo);
			book.setIsBorrowed(1);
			bookDao.update(book);
			return false;
		}
	}
}
