package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AdminPwDAO;
import com.project.dto.AdminPwVO;

/**
 * Servlet implementation class AdminPwServlet
 */
@WebServlet("/AdminPw.do")
public class AdminPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.do");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url="Admin_Menu_Pw.jsp";
		
		String stu_id = request.getParameter("stu_id");
		
		AdminPwDAO Pdao = AdminPwDAO.getInstance();
		int result =Pdao.userPwCheck(stu_id);
		
		if(result==1){
			AdminPwVO mPvo= Pdao.getAdminPw(stu_id);
			request.setAttribute("UserPw", mPvo);
		}
		else if(result == 0){
			request.setAttribute("message","존재하지 않는 학번입니다.");
		}
		else if(result == -1){
			request.setAttribute("message","존재하지 않는 학번입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
