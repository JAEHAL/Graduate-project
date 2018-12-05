<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.project.dto.TotForuseVO" %>
<%@ page import="com.project.dao.Stu_TotForuseDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("stu_id");
	String stu_use_check = request.getParameter("use_check_edit");
	//System.out.println(stu_id);
%>

<%
	Stu_TotForuseDAO mDo = Stu_TotForuseDAO.getInstance();

	List<TotForuseVO> Tot_Foruse_List = mDo.stu_foruse_check_money(stu_id, stu_use_check);
	
	JSONArray TotforuseArray = new JSONArray();
	
	for(int i=0; i<Tot_Foruse_List.size(); i++){
		JSONObject TotforuseObj = new JSONObject();
		
		TotforuseObj.put("stu_foruse_check_price",Tot_Foruse_List.get(i).getR_money());
		TotforuseArray.add(TotforuseObj);
	}
	
	out.print(TotforuseArray);
%>