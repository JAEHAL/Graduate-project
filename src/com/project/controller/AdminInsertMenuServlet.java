package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AdminInsertMenuDAO;
import com.project.dto.MenuVO;;

/**
 * Servlet implementation class Admin_Menu_Insert_Servlet
 */
@WebServlet("/Admin_Menu_Insert.do")
public class AdminInsertMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertMenuServlet() {
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
		request.setCharacterEncoding("utf-8");
		String mn_id = request.getParameter("mn_id");
		String chain = request.getParameter("chain");
		String date = request.getParameter("date");
		String mn_name = request.getParameter("mn_name");
		String mn_price = request.getParameter("mn_price");
		String mn_type = request.getParameter("mn_type");
		String mn_sold = request.getParameter("mn_sold");
		
		MenuVO mVo = new MenuVO();
		mVo.setMn_id(mn_id);
		mVo.setChain(chain);
		mVo.setDate(date);
		mVo.setMn_name(mn_name);
		mVo.setMn_price(Integer.parseInt(mn_price));
		mVo.setMn_type(mn_type);
		mVo.setMn_sold(mn_sold);
		
		AdminInsertMenuDAO mDao = AdminInsertMenuDAO.getInstance();
		int result = mDao.admin_Menu_Insert(mVo);
		
		HttpSession session = request.getSession();
		
		if(result==1){
			session.setAttribute("mn_id", mVo.getMn_id());
			session.setAttribute("chain", mVo.getChain());
			session.setAttribute("date", mVo.getDate());
			session.setAttribute("mn_name", mVo.getMn_name());
			session.setAttribute("mn_price", mVo.getMn_price());
			session.setAttribute("mn_type", mVo.getMn_type());
			session.setAttribute("mn_sold", mVo.getMn_sold());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_Menu_Insert.jsp");
		dispatcher.forward(request, response);
	}

}
