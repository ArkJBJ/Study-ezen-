package servletStudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import servletStudy.util.DBConn;
import servletStudy.vo.BoardVO;

public class BoardDAO {
	
	public List<BoardVO> list(){//게시글 리스트 검색
		
		DBConn dbConn = null;
		List<BoardVO> list = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			dbConn = new DBConn();
			conn = dbConn.connection();
			String sql = "select * from board where bdelyn = 'N' ";
			sql += "limit 0, 20 ";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setBtitle(rs.getString("btitle"));
				boardVO.setBindex(rs.getInt("bindex"));
				boardVO.setBcount(rs.getInt("bcount"));
				boardVO.setBftype(rs.getString("bftype"));
				boardVO.setBstype(rs.getString("bstype"));
				boardVO.setBdate(rs.getString("bdate"));
				list.add(boardVO);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(conn, psmt, rs);
		}
		
		return list;
	}
	
}
