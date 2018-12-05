package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.AdminPwVO;

public class AdminPwDAO {
	private AdminPwDAO(){	
	}
	
	private static AdminPwDAO instance = new AdminPwDAO();
	public static AdminPwDAO getInstance() {
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
	//private String ad_id;
	//private String ad_pw;
	public int userPwCheck(String stu_id){
		
		int result = -1;
		String sql="select * from student where stu_id=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("stu_id")!=null && rs.getString("stu_id").equals(stu_id)){
					result=1;
				}
				else {
					result = 0;
				}
			} else {
					result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null)conn.close();			
					}catch(Exception e){
						e.printStackTrace();
					}
	
				}
			return result;
		}
	
	public AdminPwVO getAdminPw(String stu_id)
	{
		//String getId=idEmployee.getText();
		//int id= Integer.parseInt(getId);
		AdminPwVO apv=null;
		String sql = "select * from student where stu_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try{
			
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				apv= new AdminPwVO();
				apv.setStu_id(rs.getString("stu_id"));
				apv.setStu_pw(rs.getString("stu_pw"));
				apv.setStu_name(rs.getString("stu_name"));
		
				} 	
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!= null) rs.close();
					if(pstmt!= null)pstmt.close();
					if(conn != null)conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return apv;	
		}
	
	//안드로이드 비번 찾기
	public List<AdminPwVO> findPw(String stu_id){
		
		String sql = "select * from student where stu_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		ArrayList<AdminPwVO> pwList = new ArrayList<AdminPwVO>();
		try{
			
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			
			rs= pstmt.executeQuery();
			while(rs.next()){
				AdminPwVO aVo = new AdminPwVO();
				aVo.setStu_id(rs.getString("stu_id"));
				aVo.setStu_pw(rs.getString("stu_pw"));
				aVo.setStu_name(rs.getString("stu_name"));
				pwList.add(aVo);
				} 	
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!= null) rs.close();
					if(pstmt!= null)pstmt.close();
					if(conn != null)conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return pwList;
	}
}