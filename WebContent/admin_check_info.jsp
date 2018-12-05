<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dao.AdminTotForuseDAO" %>
<%@ page import="com.project.dto.TotForuseVO" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String date = request.getParameter("check_date_edit");
	String chain = request.getParameter("check_chain_edit");
	//System.out.println(date);
	//System.out.println(chain);
%>

<% 
	AdminTotForuseDAO mDo = AdminTotForuseDAO.getInstance();

	List<TotForuseVO> ad_check = mDo.App_Foruse(chain, date);
	
	JSONArray TotadminArray = new JSONArray();
	
	for(int i=0; i<ad_check.size(); i++){
		JSONObject Totcheck_object = new JSONObject();
		
		Totcheck_object.put("check_price", ad_check.get(i).getR_money());
		TotadminArray.add(Totcheck_object);
	}
	out.print(TotadminArray);
%>