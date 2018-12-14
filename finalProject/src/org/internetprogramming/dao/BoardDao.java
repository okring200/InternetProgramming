package org.internetprogramming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.internetprogramming.db.JdbcUtil;
import org.internetprogramming.model.BoardBean;

public class BoardDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setConnection() {
		conn = JdbcUtil.getConnection();
	}
	
	public void closeConnection() {
		JdbcUtil.close(conn);
	}
	
	public boolean boardInsert(BoardBean board) {
		boolean rst = false;
		
		setConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "INSERT INTO board (uid, subject, content, file, re_lev, re_seq, cnt, date) values (?,?,?,?,?,?,?, now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getUid());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFile());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			int flag = pstmt.executeUpdate();
			if(flag>0) {
				rst= true;
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeConnection();
		
		return rst;
	}
	
	public ArrayList<BoardBean> getBoardList(int start){
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		try {
			setConnection();
			String sql = "select * from board limit ?,10";
			StringBuffer sql1 = new StringBuffer();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (start - 1)*10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean tmp = new BoardBean();
				tmp.setBid(rs.getInt("bid"));
				tmp.setUid(rs.getString("uid"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setFile(rs.getString("file"));
				tmp.setCnt(rs.getInt("cnt"));
				tmp.setRe_lev(rs.getInt("re_lev"));
				tmp.setRe_seq((rs.getInt("re_seq")));
				tmp.setDate(rs.getDate("date"));
				list.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return list;
	}
	
	public ArrayList<BoardBean> getBoardFive(){
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		try {
			setConnection();
			String sql = "select * from board order by bid desc limit 0, 5;";
			StringBuffer sql1 = new StringBuffer();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean tmp = new BoardBean();
				tmp.setBid(rs.getInt("bid"));
				tmp.setUid(rs.getString("uid"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setFile(rs.getString("file"));
				tmp.setCnt(rs.getInt("cnt"));
				tmp.setRe_lev(rs.getInt("re_lev"));
				tmp.setRe_seq((rs.getInt("re_seq")));
				tmp.setDate(rs.getDate("date"));
				list.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return list;
	}
	
	public int getBoardListCount() {
		int rst = 0;
		setConnection();
		
		String sql = "select count(*) from board";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) rst = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return rst;
	}
	
	public BoardBean getDetail(int boardNum) {
		BoardBean tmp = null;
		setConnection();
		
		try {
			String sql = "SELECT * FROM board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				tmp = new BoardBean();
				tmp.setBid(rs.getInt("bid"));
				tmp.setUid(rs.getString("uid"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setFile(rs.getString("file"));
				tmp.setCnt(rs.getInt("cnt"));
				tmp.setRe_lev(rs.getInt("re_lev"));
				tmp.setRe_seq((rs.getInt("re_seq")));
				tmp.setDate(rs.getDate("date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return tmp;
	}
	
	public boolean updateCount(int boardNum) {
		boolean rst = false;
		setConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql = "update board set cnt = cnt + 1 where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int flag =pstmt.executeUpdate();
			if(flag > 0) {
				rst = true;
				conn.commit();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return rst;
	}
}
