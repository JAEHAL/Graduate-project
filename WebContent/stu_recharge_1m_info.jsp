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
	List<ForuseVO> SelectRechargeOneMonth = mDao.SelectRechargeOneMonth(stu_id);
	
	JSONArray RechargeArray = new JSONArray();
	
		for(int i=0; i<SelectRechargeOneMonth.size(); i++){
			JSONObject RechargeObj = new JSONObject();
			
			RechargeObj.put("stu_id", SelectRechargeOneMonth.get(i).getStu_id());
			RechargeObj.put("date", SelectRechargeOneMonth.get(i).getDate());
			RechargeObj.put("chain", SelectRechargeOneMonth.get(i).getChain());
			RechargeObj.put("mn_name", SelectRechargeOneMonth.get(i).getMn_name());
			RechargeObj.put("mn_price", SelectRechargeOneMonth.get(i).getMn_price());
			RechargeObj.put("f_use", SelectRechargeOneMonth.get(i).getF_use());
			RechargeArray.add(RechargeObj);
		}
		
		out.print(RechargeArray);
			
%>