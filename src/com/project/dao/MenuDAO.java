package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.MenuVO;

public class MenuDAO {
	
		//get date
		public class getCalender{
		public String cc(){
					
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
				
		}
	}
	private MenuDAO(){
		
	}
	
	private static MenuDAO instance = new MenuDAO();
	
	public static MenuDAO getInstance() {
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
	
	//인성관 메뉴
	public List<MenuVO> selectInSungMenu() {
		
		String sql = "select * from menu";
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("date").equals(gc.cc()) &&rs.getString("chain").equals("인성관"))  {
				MenuVO mVo = new MenuVO();
				mVo.setDate(rs.getString("date"));
				mVo.setMn_type(rs.getString("mn_type"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				mVo.setMn_sold(rs.getString("mn_sold"));
				list.add(mVo);// Arraylist에 추가
				}
			} // while문끝
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
		return list;
	}
	
	//환과대 메뉴
	public List<MenuVO> selectHwanMenu() {
		
		String sql = "select * from menu";
		List<MenuVO> list1 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("date").equals(gc.cc()) &&rs.getString("chain").equals("환과대"))  {
				MenuVO mVo = new MenuVO();
				mVo.setDate(rs.getString("date"));
				mVo.setMn_type(rs.getString("mn_type"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				mVo.setMn_sold(rs.getString("mn_sold"));
				list1.add(mVo);// Arraylist에 추가
				}
			} // while문끝
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
		return list1;
	}
	
	//생활관 메뉴
	public List<MenuVO> selectDormMenu() {
		
		String sql = "select * from menu";
		List<MenuVO> list2 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("date").equals(gc.cc()) &&rs.getString("chain").equals("생활관"))  {
				MenuVO mVo = new MenuVO();
				mVo.setDate(rs.getString("date"));
				mVo.setMn_type(rs.getString("mn_type"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				mVo.setMn_sold(rs.getString("mn_sold"));
				list2.add(mVo);// Arraylist에 추가
				}
			} // while문끝
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
		return list2;
	}
	
	//전체 메뉴
	public List<MenuVO> selectMenu() {
		
		String sql = "select * from menu";
		List<MenuVO> list3 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("date").equals(gc.cc()))  {
				MenuVO mVo = new MenuVO();
				mVo.setDate(rs.getString("date"));
				mVo.setChain(rs.getString("chain"));
				mVo.setMn_type(rs.getString("mn_type"));
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setMn_price(rs.getInt("mn_price"));
				mVo.setMn_sold(rs.getString("mn_sold"));
				list3.add(mVo);// Arraylist에 추가
				}
			} // while문끝
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
		return list3;
	}
}