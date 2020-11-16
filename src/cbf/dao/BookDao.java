package cbf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cbf.domain.Book;
import cbf.exception.DaoException;
import cbf.utils.JdbcUtils;

public class BookDao {
	// 添加book
		public boolean save(Book book) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "insert into books (bid,bookname,writer,publication)"
						+ " values(?,?,?,?)";
				// 编译sql
				pstmt = conn.prepareStatement(sql);
				// 替换占位符
				pstmt.setString(1, book.getBid());
				pstmt.setString(2, book.getBookname());
				pstmt.setString(3, book.getWriter());
				pstmt.setString(4, book.getPublication());

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
		// 删除一个book
			public boolean delete(String bid) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = JdbcUtils.getConnection();
					String sql = "delete from books where bid=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bid);
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
		// 修改一个book信息
			public boolean update(Book book) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = JdbcUtils.getConnection();
					String sql = "update books set bookname=?,writer=?,publication=?,isborrowed=? where bid=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, book.getBookname());
					pstmt.setString(2, book.getWriter());
					pstmt.setString(3, book.getPublication());
					pstmt.setInt(4, book.getIsBorrowed());
					pstmt.setString(5, book.getBid());
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
			// 根据学号查找book
			public Book find(String bid) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = JdbcUtils.getConnection();
					String sql = "select * from books where bid=?";//or name=?";
					pstmt = conn.prepareStatement(sql);	
					pstmt.setString(1, bid);
//					pstmt.setString(2, name);
					rs = pstmt.executeQuery();	
					// 处理结果集
					if(rs.next()) {
						Book book = new Book();
						book.setBid(rs.getString("bid"));
						book.setBookname(rs.getString("bookname"));
						book.setWriter(rs.getString("writer"));
						book.setPublication(rs.getString("publication"));
						book.setIsBorrowed(rs.getInt("isBorrowed"));
						return book;
					}
					return null;// 没找到
				} catch (SQLException e) {
					throw new DaoException(e);
				} finally {
					JdbcUtils.release(conn, pstmt, rs);
				}
			}
		// 查找所有的book信息
		public List<Book> getAll(String sql) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = JdbcUtils.getConnection();
//				String sql = "select * from books";
				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();

				// 处理结果
				List<Book> list = new ArrayList<Book>();
				while (rs.next()) {
					// 取出当前记录 封装到 book 存入一个List
					Book book = new Book();
					book.setBid(rs.getString("bid"));
					book.setBookname(rs.getString("bookname"));
					book.setWriter(rs.getString("writer"));
					book.setPublication(rs.getString("publication"));
					book.setIsBorrowed(rs.getInt("isborrowed"));
					list.add(book);
				}
				return list;
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, pstmt, rs);
			}
		}
}
