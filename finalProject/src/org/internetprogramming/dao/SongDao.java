package org.internetprogramming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.internetprogramming.db.JdbcUtil;
import org.internetprogramming.model.SongBean;

public class SongDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setConnection() {
		conn = JdbcUtil.getConnection();
	}
	
	public void closeConnection() {
		JdbcUtil.close(conn);
	}
	
	public List<SongBean> getPresentList(){
		setConnection();
		
		List<SongBean> sList = null;
		String sql = "select * from rank";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sList = new ArrayList<>();
				do{
					SongBean data = new SongBean();
					data.setTitle(rs.getString("title"));
					data.setArtist(rs.getString("artist"));
					data.setRanking(rs.getInt("ranking"));
					sList.add(data);
				}while(rs.next());
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
		return sList;
	}
}
