package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.dao.StudentDAO;
import com.project.dto.StudentVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Mainpage.jsp");
		//dispatcher.forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="Student_Login_Page.jsp";
		
		String stu_id = request.getParameter("stu_id");
		String stu_pw = request.getParameter("stu_pw");
		
		StudentDAO mDao = StudentDAO.getInstance();
		int result = mDao.userCheck(stu_id, stu_pw);
		
		JSONObject jOb = new JSONObject();
		JSONArray  jArr = new JSONArray();
		
		if(result == 1){
			StudentVO mVo = mDao.getMember(stu_id);
			HttpSession session = request.getSession();
			//String stu_change = request.getParameter("stu_change");
			session.setAttribute("loginUser", mVo);
			session.setAttribute("loginUser1", stu_id); // 학번 저장
			//session.setAttribute("stu_change", stu_change); // 잔액 저장
			url="Student_Main_Page.jsp";
			jOb.put("stu_id", stu_id );
			jOb.put("stu_pw",stu_pw);
			jArr.add(jOb);
			
			System.out.println(jArr);
		}
		
		else if(result == 0){
			request.setAttribute("message", "암호가 맞지 않습니다.");
		}else if(result == -1){
			request.setAttribute("message", "존재하지 않는 학번입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
		/*
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONObject jObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		String jsonData = null;
		//System.out.println("호출됨");
		try{
			DBConnectionTest(jArray,request);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		jObject.put("Mdata", jArray);
		
		jsonData = jObject.toString();
		System.out.println(jObject.toString());
		
		out.print(jsonData);
	}
   	
   	public void DBConnectionTest(JSONArray jArray, HttpServletRequest request) throws ClassNotFoundException, SQLException {
   		Connection conn = getConnection();
   		PreparedStatement pstmt = null;
   		ResultSet rs = null;
   		
   		String stu_id = request.getParameter("stu_id");
   		String stu_pw = request.getParameter("stu_pw");
   		
   		String sql = "select * from student where stu_id=? and stu_pw=?";
   		try{
   			System.out.println("mysql 접속됨");
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setString(1, stu_id);
   			pstmt.setString(2, stu_pw);
   			rs = pstmt.executeQuery();
   			
   			int i = 0;
   			while(rs.next()){
   				JSONObject sObject = new JSONObject();
   				
   				//System.out.println(rs.getString("stu_id"));
   				//System.out.println(rs.getString("stu_pw"));
   				sObject.put("stu_id", rs.getString("stu_id"));
   				sObject.put("stu_pw", rs.getString("stu_pw"));
   				jArray.add(sObject);
   			}
   		} catch(Exception e){
   			e.printStackTrace();
   		}finally{
   			try{
   				pstmt.close();
   				conn.close();
   				rs.close();
   				System.out.println("mysql 끝");
   			}catch(SQLException e){
   				e.printStackTrace();
   			}
   		}
   	}
   	
   	private Connection getConnection() throws ClassNotFoundException, SQLException {
   		Class.forName("org.gjt.mm.mysql.Driver");
   		//데이터베이스 설정
   		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","system");
   		return c;
   	}
   	*/

