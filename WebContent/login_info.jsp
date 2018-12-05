<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.project.dto.StudentVO" %>
<%@ page import="com.project.dao.StudentDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("stu_id");
	//System.out.println(and_id);
%>

<%
	
	StudentDAO sDao = StudentDAO.getInstance();
	List<StudentVO>userList = sDao.userList(stu_id);

	JSONArray jArr = new JSONArray();
	
	
	for(int i=0; i<userList.size(); i++){
		
		JSONObject userObject = new JSONObject();
		userObject.put("stu_id",userList.get(i).getStu_id());
		userObject.put("stu_pw",userList.get(i).getStu_pw());
		userObject.put("stu_name",userList.get(i).getStu_name());
		userObject.put("stu_change",userList.get(i).getStu_change());
		jArr.add(userObject);
		
	}
	out.print(jArr);
%>