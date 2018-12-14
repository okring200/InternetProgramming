package org.internetprogramming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.internetprogramming.db.JdbcUtil;
import org.internetprogramming.model.KpopBean;

public class KpopDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setConnection() {
		conn = JdbcUtil.getConnection();
	}
	
	public void closeConnection() {
		JdbcUtil.close(conn);
	}
	
	public ArrayList<KpopBean> getKpopList(int year){
		ArrayList<KpopBean> list = new ArrayList<KpopBean>();

		try {
			setConnection();
			String sql = "select * from song where year = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KpopBean tmp = new KpopBean();
				tmp.setTitle(rs.getString("title"));
				tmp.setArtist(rs.getString("artist"));
				tmp.setYear(year);
				tmp.setRanking(rs.getInt("ranking"));
				list.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeConnection();
		return list;
	}
}
