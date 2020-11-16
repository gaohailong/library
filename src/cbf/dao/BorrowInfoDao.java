package cbf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cbf.domain.BorrowInfo;
import cbf.exception.DaoException;
import cbf.utils.JdbcUtils;

public class BorrowInfoDao {
	// 添加borrowInfo
	public boolean save(BorrowInfo borrowInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into borrowinfo (uid,bid,borrowtime,returntime,ishistory)"
					+ " values(?,?,?,?,?)";
			// 编译sql
			pstmt = conn.prepareStatement(sql);
			// 替换占位符
			pstmt.setString(1, borrowInfo.getUid());
			pstmt.setString(2, borrowInfo.getBid());
			pstmt.setString(3, borrowInfo.getBorrowTime());
			pstmt.setString(4, borrowInfo.getReturnTime());
			pstmt.setInt(5, borrowInfo.getInhistory());
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

	// 删除一个borrowInfo
	public boolean delete(String sid, String bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from borrowinfo where uid=? and bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			pstmt.setString(2, bid);
			// 发送sql
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

	// 修改一个borrowInfo信息
	public boolean update(BorrowInfo borrowInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update borrowinfo set borrowtime=?,returntime=?,ishistory=? where uid=? and bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, borrowInfo.getBorrowTime());
			pstmt.setString(2, borrowInfo.getReturnTime());
			pstmt.setInt(3, borrowInfo.getInhistory());
			pstmt.setString(4, borrowInfo.getUid());
			pstmt.setString(5, borrowInfo.getBid());
			// 发送sql
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

	// 根据学号查找borrowInfo
	public BorrowInfo find_Sid(String uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from borrowinfo where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			// 处理结果集
			if (rs.next()) {
				BorrowInfo borrowInfo = new BorrowInfo();
				borrowInfo.setUid(rs.getString("uid"));
				borrowInfo.setBid(rs.getString("bid"));
				borrowInfo.setBorrowTime(rs.getString("borrowtime"));
				borrowInfo.setReturnTime(rs.getString("returntime"));
				borrowInfo.setInhistory(rs.getInt("ishistory"));
				return borrowInfo;
			}
			return null;// 没找到
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	// 根据书号查找borrowInfo
	public BorrowInfo find_Bid(String bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from borrowinfo where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			// 处理结果集
			if (rs.next()) {
				BorrowInfo borrowInfo = new BorrowInfo();
				borrowInfo.setUid(rs.getString("uid"));
				borrowInfo.setBid(rs.getString("bid"));
				borrowInfo.setBorrowTime(rs.getString("borrowtime"));
				borrowInfo.setReturnTime(rs.getString("returntime"));
				borrowInfo.setInhistory(rs.getInt("ishistory"));
				return borrowInfo;
			}
			return null;// 没找到
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	// 根据学号和书号查找borrowInfo
		public BorrowInfo find_UidSid(String uid,String bid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = JdbcUtils.getConnection();
				String sql = "select borrowinfo.bid,books.bookname,books.writer,"
						+"books.publication,borrowinfo.uid,user.name,user.level,"
						+"borrowinfo.borrowtime,borrowinfo.returntime,borrowinfo.ishistory"
						+" from books,user,borrowinfo"
						+" where borrowinfo.uid=user.uid and borrowinfo.bid = books.bid"
						+" and borrowinfo.uid=? and borrowinfo.bid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				pstmt.setString(2, bid);
				rs = pstmt.executeQuery();
				// 处理结果集
				if (rs.next()) {
					BorrowInfo borrowInfo = new BorrowInfo();
					borrowInfo.setUid(rs.getString("uid"));
					borrowInfo.setName(rs.getString("name"));
					borrowInfo.setLevel(rs.getInt("level"));
					
					borrowInfo.setBid(rs.getString("bid"));
					borrowInfo.setBookname(rs.getString("bookname"));
					borrowInfo.setWriter(rs.getString("writer"));
					borrowInfo.setPublication(rs.getString("publication"));
					
					borrowInfo.setBorrowTime(rs.getString("borrowtime"));
					borrowInfo.setReturnTime(rs.getString("returntime"));
					borrowInfo.setInhistory(rs.getInt("ishistory"));//1表示借过且还了    0借过还没还
					return borrowInfo;
				}
				return null;// 没找到
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, pstmt, rs);
			}
		}
	
	// 查找所有的borrowInfo信息
	public List<BorrowInfo> getAll(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
//			String sql = "select * from borrowinfo";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 处理结果
			List<BorrowInfo> list = new ArrayList<BorrowInfo>();
			while (rs.next()) {
				// 取出当前记录 封装到 borrowInfo 存入一个List
				BorrowInfo borrowInfo = new BorrowInfo();
				borrowInfo.setUid(rs.getString("uid"));
				borrowInfo.setName(rs.getString("name"));
				borrowInfo.setLevel(rs.getInt("level"));
				
				borrowInfo.setBid(rs.getString("bid"));
				borrowInfo.setBookname(rs.getString("bookname"));
				borrowInfo.setWriter(rs.getString("writer"));
				borrowInfo.setPublication(rs.getString("publication"));
				
				borrowInfo.setBorrowTime(rs.getString("borrowtime"));
				borrowInfo.setReturnTime(rs.getString("returntime"));
				borrowInfo.setInhistory(rs.getInt("ishistory"));//1表示借过且还了    0借过还没还
				list.add(borrowInfo);
			}
			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
}
