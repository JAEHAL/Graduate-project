package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.MenuVO;
import com.project.dto.TotForuseVO;
import com.project.dto.TotMenuVO;

public class AdminTotForuseDAO {

	private AdminTotForuseDAO() {
		
	}
	
	private static AdminTotForuseDAO instance = new AdminTotForuseDAO();
	
	public static AdminTotForuseDAO getInstance() {
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
	
	//인성관 정산
	public List<TotForuseVO> ForuseInsung(String revenue) {
		
		String sql = "select sum(mn_price) from foruse where f_use='사용' and chain='인성관' and date like concat(?,'%')";
		List<TotForuseVO> list = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotForuseVO tVo = new TotForuseVO();
				tVo.setR_money(rs.getInt("sum(mn_price)"));
				list.add(tVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//인성관 메뉴
	public List<MenuVO> FavoriteInsungMenu(String revenue) {
		
		String sql = "select mn_name, count(*) as FAVORITE from foruse where chain='인성관' and f_use='사용' and date like concat(?,'%') group by mn_name order by count(*) desc limit 5";
		List<MenuVO> list1 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MenuVO mVo = new MenuVO();
				mVo.setMn_name(rs.getString("mn_name"));
				list1.add(mVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list1;
	}
	
	//환과대 정산
	public List<TotForuseVO> ForuseHwan(String revenue) {
		
		String sql = "select sum(mn_price) from foruse where f_use='사용' and chain='환과대' and date like concat(?,'%')";
		List<TotForuseVO> list2 = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotForuseVO tVo = new TotForuseVO();
				tVo.setR_money(rs.getInt("sum(mn_price)"));
				list2.add(tVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list2;
	}
		
	//환과대 메뉴
	public List<MenuVO> FavoriteHwanMenu(String revenue) {
		
		String sql = "select mn_name, count(*) as FAVORITE from foruse where chain='환과대' and f_use='사용' and date like concat(?,'%') group by mn_name order by count(*) desc limit 5";
		List<MenuVO> list3 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MenuVO mVo = new MenuVO();
				mVo.setMn_name(rs.getString("mn_name"));
				list3.add(mVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list3;
	}
	
	//생활관 정산
	public List<TotForuseVO> ForuseDorm(String revenue) {
		
		String sql = "select sum(mn_price) from foruse where f_use='사용' and chain='생활관' and date like concat(?,'%')";
		List<TotForuseVO> list4 = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotForuseVO tVo = new TotForuseVO();
				tVo.setR_money(rs.getInt("sum(mn_price)"));
				list4.add(tVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list4;
	}
	
	//생활관 메뉴
	public List<MenuVO> FavoriteDormMenu(String revenue) {
		
		String sql = "select mn_name, count(*) as FAVORITE from foruse where chain='생활관' and f_use='사용' and date like concat(?,'%') group by mn_name order by count(*) desc limit 5";
		List<MenuVO> list5 = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revenue);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MenuVO mVo = new MenuVO();
				mVo.setMn_name(rs.getString("mn_name"));
				list5.add(mVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list5;
	}
	
	//안드로이드 정산
	public List<TotForuseVO> App_Foruse(String chain, String check_date) {
		
		String sql = "select sum(mn_price) from foruse where f_use='사용' and chain=? and date like concat(?,'%')";
		List<TotForuseVO> checklist = new ArrayList<TotForuseVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chain);
			pstmt.setString(2, check_date);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				TotForuseVO tVo = new TotForuseVO();
				tVo.setR_money(rs.getInt("sum(mn_price)"));
				checklist.add(tVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return checklist;
	}
	
	//안도르이드 인기메뉴
	public List<TotMenuVO> App_FavoriteMenu(String chain, String check_date) {
		
		String sql = "select mn_name, count(*) as FAVORITE from foruse where chain=? and f_use='사용' and date like concat(?,'%') group by mn_name order by count(*) desc limit 5";
		List<TotMenuVO> fv_menulist = new ArrayList<TotMenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chain);
			pstmt.setString(2, check_date);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				TotMenuVO mVo = new TotMenuVO();
				mVo.setMn_name(rs.getString("mn_name"));
				mVo.setFv_count(rs.getInt("FAVORITE"));
				fv_menulist.add(mVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fv_menulist;
	}
}