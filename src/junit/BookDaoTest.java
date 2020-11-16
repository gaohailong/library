package junit;

import java.util.List;

import org.junit.Test;

import cbf.dao.BookDao;
import cbf.domain.Book;

public class BookDaoTest {
	@Test
	public void testSave() throws Exception {// 添加一个名叫小飞的学生
		BookDao bookDao = new BookDao();
		Book book = new Book();
		book.setBid("12345");
		book.setBookname("程序设计");
		book.setWriter("111-222-333");
		book.setPublication("12345");
		boolean b = bookDao.save(book);
		System.out.println("save="+b);
	}
	@Test
	public void testGetAll() throws Exception {// 得到数据库中全部的学生
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getAll("select * from books");
		for (Book book : books) {
			System.out.println(book.getBid()+" "+book.getBookname());
		}
	}
	@Test
	public void testFind() throws Exception { // 根据编号找到某一位学生
		BookDao bookDao = new BookDao();
		Book book = bookDao.find("12345");
		System.out.println(book.getBookname());
	}
	@Test
	public void testUpdate() throws Exception { // 修改某一相关信息相关信息
		BookDao bookDao = new BookDao();
		Book book = new Book();
		book.setBid("12345");
		book.setBookname("小飞");//修改xiaofei->小飞
		book.setWriter("111-222-333");
		book.setPublication("1110");
		book.setIsBorrowed(1);
		boolean b = bookDao.update(book);
		System.out.println("update="+b);
	}
	@Test
	public void testDelete() throws Exception { // 删除某一同学
		BookDao bookDao = new BookDao();
		boolean b = bookDao.delete("12345");
		System.out.println("delete="+b);
	}
}
