<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dto.AdminPwVO" %>
<%@ page import="com.project.dao.AdminPwDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONArray" %>

<%
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("stu_id");
%>

<%
	AdminPwDAO mDo = AdminPwDAO.getInstance();
	List<AdminPwVO> pwlist = mDo.findPw(stu_id);
	
	JSONArray jArr = new JSONArray();
	
	for(int i=0; i<pwlist.size(); i++){
		JSONObject Object = new JSONObject();
		Object.put("stu_id",pwlist.get(i).getStu_id());
		Object.put("stu_name",pwlist.get(i).getStu_name());
		Object.put("stu_pw",pwlist.get(i).getStu_pw());
		jArr.add(Object);
	}
	
	out.print(jArr);
%>