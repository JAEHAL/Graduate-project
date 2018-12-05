<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dao.PresentDAO" %>

<%
	request.setCharacterEncoding("utf-8");
	String send_id = request.getParameter("send_id");
	String rec_id = request.getParameter("rec_id");
	String present_price = request.getParameter("present_price");
%>

<%
	PresentDAO mDo = PresentDAO.getInstance();
	mDo.selectPresent(send_id, rec_id, present_price);
%>