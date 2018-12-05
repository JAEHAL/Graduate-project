<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 등록</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
%>

<form method="post" action="Admin_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<center><h2>메뉴 등록</h2></center>
<form method="post" action="Admin_Menu_Insert.do">
	<table>
		<tr>
			<td>일련 번호</td>
			<td><input type="text" name="mn_id" size="20"></td>
		</tr>
		<tr>
			<td>장소</td>
			<td><input type="text" name="chain" size="20"></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><input type="text" name="date" size="20"></td>
		</tr>
		<tr>
			<td>메뉴명 </td>
			<td><input type="text" name="mn_name" size="20"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text" name="mn_price" size="20"></td>
		</tr>
		<tr>
			<td>종류</td>
			<td><input type="text" name="mn_type" size="20"></td>
		</tr>
		<tr>
			<td>매진</td>
			<td><input type="text" name="mn_sold" size="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="등록">
			<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>