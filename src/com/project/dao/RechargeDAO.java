package com.project.dao;
//String radioValue = request.getParameter("밸류값이름")
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.project.dto.RechargeVO;

public class RechargeDAO {
	
	public class getCalender{
		public String cc(){
			
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
		}
	}
	
	private RechargeDAO(){
			
		}
	
	private static RechargeDAO instance = new RechargeDAO();
	
	public static RechargeDAO getInstance() {
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
	
	
	//버튼눌럿을때 value값 받아오기 
	//해당 로그인 아이디와 리차지테이블 조인
	
	//스튜던트 테이블의 잔액과 밸류값을 더하고
	//그런 다음에 해당 로그인 잔액 추가됨.
	
	//1000원을 라디오 버튼으로 설정했을
	
	//안드로이드 충전하기
	public int selectRecharge(String stu_id1, String recharge_money1) {
		
		int result = -1;
		
		//recharge_money = request.getParameter("recharge_money");
		//stu_id = request.getParameter("stu_id");
		
		String sql1 = "update student set stu_change = stu_change + ? where stu_id=?";
		String sql2 = "insert into foruse(stu_id, date, mn_price, f_use) values (?, ?, ?, '충전')";
		
		Connection conn =null;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2 = null;
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
					
		    pstmt1.setString(1, recharge_money1);
		    pstmt1.setString(2, stu_id1);
		    
		    pstmt2.setString(1, stu_id1);
		    pstmt2.setString(2, a);
		    pstmt2.setString(3, recharge_money1);
		    
		    result = pstmt1.executeUpdate();
		    result = pstmt2.executeUpdate();
			
			conn.commit();
		
				
		}catch(Exception e)
		{	
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt1 != null) pstmt1.close();
				if(conn != null) conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
		return result;
	}
	/*
	//충전하기
	public int getValueRecharge_mn(RechargeVO mRVo, HttpServletRequest request) 
	{
		int result =-1;
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		//String sql3= "select stu_id from student where stu_id=? "
		//String sql = "INSERT INTO recharge(stu_id, date, recharge_mn) VALUES (?,?,?)";
		String sql = "update student set stu_change = stu_change + ?  where stu_id=?";
		String sql2 = "insert into foruse(stu_id, date, mn_price, f_use) values (?,?,?,'충전')";
		
		Connection conn =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt2 = null;
		
		//getCalender gc = new getCalender();
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		 
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
					
		    pstmt.setInt(1, mRVo.getRecharge_mn());
		    pstmt.setString(2, loginUser1);
		    
		    pstmt2.setString(1, loginUser1);
		    pstmt2.setString(2, a);
		    pstmt2.setInt(3, mRVo.getRecharge_mn());
		    
			result = pstmt.executeUpdate();
			result = pstmt2.executeUpdate();
			
			conn.commit();
				
		}catch(Exception e)
		{	
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
			return result;
	}
	*/
}