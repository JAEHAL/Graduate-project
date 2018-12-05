<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.json.simple.JSONArray" %>
    <%@ page import="com.project.dao.MenuDAO"%>
    <%@ page import="com.project.dto.MenuVO" %>
	<%@ page import="org.json.simple.JSONObject" %>
	<%@ page import="java.util.List" %>

	
<%
	MenuDAO mDao = MenuDAO.getInstance();

	List<MenuVO> menuList = mDao.selectMenu();
	
	JSONArray menuArray = new JSONArray();
   
	for(int i=0; i<menuList.size(); i++){
	   
		JSONObject menuObj = new JSONObject();
	   
		menuObj.put("date",menuList.get(i).getDate());
	   	menuObj.put("chain", menuList.get(i).getChain());
	   	menuObj.put("mn_type", menuList.get(i).getMn_type());
	   	menuObj.put("mn_name", menuList.get(i).getMn_name());
	   	menuObj.put("mn_price", menuList.get(i).getMn_price());
	   	menuObj.put("mn_sold", menuList.get(i).getMn_sold());
	   	menuArray.add(menuObj);
	}
   
	out.print(menuArray);

%>