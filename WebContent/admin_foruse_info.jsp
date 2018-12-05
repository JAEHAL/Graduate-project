<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dao.AdminIdSearchDAO" %>
<%@ page import="com.project.dto.ForuseVO" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("search_id");
%>

<% 
	AdminIdSearchDAO mDo = AdminIdSearchDAO.getInstance();
	List<ForuseVO> list = mDo.App_useInfo(stu_id);
	
	JSONArray jArr = new JSONArray();
	
	for(int i=0; i<list.size(); i++){
		JSONObject object = new JSONObject();
		object.put("date",list.get(i).getDate());
		object.put("chain",list.get(i).getChain());
		object.put("mn_name",list.get(i).getMn_name());
		object.put("mn_price",list.get(i).getMn_price());
		jArr.add(object);
	}
	
	out.print(jArr);
%>