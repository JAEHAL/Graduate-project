package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.project.dto.ForuseVO;

public class AdminViewUseDAO {

	private AdminViewUseDAO(){
		
	}
	
	private static AdminViewUseDAO instance = new AdminViewUseDAO();
	
	public static AdminViewUseDAO getInstance() {
		return instance;
	}
	
	//커넥션얻어오기
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	//쓴내역 보여주기
	public List<ForuseVO> selectUse (HttpServletRequest request) {
		
		String sql = "select * from foruse where f_use='사용' order by date desc";
		List<ForuseVO> list1 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list1.add(mVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return list1;
	}
	
	//충전내역
	public List<ForuseVO> selectRecharge (HttpServletRequest request) {
		
		String sql = "select * from foruse where f_use='충전' order by date desc";
		List<ForuseVO> list2 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list2.add(mVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return list2;
	}
}
