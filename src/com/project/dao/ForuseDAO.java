package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class ForuseDAO {
	
	/*
	public class getCalender{
		public String cc(){
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
		}
	}
	*/
	
	private ForuseDAO(){
		
	}
	
	private static ForuseDAO instance = new ForuseDAO();
	
	public static ForuseDAO getInstance(){
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
	
	//사용버튼 눌렀을때, stu_change 깎이고, foruse테이블에 사용내역으로 insert
	//사용했을때 동작
	
	public int UseMoney(String stu_id, String date, String mn_name, String mn_type, String chain, String price) {//, HttpServletRequest request){
		
		//HttpSession session = request.getSession();
		
		//String change = (String)session.getAttribute("change");
		//int change2 = Integer.parseInt(change);
		
		int result = -1;
		String sql = "insert into foruse(stu_id, date, chain, mn_name, mn_price, f_use) values (?, ?, ?, ?, ?, '사용')";
		String sql2 = "update student set stu_change = stu_change - ? where stu_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		
		//String b = sVo.getStu_id();
		//String c = mRVo.getStu_id();
		//b=c;
		
		//StudentDAO sDao = new StudentDAO();
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);
			
			pstmt.setString(1, stu_id);
			pstmt.setString(2, date);
			pstmt.setString(3, chain);
			pstmt.setString(4, mn_name);
			pstmt.setString(5, price);
			
			pstmt1.setString(1, price);
			pstmt1.setString(2, stu_id);
			
			result = pstmt.executeUpdate();
			result = pstmt1.executeUpdate();
			
			conn.commit();
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
}