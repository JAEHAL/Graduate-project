<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loginUser}">
	<jsp:forward page='Login.do' />
</c:if>
<%-- <%
	String stu_id = request.getParameter("stu_id");
	String stu_pw = request.getParameter("stu_id");
	String stu_name = request.getParameter("stu_id");
	String stu_change = request.getParameter("stu_id");
%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login success page</title>
</head>
<body>
<form method="post" action="Student_Login_Page.jsp">
<input type="submit" value="뒤로"></form>
<div style="position:absolute; top:10px; left:370px">
<a href="Student_Info.jsp"><p>${loginUser.stu_name}</p></a>
<form method="post" action="Student_Login_Page.jsp"><input type="submit" value="로그아웃"></form>
</div>
		<form method="post" action="Menu.do">
		<input type="submit" value="메뉴보기"></form>
		<form method="post" action="Student_Recharge.jsp">
		<input type="submit" value="충전하기"></form>
		<form method="post" action="ViewUse.do">
		<input type="submit" value="사용내역"></form>
		<form method="post" action="ViewRecharge.do">
		<input type="submit" value="충전내역"></form>
</body>
</html>