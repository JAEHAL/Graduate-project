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

import com.project.dao.AdminTotForuseDAO;
import com.project.dto.MenuVO;
import com.project.dto.TotForuseVO;

/**
 * Servlet implementation class AdminTotForuseServlet
 */
@WebServlet("/AdminInsungTot.do")
public class AdminInsungTotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsungTotServlet() {
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
	
		String url = "Admin_InsungTot_Foruse.jsp";
		
		String revenue = request.getParameter("revenue");
		
		AdminTotForuseDAO aDao = AdminTotForuseDAO.getInstance();
		
		List<TotForuseVO> ad_rm = aDao.ForuseInsung(revenue);
		List<MenuVO> Insung = aDao.FavoriteInsungMenu(revenue);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Ad_rm", ad_rm);
		session.setAttribute("Insung_no", Insung);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}