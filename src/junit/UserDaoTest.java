package junit;

import java.util.List;

import org.junit.Test;

import cbf.dao.UserDao;
import cbf.domain.User;

public class UserDaoTest {
	@Test
	public void testSave() throws Exception {// 添加一个名叫小飞的学生
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUid("12345");
		user.setName("xiaofei");
		user.setPassword("12345");
		user.setTel("111-222-333");
		boolean b = userDao.save(user);
		System.out.println("save="+b);
	}
	@Test
	public void testGetAll() throws Exception {// 得到数据库中全部的学生
		UserDao userDao = new UserDao();
		String sql = "select * from user order by uid desc";
		List<User> users = userDao.getAll(sql);
		for (User user : users) {
			System.out.println(user.getUid()+" "+user.getName());
		}
	}
	@Test
	public void testFind() throws Exception { // 根据编号找到某一位学生
		UserDao userDao = new UserDao();
		User user = userDao.find("12345");
		System.out.println(user.getName());
	}
	@Test
	public void testUpdate() throws Exception { // 修改某一相关信息相关信息
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUid("12345");
		user.setName("小飞");//修改xiaofei->小飞
		user.setPassword("12345");
		user.setTel("1110");
		user.setLevel(0);
		boolean b = userDao.update(user);
		System.out.println("update="+b);
	}
	@Test
	public void testDelete() throws Exception { // 删除某一同学
		UserDao userDao = new UserDao();
		boolean b = userDao.delete("12345");
		System.out.println("delete="+b);
	}
}
