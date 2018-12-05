package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.MenuVO;

public class AdminInsertMenuDAO {
	private AdminInsertMenuDAO(){
		
	}
	
	private static AdminInsertMenuDAO instance = new AdminInsertMenuDAO();
	
	public static AdminInsertMenuDAO getInstance() {
		return instance;
	}
	
	//커넥션을 얻어오는 메소드
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	//메뉴 등록 메소드
	public int admin_Menu_Insert(MenuVO mVo) {
		int result = -1;
		String sql = "insert into menu(mn_id, chain, date, mn_name, mn_price, mn_type, mn_sold) values(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getMn_id());
			pstmt.setString(2, mVo.getChain());
			pstmt.setString(3, mVo.getDate());
			pstmt.setString(4, mVo.getMn_name());
			pstmt.setInt(5, mVo.getMn_price());
			pstmt.setString(6, mVo.getMn_type());
			pstmt.setString(7, mVo.getMn_sold());
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//안드로이드 메뉴 등록
	public int App_menu_insert(String mn_id, String chain, String date, String mn_name, String mn_price, String mn_type){
		
		int result = -1;
		
		String sql = "insert into menu(mn_id, chain, date, mn_name, mn_price, mn_type) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mn_id);
			pstmt.setString(2, chain);
			pstmt.setString(3, date);
			pstmt.setString(4, mn_name);
			pstmt.setString(5, mn_price);
			pstmt.setString(6, mn_type);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
