package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AdminIdSearchDAO;
import com.project.dto.ForuseVO;

/**
 * Servlet implementation class Admin_Search_stuid_Servlet
 */
@WebServlet("/Admin_Use_Search.do")
public class AdminUseIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUseIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "Admin_Use_View.jsp";
		
		String stu_id = request.getParameter("stu_id");
		
		AdminIdSearchDAO aSdao = AdminIdSearchDAO.getInstance();
		int result = aSdao.Use_stu_id_Check(stu_id);
		
		if(result == 1){
			List<ForuseVO> admin_use_list = aSdao.useInfo(stu_id);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("useInfo", admin_use_list);
			url="Admin_Use_View.jsp";
		}
		
		else if(result == -1){
			request.setAttribute("message", "존재하지 않는 학번입니다.");
		}
		else if(result == 0){
			request.setAttribute("message", "존재하지 않는 학번입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}