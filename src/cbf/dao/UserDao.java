package cbf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cbf.domain.User;
import cbf.exception.DaoException;
import cbf.utils.JdbcUtils;

public class UserDao {
	// 添加user
	public boolean save(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into user (uid,name,password,tel,level)"
					+ " values(?,?,?,?,?)";
			// 编译sql
			pstmt = conn.prepareStatement(sql);
			// 替换占位符
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getTel());
			pstmt.setInt(5, user.getLevel());

			int num = pstmt.executeUpdate();
			if (num > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
	// 删除一个user
		public boolean delete(String uid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "delete from user where uid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				// 发送sql
				int num = pstmt.executeUpdate();
				if(num>0)
					return true;
				return false;
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, pstmt, rs);
			}
		}
	// 修改一个user信息
		public boolean update(User user) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "update user set name=?,password=?,tel=?,level=? where uid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getTel());
				pstmt.setInt(4, user.getLevel());
				pstmt.setString(5, user.getUid());
				// 发送sql
				int num = pstmt.executeUpdate();
				if(num>0)
					return true;
				return false;
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, pstmt, rs);
			}
		}
		// 根据学号查找user
		public User find(String uid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = JdbcUtils.getConnection();
				String sql = "select * from user where uid=?";//or name=?";
				pstmt = conn.prepareStatement(sql);	
				pstmt.setString(1, uid);
//				pstmt.setString(2, name);
				rs = pstmt.executeQuery();	
				// 处理结果集
				if(rs.next()) {
					User user = new User();
					user.setUid(rs.getString("uid"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setTel(rs.getString("tel"));
					user.setLevel(rs.getInt("level"));
					return user;
				}
				return null;// 没找到
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, pstmt, rs);
			}
		}
	// 查找所有的user信息
	public List<User> getAll(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
//			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 处理结果
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				// 取出当前记录 封装到 user 存入一个List
				User user = new User();
				user.setUid(rs.getString("uid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setTel(rs.getString("tel"));
				user.setLevel(rs.getInt("level"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
}
