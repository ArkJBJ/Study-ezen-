package servletStudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import servletStudy.util.DBConn;
import servletStudy.vo.MemberVO;

public class MemberDAO {
	
	public List<MemberVO> list(){
		
		DBConn dbConn = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<MemberVO> list = null;
		
		try {
			//1.DB연결
			dbConn = new DBConn();
			conn = dbConn.connection();
			
			//2.sql구문 작성
			String sql = "select * from member ";
			
			//3.테이블 조회
			psmt = dbConn.psmt(sql, conn);
			rs = psmt.executeQuery();
			
			//4.List로 가공
			list = new ArrayList<>();
			while(rs.next()) {
				MemberVO memberVo = new MemberVO();
				memberVo.setMaddr(rs.getString("maddr"));
				memberVo.setMdelyn(rs.getString("mdelyn"));
				memberVo.setMenter(rs.getString("menter"));
				memberVo.setMgrade(rs.getString("mgrade"));
				memberVo.setMid(rs.getString("mid"));
				memberVo.setMname(rs.getString("mname"));
				memberVo.setMnum(rs.getInt("mnum"));
				//memberVo.setMperiod(rs.getString("mperiod"));
				memberVo.setMphone(rs.getString("mphone"));
				//memberVo.setMreason(rs.getString("mreason"));
				
				list.add(memberVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(conn, psmt, rs);
		}
		
		return list;
	}
}
