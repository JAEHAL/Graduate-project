package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.ForuseVO;

public class AdminIdSearchDAO {

	private AdminIdSearchDAO(){
		
	}
	
	private static AdminIdSearchDAO instance = new AdminIdSearchDAO();
	
	public static AdminIdSearchDAO getInstance() {
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
	
	//사용내역에서의 학번 검색
	public int Use_stu_id_Check(String stu_id){
		int result = -1;
		String sql = "select * from foruse where f_use='사용' and stu_id=? order by date desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("stu_id")!= null && rs.getString("stu_id").equals(stu_id)){
					result = 1;
				}
				else{
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
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//사용내역 정보 가져오기(테이블)
	public List<ForuseVO> useInfo (String stu_id) {
		
		String sql = "select * from foruse where f_use='사용' and stu_id = ? order by date desc";
		List<ForuseVO> list1 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			
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
	
	//충전내역에서의 학번 검색
	public int Recharge_stu_id_Check(String stu_id){
		int result = -1;
		String sql = "select * from foruse where f_use='충전' and stu_id=? order by date desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("stu_id")!= null && rs.getString("stu_id").equals(stu_id)){
					result = 1;
				}
				else{
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
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//충전내역 정보 가져오기(테이블)
	public List<ForuseVO> rechargeInfo (String stu_id) {
		
		String sql = "select * from foruse where f_use='충전' and stu_id = ?  order by date desc";
		List<ForuseVO> list2 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			
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
	
	//안드로이드 사용내역 
	public List<ForuseVO> App_useInfo (String stu_id) {
		
		String sql = "select * from foruse where f_use='사용' and stu_id = ? order by date desc";
		List<ForuseVO> searchList = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					searchList.add(mVo);
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
		return searchList;
	}

}