<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    .tabWrap { width: 900px; height: 500px; margin:30px; }
    .tab_Menu { margin: 0px; padding: 0px; list-style: none; }
    .tabMenu { width: 150px; margin: 0px; text-align: center;
               padding-top: 10px; padding-bottom: 10px; float: left; }
    .tabMenu a { color: #000000; font-weight: bold; text-decoration: none; }
    .current { background-color: #FFFFFF;
               border: 1px solid black; border-bottom:hidden; }
    .tabPage { width: 900px; height: 470px; float: left;
               border: 1px solid black; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>생활관 정산 페이지</title>
<script src="https://blog.jquery.com/2012/08/09/jquery-1-8-released/"></script>
</head>
<body>
<form method="post" action="Admin_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<center>
<div class="tabWrap">
    <ul class="tab_Menu">
        <li class="tabMenu">
            <a href="#tabContent01" >인성관</a>
        </li>
        <li class="tabMenu">
            <a href="#tabContent02" >환경과학대학</a>
        </li>
        <li class="tabMenu current">
            <a href="#tabContent03" >생활관</a>
        </li>
    </ul>
    
    <!-- 인성관 -->
    <div class="tab_Content_Wrap">
        <div id="tabContent01" class="tabPage">
            <div id="TAB2" style="text-align:center">		
            <br><br>
				 <table align="center" cellpadding="20px">
				 <tr><td>
				 <form method="post" action="AdminInsungTot.do">
				 <input type="text" name="revenue">
				 <input type="submit" value="조회">
				 </form>
				 </td></tr>
				 <tr><td>원하는 월 입력 : ex)2017-07</td></tr>
				 <c:forEach var="Ad_rm" items="${ad_rm}">
            	 <tr>
            	 <td>월별 매출 : ${Ad_rm.r_money}</td>
            	 </tr>
				 </c:forEach>
				 </table>
				 <hr>
				 <center>
				 <table>
				 <tr><td>인성관 인기메뉴</td></tr>
				 <c:forEach var="Insung_no" items="${Insung}">
				 <tr>
				 <td>${Insung_no.mn_name}</td>
				 </tr>
				 </c:forEach>
				 </table>
				 </center>
				 </div>
				 </div>
				 
		<!-- 환과대 -->		 
        <div id="tabContent02" class="tabPage">
            <div id="TAB2" style="text-align:center">		
            	 <br><br>
				 <table align="center" cellpadding="20px">
				 <tr><td>
				 <form method="post" action="AdminHwanTot.do">
				 <input type="text" name="revenue">
				 <input type="submit" value="조회">
				 </form>
				 </td></tr>
				 <tr><td>원하는 월 입력 : ex)2017-07</td></tr>
				 <c:forEach var="Hw_rm" items="${hw_rm}">
            	 <tr>
            	 <td>월별 매출 : ${Hw_rm.r_money}</td>
            	 </tr>
				 </c:forEach>
				 </table>
				 <hr>
				 <center>
				 <table>
				 <tr><td>환과대 인기메뉴</td></tr>
				 <c:forEach var="Hwan_no" items="${Hwan}">
				 <tr>
				 <td>${Hwan_no.mn_name}</td>
				 </tr>
				 </c:forEach>
				 </table>
				 </center>
				 </div>
				 </div>
				 
		<!-- 생활관 -->
        <div id="tabContent03" class="tabPage">
            <div id="TAB2" style="text-align:center">		
				 <br><br>
				 <table align="center" cellpadding="20px">
				 <tr><td>
				 <form method="post" action="AdminDormTot.do">
				 <input type="text" name="revenue">
				 <input type="submit" value="조회">
				 </form>
				 </td></tr>
				 <tr><td>원하는 월 입력 : ex)2017-07</td></tr>
				 <c:forEach var="do_rm" items="${Do_rm}">
            	 <tr>
            	 <td>월별 매출 : ${do_rm.r_money}</td>
            	 </tr>
				 </c:forEach>
				 </table>
				 <hr>
				 <center>
				 <table>
				 <tr><td>생활관 인기메뉴</td></tr>
				 <c:forEach var="Dorm" items="${Dorm_no}">
				 <tr>
				 <td>${Dorm.mn_name}</td>
				 </tr>
				 </c:forEach>
				 </table>
				 </center>
				 </div>
				 </div>
        </div>
     </div>
</center>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.0.min.js" ></script>
<script type="text/javascript">
    function tabSetting() {
        // 탭 컨텐츠 hide 후 현재 탭메뉴 페이지만 show
        $('.tabPage').hide();
        $($('.current').find('a').attr('href')).show();
 
        // Tab 메뉴 클릭 이벤트 생성
        $('li').click(function (event) {
            var tagName = event.target.tagName; // 현재 선택된 태그네임
            var selectedLiTag = (tagName.toString() == 'A') ? $(event.target).parent('li') : $(event.target); // A태그일 경우 상위 Li태그 선택, Li태그일 경우 그대로 태그 객체
            var currentLiTag = $('li[class~=current]'); // 현재 current 클래그를 가진 탭
            var isCurrent = false; 
             
            // 현재 클릭된 탭이 current를 가졌는지 확인
            isCurrent = $(selectedLiTag).hasClass('current');
             
            // current를 가지지 않았을 경우만 실행
            if (!isCurrent) {
                $($(currentLiTag).find('a').attr('href')).hide();
                $(currentLiTag).removeClass('current');
 
                $(selectedLiTag).addClass('current');
                $($(selectedLiTag).find('a').attr('href')).show();
            }
 
            return false;
        });
    }
 
    $(function () {
        // 탭 초기화 및 설정
        tabSetting();
    });
</script>
</body>
</html>