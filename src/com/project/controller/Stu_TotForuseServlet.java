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

import com.project.dao.Stu_TotForuseDAO;
import com.project.dto.TotForuseVO;

/**
 * Servlet implementation class UseExampleServlet
 */
@WebServlet("/Stu_TotForuse.do")
public class Stu_TotForuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_TotForuseServlet() {
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
		
		String url = "Student_TotForuse.jsp";
		
		String revenue = request.getParameter("revenue");
		
		Stu_TotForuseDAO uEdao = Stu_TotForuseDAO.getInstance();
		
		List<TotForuseVO> rm = uEdao.rm(revenue, request);
		HttpSession session = request.getSession();
	
		//Fn_rm이 달러, rm이 var
		session.setAttribute("Fn_rm", rm);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
