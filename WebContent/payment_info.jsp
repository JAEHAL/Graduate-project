<%@ page import="com.project.dao.RechargeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.project.dao.ForuseDAO"%>

<%
	request.setCharacterEncoding("utf-8");
	String payment_date = request.getParameter("payment_date");
	String payment_mn_name = request.getParameter("payment_mn_name");
	String payment_mn_type = request.getParameter("payment_mn_type");
	String payment_chain = request.getParameter("payment_chain");
	String payment_price = request.getParameter("payment_price");
	String stu_id = request.getParameter("stu_id");
%>

<%
	ForuseDAO mDo = ForuseDAO.getInstance();
	mDo.UseMoney(stu_id, payment_date, payment_mn_name, payment_mn_type, payment_chain, payment_price);//, request);
%>