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

import com.project.dao.MenuWeekDAO;
import com.project.dto.MenuWeekVO;
/**
 * Servlet implementation class MenuWeekServlet
 */
@WebServlet("/MenuWeek.do")
public class MenuWeekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuWeekServlet() {
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
		MenuWeekDAO mDao = MenuWeekDAO.getInstance();
		
		List<MenuWeekVO> menuList3 = mDao.selectMenuWeek();
		
		HttpSession session = request.getSession();
		session.setAttribute("menuList3", menuList3);
		
		request.setAttribute("menuList3", menuList3);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Menuweek.jsp");
		dispatcher.forward(request, response);
	}

}
