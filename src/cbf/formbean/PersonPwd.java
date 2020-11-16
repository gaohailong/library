package cbf.formbean;

import java.util.HashMap;
import java.util.Map;

import cbf.dao.UserDao;
import cbf.domain.User;

public class  PersonPwd {
	private String password0;
	private String password;
	private String repassword1;
	private Map<String,String> errors = new HashMap<String,String>();	// 封装所有的错误信息   {username=用户名格式错， password=密码不一致}
	
	public String getPassword0() {
		return password0;
	}

	public void setPassword0(String password0) {
		this.password0 = password0;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword1() {
		return repassword1;
	}

	public void setRepassword1(String repassword1) {
		this.repassword1 = repassword1;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

		// 校验
		public boolean validate(String uid) {
			User user = new UserDao().find(uid);
			boolean isOK = true;
			// 密码校验
			if(this.password0==null || this.password0.equals("")) {
				this.errors.put("password", "旧密码不能为空");
				isOK = false;
			}else if (!user.getPassword().equals(password0)) {
				this.errors.put("password", "旧密码不正确");
				isOK = false;
			}else if(this.password==null || this.password.equals("")) {
				this.errors.put("password", "新密码不能为空");
				isOK = false;
			}else if(this.repassword1==null || this.repassword1.equals("")) {
				this.errors.put("password", "再次输入新密码不能为空");
				isOK = false;
			}else if(!this.repassword1.equals(this.password)) {
				this.errors.put("password", "两次新密码输入不一致");
				isOK = false;
			}
			return isOK;
		}
}
