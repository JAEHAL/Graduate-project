<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>충전 페이지</title>
</head>
<body>
<form method="post" action="Student_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<form method="post" action="Recharge.do"><br><br><br><br>
<table>
	<tr>
		<td>충전 가격</td>
		<td><input type="text" name="recharge_mn" ></td>
	</tr>
</table><br><br><br>
<input type= "submit" value = "등록">
</form>
</body>
</html>