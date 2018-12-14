package org.internetprogramming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.internetprogramming.db.JdbcUtil;
import org.internetprogramming.model.MemberBean;


public class MemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setConnection() {
		conn = JdbcUtil.getConnection();
	}
	
	public void closeConnection() {
		JdbcUtil.close(conn);
	}
	
	public MemberBean selectById(String id) {
		setConnection();
		
		MemberBean member = null;
		String sql = "select * from user where uid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String uid = rs.getString("uid");
				String pw = rs.getString("pw");
				member = new MemberBean();
				member.setUid(uid);
				member.setPw(pw);
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
		return member;
	}
	
	public void insertMember(MemberBean member) {
		setConnection();
		String sql = "insert into user (uid, pw, name) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
	}
	
	public ArrayList<MemberBean> getMemberList(){
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		setConnection();
		String sql = "select * from user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberBean tmp = new MemberBean();
				tmp.setUid(rs.getString("uid"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				list.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
	public void deleteMember(String uid) {
		setConnection();
		String sql = "DELETE FROM user where uid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
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
	} 
}
