<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'>
<link href="https://fonts.googleapis.com/css?family=Rajdhani&display=swap" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
</head>
<style>


P {
text-align: center;
}

a:link {
  color : black;
  text-decoration: none;
}
a:visited {
  color : black;
  text-decoration: none;
}
a:hover {
  color : red;
  text-decoration:none !important;
  font-weight: 900;
 }
 
 .wrapper{
 	width: 1285px; margin:0 auto;
 } 
 
 .py-2 {
 	background: #4e8e70; 
/*  	darkslategrey; */
 }
		 
/* 변경전  */
/*
.wrapper{

 	width: 1285px; margin:0 auto;
 }

nav {
text-align: center;
}
 */
  
</style>
<body>
<header id="header">
<!-- 로그인한 사용자의 아이디를 숨겨놓았다가 사용 -->
<input id="hidUserId" name="hidUserId" type="hidden" value="${idKey}">
<nav class="py-2 border-bottom">
    <div class="container d-flex flex-wrap">
      <ul class="nav me-auto">
        <li class="nav-item">
        	<a href="index.do" class="nav-link link-dark px-2 active text-white" aria-current="page" style="width: 520px; text-align: left;">
        		<img src="./image/pLogo.png" style="width: 45%;">
        	</a>
        </li>
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="P_asia.do?cType=1" class="nav-link link-dark px-2 text-white">지역별여행</a>
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_trip_info.jsp" class="nav-link link-dark px-2 text-white">여행정보</a></li>
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="list.do" class="nav-link link-dark px-2 text-white">게시판</a></li>
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_Event.jsp" class="nav-link link-dark px-2 text-white">이벤트</a></li>
        <c:if test="${idKey=='admin'}">
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="admin.do" class="nav-link link-dark px-2 text-white">관리자</a></li>
        </c:if>
        </ul>
      <ul class="nav">
      <c:if test="${idKey!=null}">
      	   <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_info.do?m_id=${idKey}&id=area1" class="nav-link link-dark px-2 text-white">${idKey}님 마이페이지</a></li>
      	   <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_logout.do" class="nav-link link-dark px-2 text-white">로그아웃</a></li>
      </c:if>
      <c:if test="${idKey==null }">
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_login.jsp" class="nav-link link-dark px-2 text-white">로그인</a></li>
        <li class="nav-item" style="padding-top: 40px; font-size: 18px;"><a href="M_agreement.jsp" class="nav-link link-dark px-2 text-white">회원가입</a></li>
      </c:if>
      </ul>
    </div>
  </nav>
  </header>
</body>
</html>