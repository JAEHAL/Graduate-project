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

import com.project.dao.ViewUseDAO;
import com.project.dto.ForuseVO;

/**
 * Servlet implementation class ViewRechargeServlet
 */
@WebServlet("/ViewRecharge.do")
public class ViewRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRechargeServlet() {
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
		String url = "Student_Recharge_View.jsp";
		ViewUseDAO Vdao = ViewUseDAO.getInstance();
		
		List<ForuseVO> use = Vdao.selectUse(request);
		List<ForuseVO> recharge = Vdao.selectRecharge(request);
		List<ForuseVO> use1week = Vdao.UseOneWeek(request);
		List<ForuseVO> use1month = Vdao.UseOneMonth(request);
		List<ForuseVO> use3month = Vdao.UseThreeMonth(request);
		List<ForuseVO> re1week = Vdao.RechargeOneWeek(request);
		List<ForuseVO> re1month = Vdao.RechargeOneMonth(request);
		List<ForuseVO> re3month = Vdao.RechargeThreeMonth(request);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("use", use);
		session.setAttribute("recharge", recharge);
		session.setAttribute("use1week", use1week);
		session.setAttribute("use1month", use1month);
		session.setAttribute("use3month", use3month);
		session.setAttribute("re1week", re1week);
		session.setAttribute("re1month", re1month);
		session.setAttribute("re3month", re3month);
		
		request.setAttribute("use", use);
		request.setAttribute("recharge", recharge);
		request.setAttribute("use1week", use1week);
		request.setAttribute("use1month", use1month);
		request.setAttribute("use3month", use3month);
		request.setAttribute("re1week", re1week);
		request.setAttribute("re1month", re1month);
		request.setAttribute("re3month", re3month);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
