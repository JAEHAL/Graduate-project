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

import com.project.dao.Stu_TotRechargeDAO;
import com.project.dto.TotForuseVO;

/**
 * Servlet implementation class Stu_TotRechargeServlet
 */
@WebServlet("/Stu_TotRecharge.do")
public class Stu_TotRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_TotRechargeServlet() {
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
	
		String url = "Student_TotRecharge.jsp";
		
		String Re_revenue = request.getParameter("Re_revenue");
		
		Stu_TotRechargeDAO uEdao = Stu_TotRechargeDAO.getInstance();
		
		List<TotForuseVO> Re_rm = uEdao.rm(Re_revenue, request);
		HttpSession session = request.getSession();
	
		//Re_rm이 안볼 페이지에, ""안에 있는 이름이 볼 페이지
		session.setAttribute("Rn_rm", Re_rm);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
