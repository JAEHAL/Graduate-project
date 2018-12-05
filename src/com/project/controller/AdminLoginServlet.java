package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AdminDAO;
import com.project.dto.AdminVO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin.do")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="Admin_Login_Page.jsp";
		
		String ad_id = request.getParameter("ad_id");
		String ad_pw = request.getParameter("ad_pw");
		
		AdminDAO mDao = AdminDAO.getInstance();
		int result = mDao.userCheck(ad_id, ad_pw);
		
		if(result == 1){
			AdminVO mVo = mDao.getAdminMember(ad_id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser2", mVo);
			url="Admin_Main_Page.jsp";
		}
		else if(result == 0){
			request.setAttribute("message", "암호가 맞지 않습니다.");
		}else if(result == -1){
			request.setAttribute("message", "존재하지 않는 관리자 아이디입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
