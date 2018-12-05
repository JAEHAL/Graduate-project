<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loginUser}">
	<jsp:forward page='Login.do' />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Information page</title>
</head>
<body>
<form method="post" action="Student_Main_Page.jsp">
<input type="submit" value="뒤로"></form><br><br>
<table cellpadding="20px" style="position:relative; left: 150px; top:20px;">
	<tr>
		<td>이름 : </td>
		<td>${loginUser.stu_name}</td>
	</tr>
	<tr>
		<td>학번 : </td>
		<td>${loginUser.stu_id}</td>
	</tr>
	<tr>
		<td>잔액 : </td>
		<td>${loginUser.stu_change}</td>
	</tr>
</table>
<!-- <div style="position:absolute; left:180px; bottom:40px"> -->
<!-- <img src="C:\Users\wogk1\Desktop\2017-1학기\졸작/1.png" width=150px height=150px> -->
<!-- </div> -->
<form method="post" action="Usage.do">
<input type="submit" value="사용">
</form>
</body>
</html>