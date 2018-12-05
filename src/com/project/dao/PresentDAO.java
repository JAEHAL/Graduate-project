package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PresentDAO {
	
	public class getCalender{
		public String cc(){
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
		}
	}
	
	private PresentDAO() {
		
	}
	
	private static PresentDAO instance = new PresentDAO();
	
	public static PresentDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}
	
	//안드로이드 선물하기
	public int selectPresent(String send_id, String rec_id, String present_price) {
		int result = -1;
		
		String sql1 = "update student set stu_change = stu_change - ? where stu_id = ?";
		String sql2 = "update student set stu_change = stu_change + ? where stu_id = ?";
		String sql3 = "insert into foruse(stu_id, date, mn_price, f_use) values(?, ?, ?, '선물')";
		
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		Date d= new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			
			pstmt1.setString(1, present_price);
			pstmt1.setString(2, send_id);
			
			pstmt2.setString(1, present_price);
			pstmt2.setString(2, rec_id);
			
			pstmt3.setString(1, send_id);
			pstmt3.setString(2, a);
			pstmt3.setString(3, present_price);
			
			result = pstmt1.executeUpdate();
			result = pstmt2.executeUpdate();
			result = pstmt3.executeUpdate();
			
			conn.commit();
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt1 != null) pstmt1.close();
				if(conn != null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
