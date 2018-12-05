package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.MenuWeekVO;

public class MenuWeekDAO {
			
	private MenuWeekDAO(){
		
	}
	
	private static MenuWeekDAO instance = new MenuWeekDAO();
	
	public static MenuWeekDAO getInstance() {
		return instance;
	}
	
	//커넥션 얻어오기
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	//주간 메뉴
	public List<MenuWeekVO> selectMenuWeek() { 
		
		String sql = "select * from menu where date >= date_add(curdate(), interval (dayofweek(curdate())-2)*- 1 day) order by date";
		List<MenuWeekVO> list3 = new ArrayList<MenuWeekVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuWeekVO mVo = new MenuWeekVO();
				mVo.setDate(rs.getString("date"));
				mVo.setChain(rs.getString("chain"));
				mVo.setMn_type(rs.getString("mn_type"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				list3.add(mVo);// Arraylist추가
			} // while문끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list3;
	}
}
