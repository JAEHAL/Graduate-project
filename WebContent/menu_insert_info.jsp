<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.project.dao.AdminInsertMenuDAO" %>

<% 
	request.setCharacterEncoding("utf-8");
	String mn_id = request.getParameter("mn_id");
	String chain = request.getParameter("chain");
	String date = request.getParameter("date");
	String mn_name = request.getParameter("mn_name");
	String mn_price = request.getParameter("mn_price");
	String mn_type = request.getParameter("mn_type");
%>

<% 
	AdminInsertMenuDAO mDo = AdminInsertMenuDAO.getInstance();
	mDo.App_menu_insert(mn_id, chain, date, mn_name, mn_price, mn_type);
%>