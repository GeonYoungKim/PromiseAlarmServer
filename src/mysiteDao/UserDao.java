package mysiteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysiteVo.UserVo;

public class UserDao {

	public List<UserVo> getList() {
		List<UserVo> list = new ArrayList<UserVo>();

		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
			conn = DriverManager.getConnection(url, "kimys", "kim111");

			// 3. SQL臾� �떎�뻾
			stmt = conn.createStatement();

			String sql = "select no,name,email,profile from user";
			rs = stmt.executeQuery(sql);

			// 4. 寃곌낵 泥섎━
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String profile = rs.getString(4);
				UserVo userVo = new UserVo();
				userVo.setNo(no);
				userVo.setName(name);
				userVo.setEmail(email);
				userVo.setProfile(profile);

				list.add(userVo);
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

	public UserVo getUser(String email, String password) {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserVo vo = null;

		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
			conn = DriverManager.getConnection(url, "kimys", "kim111");

			// 3. SQL臾� �떎�뻾

			String sql = "select no,name,email from user where email=? and password=password(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email2 = rs.getString(3);

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email2);

			}
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
		return vo;
	}

	public UserVo getUser(Long lo) {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserVo vo = null;

		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
			conn = DriverManager.getConnection(url, "kimys", "kim111");

			// 3. SQL臾� �떎�뻾

			String sql = "select no,name,email,profile from user where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, lo);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email2 = rs.getString(3);
				String profile = rs.getString(4);
				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email2);
				vo.setProfile(profile);

			}
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
		return vo;
	}

	public boolean insert(UserVo userVo) {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
			conn = DriverManager.getConnection(url, "kimys", "kim111");

			// 3. SQL臾� �떎�뻾

			String sql = "insert into user values (null,?,password(?),?,null)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getPassword());
			pstmt.setString(3, userVo.getEmail());

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
}
