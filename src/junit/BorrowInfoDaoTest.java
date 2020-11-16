package junit;

import java.util.List;

import org.junit.Test;

import cbf.dao.BorrowInfoDao;
import cbf.domain.BorrowInfo;

public class BorrowInfoDaoTest {
	@Test
	public void testSave() throws Exception {// 添加一个名叫小飞的学生
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = new BorrowInfo();
		borrowInfo.setUid("12345");
		borrowInfo.setBid("12345");
		borrowInfo.setBorrowTime("2012-03-23");
		borrowInfo.setReturnTime("2015-4-3");
		borrowInfo.setInhistory(1);
		boolean b = borrowInfoDao.save(borrowInfo);
		System.out.println("save="+b);
	}
	@Test
	public void testGetAll() throws Exception {// 得到数据库中全部的学生
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		String sql = "select borrowinfo.bid,books.bookname,books.writer,"
				+"books.publication,borrowinfo.uid,user.name,user.level,"
				+"borrowinfo.borrowtime,borrowinfo.returntime,borrowinfo.ishistory"
				+" from books,user,borrowinfo where borrowinfo.uid=user.uid and borrowinfo.bid = books.bid"
				+" order by bid desc";
		List<BorrowInfo> borrowInfos = borrowInfoDao.getAll(sql);
		for (BorrowInfo borrowInfo : borrowInfos) {
			System.out.println(borrowInfo.getUid()+" "+borrowInfo.getBid());
		}
	}
	@Test
	public void testfind_UidSid() throws Exception {
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = borrowInfoDao.find_UidSid("12345", "4");
		System.out.println(borrowInfo.getUid()+" "+borrowInfo.getBid());
	}
	@Test
	public void testFindSid() throws Exception { // 根据学生编号查询借书信息
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = borrowInfoDao.find_Sid("123");
		System.out.println(borrowInfo.getUid()+" "+borrowInfo.getBid());
	}
	@Test
	public void testFindBid() throws Exception { // 根据图书编号查询借书信息
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = borrowInfoDao.find_Bid("4");
		System.out.println(borrowInfo.getUid()+" "+borrowInfo.getBid());
	}
	@Test
	public void testUpdate() throws Exception { // 修改某一相关信息相关信息
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		BorrowInfo borrowInfo = new BorrowInfo();
		borrowInfo.setUid("12345");
		borrowInfo.setBid("12345");
		borrowInfo.setBorrowTime("1000-03-23");
		borrowInfo.setReturnTime("0000-4-3");
		borrowInfo.setInhistory(0);
		boolean b = borrowInfoDao.update(borrowInfo);
		System.out.println("update="+b);
	}
	@Test
	public void testDelete() throws Exception { // 删除某一同学
		BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
		boolean b = borrowInfoDao.delete("12345","12345");
		System.out.println("delete="+b);
	}
}
