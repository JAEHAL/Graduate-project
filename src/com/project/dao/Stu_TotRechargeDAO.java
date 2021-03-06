package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.project.dto.TotForuseVO;

public class Stu_TotRechargeDAO {
	private Stu_TotRechargeDAO() {
		
	}

	private static Stu_TotRechargeDAO instance = new Stu_TotRechargeDAO();
	
	public static Stu_TotRechargeDAO getInstance() {
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
	
	//학생 충전 금액 조회
	public List<TotForuseVO> rm (String Re_revenue, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql = "select sum(mn_price) from foruse where f_use='충전' and stu_id =? and date like concat(?,'%')";
		List<TotForuseVO> list2 = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUser1);
			pstmt.setString(2, Re_revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotForuseVO uVo = new TotForuseVO();
				uVo.setR_money(rs.getInt("sum(mn_price)"));
				list2.add(uVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list2;
	}
	
	//안드로이드 학생 충전 금액 조회
	public List<TotForuseVO> stu_recharge_check_money (String stu_id, String use_recharge_check_edit) {
		
		String sql = "select sum(mn_price) from foruse where f_use='충전' and stu_id =? and date like concat(?,'%')";
		List<TotForuseVO> list3 = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, use_recharge_check_edit);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotForuseVO uVo = new TotForuseVO();
				uVo.setR_money(rs.getInt("sum(mn_price)"));
				list3.add(uVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list3;
	} 

}