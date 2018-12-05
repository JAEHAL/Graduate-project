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

import com.project.dao.AdminViewUseDAO;
import com.project.dto.ForuseVO;

/**
 * Servlet implementation class AdminViewUseServlet
 */
@WebServlet("/AdminViewUse.do")
public class AdminViewUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewUseServlet() {
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
		String url = "Admin_Foruse_View.jsp";
		AdminViewUseDAO Avdao = AdminViewUseDAO.getInstance();
		
		List<ForuseVO> ad_use = Avdao.selectUse(request);
		List<ForuseVO> ad_recharge = Avdao.selectRecharge(request);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("ad_use", ad_use);
		session.setAttribute("ad_recharge", ad_recharge);
		
		request.setAttribute("ad_use", ad_use);
		request.setAttribute("ad_recharge", ad_recharge);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
