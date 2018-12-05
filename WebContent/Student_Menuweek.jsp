<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주간 메뉴</title>
</head>
<body>
<form method="post" action="Student_Menu.jsp">
<input type="submit" value="뒤로"></form>
<center>
<h1>주간 메뉴</h1>
<table style="width=2000; table-layout:fixed;" borderColor=#000000 cellSpacing=0 cellPadding=0 border=1 align="center">
<tr>
	<th>일자</th><th>장소</th><th>종류</th><th>메뉴명</th><th>가격</th>
</tr>
<c:forEach var="menu" items="${menuList3}">
<tr>
<td>${menu.date}</td>
<td>${menu.chain}</td>
<td>${menu.mn_type}</td>
<td>${menu.mn_name}</td>
<td>${menu.mn_price}</td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>