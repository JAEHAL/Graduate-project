<%@page import="com.project.dao.RechargeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.project.dao.RechargeDAO" %>

<% 
	request.setCharacterEncoding("utf-8");
	String recharge_money = request.getParameter("recharge_money");
	String stu_id = request.getParameter("stu_id");
	//System.out.println(recharge_money);
%>

<%
	RechargeDAO mDo = RechargeDAO.getInstance();
	mDo.selectRecharge(stu_id, recharge_money);
%>