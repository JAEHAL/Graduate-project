<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dao.AdminSoldMenuDAO" %>

<%
	request.setCharacterEncoding("utf-8");
	String mn_sold_name = request.getParameter("mn_sold_name");
	String mn_sold_chain = request.getParameter("mn_sold_chain");
	String mn_sold_check = request.getParameter("mn_sold_check");
%>

<%
	AdminSoldMenuDAO mDo = AdminSoldMenuDAO.getInstance();
	mDo.mn_sold_management(mn_sold_name, mn_sold_chain, mn_sold_check);
%>