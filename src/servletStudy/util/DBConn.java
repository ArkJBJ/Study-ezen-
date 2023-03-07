package servletStudy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private String host = "jdbc:mysql://127.0.0.1:3306/singledb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private String userid = "root";
	private String userpw = "1234";
	
	public Connection connection() {//데이터 베이스 연결 메소드
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(host, userid, userpw);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결에러");
		}
		
		return conn;
	}
	
	public PreparedStatement psmt(String sql, Connection conn) {//쿼리문 실행 준비 메소드
		PreparedStatement psmt = null;
		
		try {
			psmt = conn.prepareStatement(sql);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("psmt에러");
		}
		return psmt;
	}
	
	public void close(Connection conn, PreparedStatement psmt) {//DBclose 메소드(결과값 반환 x일때)
		try {
			if(conn != null)conn.close();
			if(psmt != null)psmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {//DBclose 메소드(결과값 반환 o일때)
		try {
			if(conn != null)conn.close();
			if(psmt != null)psmt.close();
			if(rs != null)rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
