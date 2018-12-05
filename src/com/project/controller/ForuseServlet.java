package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.project.dao.StudentDAO;
import com.project.dto.StudentVO;

/**
 * Servlet implementation class UsageServlet
 */
@WebServlet("/Usage.do")
public class ForuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForuseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Connection getConnection1() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("loginsuccess.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		request.setCharacterEncoding("utf-8");
		
		//String stu_id = request.getParameter("stu");
		String date = request.getParameter("date");
		//String stu_change = request.getParameter("stu_change");
		String stu_id = "201233008";
		//RechargeVO mRVo = new RechargeVO();
		UsageVO mUVo = new UsageVO();
		//mUVo.setStu_id(stu_id);
		mUVo.setDate(date);
		
		
		StudentDAO mSDao = StudentDAO.getInstance();
		UsageDAO mUDao = UsageDAO.getInstance();
		
		int result = mUDao.UseMoney(mUVo);
		
		HttpSession session = request.getSession();
		
		if(result == 1){
			//session.setAttribute("stu", mRVo.getStu_id());
			session.setAttribute("date", mUVo.getDate());
			StudentVO mSVo = mSDao.getMember(stu_id);
			session.setAttribute("loginUser", mSVo);
			session.setAttribute("stu_change", mSVo.getStu_change());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request, response);
		*/
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String) session.getAttribute("loginUser1"); // LoginServlet에서 저장한 학번 불러오기
		//String change = (String) session.getAttribute("stu_change");
		
		//int change2 = Integer.parseInt(change);
		
		String sql = "insert into foruse(stu_id, date, mn_price, f_use) values (?,?,5000,'사용')";
		String sql2 = "update student set stu_change = ? - 5000 where stu_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		Date d= new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		StudentDAO mDao = StudentDAO.getInstance();
		
		try{
			conn = getConnection1();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setString(1, loginUser1);
			pstmt.setString(2, a);
			
			//pstmt2.setInt(1, change2);
			//pstmt2.setString(2, loginUser1);
			pstmt2.setString(1, loginUser1);
			
			/*
			if(change2 < 5000){
				System.out.println("잔액이 부족합니다.");
				conn.rollback();
			}
			*/
			
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			
			conn.commit();
			
			StudentVO mVo = mDao.getMember(loginUser1);
			session.setAttribute("loginUser", mVo);
			
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Info.jsp");
		dispatcher.forward(request, response);
	}
}