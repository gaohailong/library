package cbf.service;

import cbf.dao.UserDao;
import cbf.domain.User;

public class UserService {
	// 用户登陆
	public User loginUser(String userid, String password,int level) {
		UserDao dao = new UserDao();
		User user = dao.find(userid);
//		System.out.println("uid="+userid);
//		System.out.println("password="+password);
//		System.out.println("level="+level);
		if (user == null)
			return null;// 用户名不存在
		// 比较密码
		if (!user.getPassword().equals(password))
			return null;
		if (user.getLevel()!=level) 
			return null;
		return user;
	}

	// 用户注册
	public boolean registerUser(User user) {
		// 判断用户名是否存在
		UserDao dao = new UserDao();
		User bean = dao.find(user.getUid());

		if (bean != null)
			return false;

//		user.setName(user.getName());
//		user.setPassword(user.getPassword());
//		user.setTel(user.getTel());
//		user.setLevel(user.getLevel());
		
		dao.save(user);

		return true;
	}

}
