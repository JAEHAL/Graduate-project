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

import com.project.dto.ForuseVO;

public class ViewUseDAO {

	private ViewUseDAO(){
		
	}
	
	private static ViewUseDAO instance = new ViewUseDAO();
	
	public static ViewUseDAO getInstance() {
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
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql = "select * from foruse where f_use='사용' and stu_id = ? order by date desc Limit 7";
		List<ForuseVO> list1 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
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
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql = "select * from foruse where f_use='충전' and stu_id = ?  order by date desc Limit 7";
		List<ForuseVO> list2 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
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

	//사용 1주일
	public List<ForuseVO> UseOneWeek (HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 7 day)) order by date";
		
		List<ForuseVO> list3 = new ArrayList<ForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list3.add(mVo);
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
		return list3;
	}

	//사용 1개월
	public List<ForuseVO> UseOneMonth (HttpServletRequest request) {
			
		HttpSession session = request.getSession();
			
		String loginUser1 = (String)session.getAttribute("loginUser1");
			
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
			
		List<ForuseVO> list4 = new ArrayList<ForuseVO>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list4.add(mVo);
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
		return list4;
	}

	//사용 3개월
	public List<ForuseVO> UseThreeMonth (HttpServletRequest request) {
		
		HttpSession session = request.getSession();
						
		String loginUser1 = (String)session.getAttribute("loginUser1");
						
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
						
		List<ForuseVO> list5 = new ArrayList<ForuseVO>();
						
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
						
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
							
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list5.add(mVo);
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
		return list5;
	}
				
	//충전1주일
	public List<ForuseVO> RechargeOneWeek (HttpServletRequest request) {
					
		HttpSession session = request.getSession();
					
		String loginUser1 = (String)session.getAttribute("loginUser1");
					
		String sql = "select * from foruse  where f_use='충전' and  stu_id = ? and date > date(subdate(curdate(), interval 7 day)) order by date";
			
		List<ForuseVO> list6 = new ArrayList<ForuseVO>();
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
					
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ForuseVO mVo = new ForuseVO();
				mVo.setStu_id(rs.getString("stu_id"));
				mVo.setDate(rs.getString("date"));
				mVo.setChain(rs.getString("chain"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				mVo.setF_use(rs.getString("f_use"));
				list6.add(mVo);
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
		return list6;
	}
				
	//충전1개월
	public List<ForuseVO> RechargeOneMonth (HttpServletRequest request) {
					
		HttpSession session = request.getSession();
					
		String loginUser1 = (String)session.getAttribute("loginUser1");
					
		String sql = "select * from foruse  where f_use='충전' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
				
		List<ForuseVO> list7 = new ArrayList<ForuseVO>();
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
					
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list7.add(mVo);
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
		return list7;
	}
				
	//충전3개월
	public List<ForuseVO> RechargeThreeMonth (HttpServletRequest request) {
					
		HttpSession session = request.getSession();
					
		String loginUser1 = (String)session.getAttribute("loginUser1");
					
		String sql = "select * from foruse  where f_use='충전' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
		List<ForuseVO> list8 = new ArrayList<ForuseVO>();
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
					
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			while(rs.next()){
					ForuseVO mVo = new ForuseVO();
					mVo.setStu_id(rs.getString("stu_id"));
					mVo.setDate(rs.getString("date"));
					mVo.setChain(rs.getString("chain"));
					mVo.setMn_name(rs.getString("mn_name"));
					mVo.setMn_price(rs.getInt("mn_price"));
					mVo.setF_use(rs.getString("f_use"));
					list8.add(mVo);
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
		return list8;
	}
	
	//안드로이드 사용 1주일
	public List<ForuseVO> SelectUseOneWeek(String stu_id) {
		
		String sql = "select * from foruse  where stu_id=? and f_use='사용' and date > date(subdate(curdate(), interval 7 day)) order by date";
		
		List<ForuseVO> list9 = new ArrayList<ForuseVO>();
		
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
					list9.add(mVo);
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
		return list9;
	}

	//안드로이드 사용 1개월
	public List<ForuseVO> SelectUseOneMonth (String stu_id) {
			
		String sql = "select * from foruse  where stu_id=? and f_use='사용' and date > date(subdate(curdate(), interval 1 month)) order by date";
			
		List<ForuseVO> list10 = new ArrayList<ForuseVO>();
			
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
					list10.add(mVo);
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
		return list10;
	}

	//안드로이드 사용 3개월
	public List<ForuseVO> SelectUseThreeMonth (String stu_id) {
						
		String sql = "select * from foruse where stu_id=? and f_use='사용' and date > date(subdate(curdate(), interval 3 month)) order by date";
						
		List<ForuseVO> list11 = new ArrayList<ForuseVO>();
						
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
					list11.add(mVo);
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
		return list11;
	}

	//안드로이드 충전 1주일
	public List<ForuseVO> SelectRechargeOneWeek (String stu_id) {
		
		String sql = "select * from foruse where stu_id=? and f_use='충전' and date > date(subdate(curdate(), interval 7 day)) order by date";
		
		List<ForuseVO> list12 = new ArrayList<ForuseVO>();
		
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
					list12.add(mVo);
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
		return list12;
	}

	//안드로이드 충전 1개월
	public List<ForuseVO> SelectRechargeOneMonth (String stu_id) {
			
		String sql = "select * from foruse where stu_id=? and f_use='충전' and date > date(subdate(curdate(), interval 1 month)) order by date";
			
		List<ForuseVO> list13 = new ArrayList<ForuseVO>();
			
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
					list13.add(mVo);
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
		return list13;
	}

	//안드로이드 충전 3개월
	public List<ForuseVO> SelectRechargeThreeMonth (String stu_id) {
						
		String sql = "select * from foruse where stu_id=? and f_use='충전' and date > date(subdate(curdate(), interval 3 month)) order by date";
						
		List<ForuseVO> list14 = new ArrayList<ForuseVO>();
						
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
					list14.add(mVo);
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
		return list14;
	}

}