<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    .tabWrap { width: 900px; height: 1000px; margin:30px; }
    .tab_Menu { margin: 0px; padding: 0px; list-style: none;}
    .tab_Menu1 { margin-left:190px; list-style: none;}
    .tabMenu { width: 150px; margin: 0px; text-align: center;
               padding-top: 10px; padding-bottom: 10px; float: left; }
    .tabMenu1 { width: 150px; margin: 0px; text-align: center;
               padding-top: 10px; padding-bottom: 10px; float: left; }
    .tabMenu a { color: #000000; font-weight: bold; text-decoration: none; }
    .tabMenu1 a { color: #000000; font-weight: bold; text-decoration: none; }
    .current { background-color: #FFFFFF;
               border: 1px solid black;  }
    .tabPage { width: 900px; height: 1000px; float:left; 
               border: 1px solid black; }
    .aa { text-align:center;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usage page</title>
<script src="https://blog.jquery.com/2012/08/09/jquery-1-8-released/"></script>
</head>
<body>
<%
 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd");
 String today = formatter.format(new java.util.Date());
%>
<form method="post" action="Student_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<center>
<div class="tabWrap">
    <ul class="tab_Menu">
        <li class="tabMenu">
            <a href="#tabContent01" >사용 내역</a>
        </li>
        <li class="tabMenu current">
            <a href="#tabContent02" >사용 매출 조회</a>
        </li>
    </ul>
    <div class="tab_Content_Wrap">
    
	<!-- 첫 페이지 화면 // 사용 내역 데이터베이스 목록 7개로 제한-->
    
        <div id="tabContent01" class="tabPage">
        <br><br>
        	<ul class="tab_Menu1">
        		<li class="tabMenu current1">
            		<a href="#tabContent001" >1주일전</a>
        		</li>
        		<li class="tabMenu1">
            		<a href="#tabContent002" >1개월전</a>
        		</li>
        		<li class="tabMenu">
            		<a href="#tabContent003" >3개월전</a>
        		</li>
    		</ul>
    		<div id="TAB2" style="text-align:center">		
            <br><br>
            <br><br>
				 <table style="width=2000; table-layout:fixed;" borderColor=#000000 cellSpacing=0 cellPadding=0 border=1 align="center">
            	 <tr height="50">
				 	<th>일자</th><th>장소</th><th>메뉴명</th><th>사용금액</th>
				 </tr>
				 <c:forEach var="foruse" items="${use}">
				 <tr height=50>
				 <td width=100>${foruse.date}</td>
				 <td width=100>${foruse.chain}</td>
				 <td width=100>${foruse.mn_name}</td>
				 <td width=100>${foruse.mn_price}</td>
				 </tr>
				 </c:forEach>
				 </table>
				 </div>
				 </div>
				 
		<!-- 사용내역에서의 1주일전까지의 목록 화면 // -->
    
		<div id="tabContent001" class="tabPage">
		<br><br>
		<ul class="tab_Menu1">
        		<li class="tabMenu current1">
            		<a href="#tabContent001" >1주일전</a>
        		</li>
        		<li class="tabMenu1">
            		<a href="#tabContent002" >1개월전</a>
        		</li>
        		<li class="tabMenu">
            		<a href="#tabContent003" >3개월전</a>
        		</li>
    		</ul>
            <div id="TAB2" style="text-align:center">
            <br><br>
            <br><br>		
            	 <table style="width=2000; table-layout:fixed;" borderColor=#000000 cellSpacing=0 cellPadding=0 border=1 align="center">
            	 <tr height="50">
				 	<th>일자</th><th>장소</th><th>메뉴명</th><th>사용금액</th>
				 </tr>
				 <c:forEach var="foruse" items="${use1week}">
				 <tr height=50>
				 <td width=100>${foruse.date}</td>
				 <td width=100>${foruse.chain}</td>
				 <td width=100>${foruse.mn_name}</td>
				 <td width=100>${foruse.mn_price}</td>
				 </tr>
				 </c:forEach>
				 </table>
				 </div>
			</div>
					 
			<!-- 사용내역에서의 1개월전까지의 목록 화면 // -->
    
			<div id="tabContent002" class="tabPage">
			<br><br>
			<ul class="tab_Menu1">
        		<li class="tabMenu current1">
            		<a href="#tabContent001" >1주일전</a>
        		</li>
        		<li class="tabMenu1">
            		<a href="#tabContent002" >1개월전</a>
        		</li>
        		<li class="tabMenu">
            		<a href="#tabContent003" >3개월전</a>
        		</li>
        	</ul>
            <div id="TAB2" style="text-align:center">
            <br><br>
            <br><br>		
            	 <table style="width=2000; table-layout:fixed;" borderColor=#000000 cellSpacing=0 cellPadding=0 border=1 align="center">
            	 <tr height="50">
					<th>일자</th><th>장소</th><th>메뉴명</th><th>사용금액</th>
				 </tr>
				 <c:forEach var="foruse" items="${use1month}">
				 <tr height=50>
				 <td width=100>${foruse.date}</td>
				 <td width=100>${foruse.chain}</td>
				 <td width=100>${foruse.mn_name}</td>
				 <td width=100>${foruse.mn_price}</td>
				 </tr> 
				 </c:forEach>
				 </table>
				 </div>
			</div>
					 
			<!-- 사용내역에서의 3개월전까지의 목록 화면 // -->
    
			<div id="tabContent003" class="tabPage">
			<br><br>
			<ul class="tab_Menu1">
        		<li class="tabMenu current1">
            		<a href="#tabContent001" >1주일전</a>
        		</li>
        		<li class="tabMenu1">
            		<a href="#tabContent002" >1개월전</a>
        		</li>
        		<li class="tabMenu">
            		<a href="#tabContent003" >3개월전</a>
        		</li>
    		</ul>
            <div id="TAB2" style="text-align:center">
            <br><br>
            <br><br>		
            	 <table style="width=2000; table-layout:fixed;" borderColor=#000000 cellSpacing=0 cellPadding=0 border=1 align="center">
            	 <tr height="50">
					<th>일자</th><th>장소</th><th>메뉴명</th><th>사용금액</th>
				 </tr>
				 <c:forEach var="foruse" items="${use3month}">
				 <tr height=50>
				 <td width=100>${foruse.date}</td>
				 <td width=100>${foruse.chain}</td>
				 <td width=100>${foruse.mn_name}</td>
				 <td width=100>${foruse.mn_price}</td>
				 </tr> 
				 </c:forEach>
				 </table>
				 </div>
			</div>
	
		<!-- 사용 매출 -->
    
        <div id="tabContent02" class="tabPage">
        <br><br>
            <div id="TAB2">
            <br><br>
            <table align="center" cellpadding="20px">
            <tr><td>
            <form method="post" action="Stu_TotForuse.do">
            <input type="text" name="revenue">
            <input type="submit" value="조회">
            </form>
            </td></tr>
            <tr><td>원하는 월 입력 : ex)2017-07</td></tr>
            <c:forEach var="rm" items="${Fn_rm}">
            <tr>
            <td>월별 매출 : ${rm.r_money}</td>
            </tr>
			</c:forEach>
			</table>
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