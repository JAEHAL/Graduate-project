<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 비밀번호 찾기</title>
</head>
<body>
<form method="post" action="Admin_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<br><br><br>
<form method="post" action="AdminPw.do">
<center><h1>비밀번호 찾기</h1></center><br><br>
<table cellpadding="10px">
 	<tr>
		<td width="40%">학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;번</td>
		<td><input type="text" name="stu_id" size="20"></td>
	</tr>
	<tr>
		<td>이름</td>	
		<td>${UserPw.stu_name}</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${UserPw.stu_pw}</td>
	</tr>	
	</table><br>
	
	<input type="submit" value="찾기">
<!-- 	<a href='#' onclick="history.go(0)">새로고침</a> -->
	<h2>${message}</h2>
</form>
</body>
</html>