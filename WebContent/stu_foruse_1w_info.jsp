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
	List<ForuseVO> SelectUseOneWeek = mDao.SelectUseOneWeek(stu_id);
	
	JSONArray foruseArray = new JSONArray();
	
		for(int i=0; i<SelectUseOneWeek.size(); i++){
			JSONObject foruseObj = new JSONObject();
			
			foruseObj.put("stu_id", SelectUseOneWeek.get(i).getStu_id());
		  	foruseObj.put("date", SelectUseOneWeek.get(i).getDate());
			foruseObj.put("chain", SelectUseOneWeek.get(i).getChain());
			foruseObj.put("mn_name", SelectUseOneWeek.get(i).getMn_name());
			foruseObj.put("mn_price", SelectUseOneWeek.get(i).getMn_price());
			foruseObj.put("f_use", SelectUseOneWeek.get(i).getF_use());
			foruseArray.add(foruseObj);
		}
		
		out.print(foruseArray);
			
%>