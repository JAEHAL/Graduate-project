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

import com.project.dao.MenuDAO;
import com.project.dao.MenuWeekDAO;
import com.project.dto.MenuVO;
import com.project.dto.MenuWeekVO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/Menu.do")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.do");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MenuDAO mDao = MenuDAO.getInstance();
		MenuWeekDAO mDao2 = MenuWeekDAO.getInstance();
		
		List<MenuVO> menuList = mDao.selectInSungMenu();
		List<MenuVO> menuList1 = mDao.selectHwanMenu();
		List<MenuVO> menuList2 = mDao.selectDormMenu();
		List<MenuWeekVO> menuList3 = mDao2.selectMenuWeek(); 
		
		HttpSession session = request.getSession();
		session.setAttribute("menuList", menuList);
		session.setAttribute("menuList1", menuList1);
		session.setAttribute("menuList2", menuList2);
		session.setAttribute("menuList3", menuList3);
		
		request.setAttribute("menuList", menuList);
		request.setAttribute("menuList1", menuList1);
		request.setAttribute("menuList2", menuList2);
		request.setAttribute("menuList3", menuList3);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Menu.jsp");
		dispatcher.forward(request, response);
		
		}
}