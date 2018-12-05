<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.project.dao.AdminTotForuseDAO" %>
<%@ page import="com.project.dto.TotMenuVO" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>

<% 
	request.setCharacterEncoding("utf-8");
	String date = request.getParameter("check_date_edit");
	String chain = request.getParameter("check_chain_edit");
%>

<% 
	AdminTotForuseDAO mDo = AdminTotForuseDAO.getInstance();

	List<TotMenuVO> fv_check_list = mDo.App_FavoriteMenu(chain, date);
	
	JSONArray TotadminArray = new JSONArray();
	
	for(int i=0; i<fv_check_list.size(); i++){
		JSONObject fv_menuobject = new JSONObject();
		
		fv_menuobject.put("mn_name", fv_check_list.get(i).getMn_name());
		fv_menuobject.put("fv_count",fv_check_list.get(i).getFv_count());
		TotadminArray.add(fv_menuobject);
	}
	out.print(TotadminArray);
%>