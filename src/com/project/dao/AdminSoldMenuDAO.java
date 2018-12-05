package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminSoldMenuDAO {
	private AdminSoldMenuDAO() {
		
	}
	
	private static AdminSoldMenuDAO instance = new AdminSoldMenuDAO();
	
	public static AdminSoldMenuDAO getInstance() {
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
	
	//안드로이드 매진 관리
	public int mn_sold_management(String mn_name, String chain, String sold_check) {
		
		int result = -1;
		
		String sql = "update menu set mn_sold = ? where mn_name = ? and chain = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sold_check);
			pstmt.setString(2, mn_name);
			pstmt.setString(3, chain);
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
