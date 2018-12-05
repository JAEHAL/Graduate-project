<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loginUser2}">
	<jsp:forward page='Admin.do' />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>
<form method="post" action="Admin_Login_Page.jsp">
<input type="submit" value="뒤로"></form>
<form method="post" action="Admin_Menu_Insert.jsp">
<input type="submit" value="메뉴 등록"></form>
<form method="post" action="AdminMenuWeek.do">
<input type="submit" value="메뉴 보기"></form>
<form method="post" action="Admin_Menu_Pw.jsp">
<input type="submit" value="비밀번호 찾기"></form>
<form method="post" action="AdminViewUse.do">
<input type="submit" value="사용내역"></form>
<form method="post" action="AdminInsungTot.do">
<input type="submit" value="정산"></form>
<div style="position:absolute; top:10px; left:370px">
<p>${loginUser2.ad_name}</p>
<form method="post" action="Admin_Login_Page.jsp"><input type="submit" value="로그아웃"></form>
</div>
</body>
</html>