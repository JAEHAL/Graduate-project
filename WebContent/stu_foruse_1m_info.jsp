<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.json.simple.JSONArray" %>
    <%@ page import="com.project.dao.ViewUseDAO"%>
    <%@ page import="com.project.dto.ForuseVO" %>
	<%@ page import="org.json.simple.JSONObject" %>
	<%@ page import="java.util.List" %>

<%
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("stu_id");
%>

<%
	ViewUseDAO mDao = ViewUseDAO.getInstance();
	List<ForuseVO> SelectUseOneMonth = mDao.SelectUseOneMonth(stu_id);
	
	JSONArray foruseArray = new JSONArray();
	
		for(int i=0; i<SelectUseOneMonth.size(); i++){
			JSONObject foruseObj = new JSONObject();
			
			foruseObj.put("stu_id", SelectUseOneMonth.get(i).getStu_id());
		  	foruseObj.put("date", SelectUseOneMonth.get(i).getDate());
			foruseObj.put("chain", SelectUseOneMonth.get(i).getChain());
			foruseObj.put("mn_name", SelectUseOneMonth.get(i).getMn_name());
			foruseObj.put("mn_price", SelectUseOneMonth.get(i).getMn_price());
			foruseObj.put("f_use", SelectUseOneMonth.get(i).getF_use());
			foruseArray.add(foruseObj);
		}
		
		out.print(foruseArray);
			
%>