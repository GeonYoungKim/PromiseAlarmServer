package mysiteTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 

public class JDBCTest {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		
		try {
			// 1. driver loading
			Class.forName( "com.mysql.jdbc.Driver" );
			
			// 2. connection �븯湲�
			String url = "jdbc:mysql://localhost/webdb";
		    conn = DriverManager.getConnection(url,"webdb","webdb");
			
			// 3. SQL臾� �떎�뻾
			stmt = conn.createStatement();
			
			String sql = "select no,email,name from user";
			rs = stmt.executeQuery(sql);
			
			// 4. 寃곌낵 泥섎━
			while( rs.next() ){
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String email = rs.getString( 3 );
				
				System.out.println( no + " : " + name + " : " + email );
			}			 
			
		} catch (ClassNotFoundException e) {
			System.out.println( "�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e );			 
		} catch ( SQLException e ){
			e.printStackTrace();
		} finally {			
			try {
				if( rs != null){
					rs.close();
				}
				if( stmt != null){
					stmt.close();
				}
				if( conn != null){
					conn.close();
				}
			} catch (SQLException e) {				 
				e.printStackTrace();
			}
		}		 

	}

}
