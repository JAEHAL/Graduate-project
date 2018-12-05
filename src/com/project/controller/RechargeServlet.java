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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.project.dao.StudentDAO;
import com.project.dto.RechargeVO;
import com.project.dto.StudentVO;

/**
 * Servlet implementation class MenuRcgServlet
 */
@WebServlet("/Recharge.do")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Connection getConnection() throws Exception {
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
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Main_Page.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		request.setCharacterEncoding("UTF-8");
		

		//HttpSession session =request.getSession(false);

		String stu_id= request.getParameter("stu");
		String date = request.getParameter("date");
		String recharge_mn =request.getParameter("recharge_mn");
		String stu_change = request.getParameter("stu_change");
		String f_use = request.getParameter("f_use");
		String mn_pirce = request.getParameter("recharge_mn");
		
		RechargeVO mRVo = new RechargeVO();
		UsageVO mUVo = new UsageVO();
		mRVo.setStu_id(stu_id);
		mRVo.setDate(date);
		mRVo.setRecharge_mn(Integer.parseInt(recharge_mn));
		mUVo.setDate(date);
		mUVo.setStu_id(stu_id);
		mUVo.setF_use(f_use);
		mUVo.setMn_price(Integer.parseInt(mn_pirce));
		
		StudentDAO mSDao = StudentDAO.getInstance();
		RechargeDAO mRdao = RechargeDAO.getInstance();
		int result = mRdao.getValueRecharge_mn(mRVo);
		
		HttpSession session = request.getSession();
		
		if(result == 1)
		{
			//MenuRcgVO mRVo = mRdao.getValueRecharge_mn(mRVo)
			session.setAttribute("stu",mRVo.getStu_id());
			session.setAttribute("date", mRVo.getDate());
			session.setAttribute("recharge_mn", mRVo.getRecharge_mn());
			StudentVO mSVo = mSDao.getMember(stu_id);
			session.setAttribute("loginUser", mSVo);
			session.setAttribute("mn_price", mRVo.getRecharge_mn());			
		}
		*/
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		//String sql = "INSERT INTO recharge(stu_id, date, recharge_mn) VALUES (?,?,?)";//나중에 지우기
		String sql2 = "insert into foruse(stu_id, date, mn_price, f_use) values (?,?,?,'충전')";
		String sql3 = "update student set stu_change = stu_change + ?  where stu_id=?";
		String recharge_mn = request.getParameter("recharge_mn");
		
		RechargeVO mRvo = new RechargeVO();
		mRvo.setRecharge_mn(Integer.parseInt(recharge_mn));
		
		Connection conn =null;
		//PreparedStatement pstmt =null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		//getCalender gc = new getCalender();
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		StudentDAO mDao = StudentDAO.getInstance();
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			//pstmt= conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);
			pstmt2 = conn.prepareStatement(sql3);

			pstmt1.setString(1, loginUser1);
		    pstmt1.setString(2, a);
		    pstmt1.setInt(3, mRvo.getRecharge_mn());
					
		    pstmt2.setInt(1, mRvo.getRecharge_mn());
		    pstmt2.setString(2, loginUser1);
		    
		    //pstmt3.setString(1, loginUser1);
		    //pstmt3.setString(2, a);
		    //pstmt3.setInt(3, mRvo.getRecharge_mn());
		    
			//pstmt.executeUpdate();
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			
			conn.commit();
			
			StudentVO mVo = mDao.getMember(loginUser1);
			session.setAttribute("loginUser", mVo);
			
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Recharge.jsp");
		dispatcher.forward(request, response);
	}
}