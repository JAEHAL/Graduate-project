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
	List<ForuseVO> SelectRechargeOneWeek = mDao.SelectRechargeOneWeek(stu_id);
	
	JSONArray RechargeArray = new JSONArray();
	
		for(int i=0; i<SelectRechargeOneWeek.size(); i++){
			JSONObject RechargeObj = new JSONObject();
			
			RechargeObj.put("stu_id", SelectRechargeOneWeek.get(i).getStu_id());
			RechargeObj.put("date", SelectRechargeOneWeek.get(i).getDate());
			RechargeObj.put("chain", SelectRechargeOneWeek.get(i).getChain());
			RechargeObj.put("mn_name", SelectRechargeOneWeek.get(i).getMn_name());
			RechargeObj.put("mn_price", SelectRechargeOneWeek.get(i).getMn_price());
			RechargeObj.put("f_use", SelectRechargeOneWeek.get(i).getF_use());
			RechargeArray.add(RechargeObj);
		}
		
		out.print(RechargeArray);
			
%>