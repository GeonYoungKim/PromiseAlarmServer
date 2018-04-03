package mysiteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mysiteVo.GuestbookVo;
import mysiteVo.UserVo;

public class GuestbookDao {
	public boolean insert(GuestbookVo guestbookVo) {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL臾� �떎�뻾

			String sql = "insert into guestbook values (null,?,now(),?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, guestbookVo.getContent());
			pstmt.setLong(2, guestbookVo.getUserNo());

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (count == 1);
	}

	public boolean delete(Long no) {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL臾� �떎�뻾

			String sql = "delete from guestbook where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (count == 1);
	}

	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();

		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;

		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL臾� �떎�뻾
			stmt = conn.createStatement();

			String sql = "select a.no,a.content,date_format(a.reg_date, '%Y-%m-%d %H:%i:%s') as regDate, b.no as userNo, b.name,b.profile  from guestbook a,user b where a.user_no=b.no order by a.no asc;";
			rs = stmt.executeQuery(sql);

			// 4. 寃곌낵 泥섎━
			while (rs.next()) {
				Long No = rs.getLong(1);
				String content = rs.getString(2);
				String regDate = rs.getString(3);
				Long userNo = rs.getLong(4);
				String userName = rs.getString(5);
				String userProfile = rs.getString(6);
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(No);
				vo.setContent(content);
				vo.setRegDate(regDate);
				vo.setUserNo(userNo);
				vo.setUserName(userName);
				vo.setUserProfile(userProfile);
				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
