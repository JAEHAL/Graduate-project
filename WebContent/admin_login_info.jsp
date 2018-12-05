<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.project.dto.AdminVO" %>
<%@ page import="com.project.dao.AdminDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String ad_id = request.getParameter("ad_id");
	//System.out.println(and_id);
%>

<%
	AdminDAO aDo = AdminDAO.getInstance();
	List<AdminVO> adminList = aDo.adminList(ad_id);
	
	JSONArray jArr = new JSONArray();
	
	for(int i=0; i<adminList.size(); i++){
		
		JSONObject adminObject = new JSONObject();
		adminObject.put("ad_id",adminList.get(i).getAd_id());
		adminObject.put("ad_pw",adminList.get(i).getAd_pw());
		adminObject.put("ad_name",adminList.get(i).getAd_name());
		jArr.add(adminObject);
		
	}
	out.print(jArr);
%>