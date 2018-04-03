package alarmloadsearchDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import alarmloadsearchVo.AlarmVo;
import mysiteVo.UserVo;

public class AlarmDao {
public boolean delete(AlarmVo alarmVo) {
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt=null;
		int count = 0;
		try {
			// 1. driver loading
			Class.forName( "com.mysql.jdbc.Driver" );
			
			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
		    conn = DriverManager.getConnection(url,"kimys","kim111");
			
			// 3. SQL臾� �떎�뻾
			
			String sql = "delete from webdb where no=?";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1,alarmVo.getNo());			
			count = pstmt.executeUpdate();
					 
			
		} catch (ClassNotFoundException e) {
			System.out.println( "�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e );			 
		} catch ( SQLException e ){
			e.printStackTrace();
		} finally {			
			try {
				if( rs != null){
					rs.close();
				}
				if( pstmt != null){
					pstmt.close();
				}
				if( conn != null){
					conn.close();
				}
			} catch (SQLException e) {				 
				e.printStackTrace();
			}
		}
		return (count == 1);	
		
	}
public boolean insert(AlarmVo alarmVo) {
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt=null;
		int count = 0;
		try {
			// 1. driver loading
			Class.forName( "com.mysql.jdbc.Driver" );
			
			// 2. connection �븯湲�
			String url = "jdbc:mysql://117.17.142.207/webdb";
		    conn = DriverManager.getConnection(url,"kimys","kim111");
			
			// 3. SQL臾� �떎�뻾
			
			String sql = "insert into webdb values (null,?,?,?,100,?,?)";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,alarmVo.getStartDeparture());
			pstmt.setString(2,alarmVo.getEndDeparture());
			pstmt.setString(3,alarmVo.getPromiseDay());
			
			pstmt.setString(4,alarmVo.getStartTime());
			pstmt.setString(5, alarmVo.getWay());
			count = pstmt.executeUpdate();
					 
			
		} catch (ClassNotFoundException e) {
			System.out.println( "�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e );			 
		} catch ( SQLException e ){
			e.printStackTrace();
		} finally {			
			try {
				if( rs != null){
					rs.close();
				}
				if( pstmt != null){
					pstmt.close();
				}
				if( conn != null){
					conn.close();
				}
			} catch (SQLException e) {				 
				e.printStackTrace();
			}
		}
		return (count == 1);	
		
	}
public List<AlarmVo> getList() {
	List<AlarmVo> list = new ArrayList<AlarmVo>();
	
	ResultSet rs = null;
	Statement stmt = null;
	Connection conn = null;
	try {
		// 1. driver loading
		Class.forName( "com.mysql.jdbc.Driver" );
		
		// 2. connection �븯湲�
		String url = "jdbc:mysql://117.17.142.207/webdb";
	    conn = DriverManager.getConnection(url,"kimys","kim111");
		
		// 3. SQL臾� �떎�뻾
		stmt = conn.createStatement();
		
		String sql = "select startdeparture,enddeparture,promiseday,promisetime,starttime,way,no from webdb";
		rs = stmt.executeQuery(sql);
		
		// 4. 寃곌낵 泥섎━
		while( rs.next() ){
			String sd=rs.getString(1);
			String ed=rs.getString(2);
			String pd=rs.getString(3);
			String pt=rs.getString(4);
			String st=rs.getString(5);
			String way=rs.getString(6);
			int no=rs.getInt(7);
			AlarmVo vo=new AlarmVo();
			vo.setStartDeparture(sd);
			vo.setEndDeparture(ed);
			vo.setPromiseDay(pd);
			vo.setPromiseTime(pt);
			vo.setStartTime(st);
			vo.setWay(way);
			vo.setNo(no);
			list.add( vo );
		}			 
		
	} catch (ClassNotFoundException e) {
		System.out.println( "�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣: " + e );			 
	} catch ( SQLException e ){
		e.printStackTrace();
	} finally {			
		try {
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
		
	return list;
}

}
