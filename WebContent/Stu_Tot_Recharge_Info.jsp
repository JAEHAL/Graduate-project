<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.project.dto.TotForuseVO" %>
<%@ page import="com.project.dao.Stu_TotRechargeDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String stu_id = request.getParameter("stu_id");
	String stu_recharge_check = request.getParameter("use_recharge_edit");
	//System.out.println(stu_id);
%>

<%
	Stu_TotRechargeDAO mDo = Stu_TotRechargeDAO.getInstance();

	List<TotForuseVO> Tot_Recharge_List = mDo.stu_recharge_check_money(stu_id, stu_recharge_check);
	JSONArray TotrechargeArray = new JSONArray();
	
	for(int i=0; i<Tot_Recharge_List.size(); i++){
		JSONObject TotrechargeObj = new JSONObject();
		
		TotrechargeObj.put("stu_recharge_check_price",Tot_Recharge_List.get(i).getR_money());
		TotrechargeArray.add(TotrechargeObj);
	}
	
	out.print(TotrechargeArray);
%>