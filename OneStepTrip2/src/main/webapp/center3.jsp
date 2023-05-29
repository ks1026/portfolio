<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역별여행</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
</head>
<style>

ul li {list-style-type: none;}
ul li {list-style-type: none; float: left; margin-left: 20px;}
ul li {list-style-type: none; text-align:center; display: inline; margin-left: 20px; }

ul.a {
        text-align: center;
      }

li.a {
 width:150px;
 height:50px;
 list-style: none;
 text-align: center;
 line-height: 40px;
 margin-left: 120px;
 float: left; 
}

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
  text-decoration:underline;
 }
 
 .wrapper{
 	width: 1285px; margin:0 auto;
 } 
 
</style>
<body>
<!-- top -->
<header id="header">
<nav class="py-2 bg-success border-bottom">
    <div class="container d-flex flex-wrap">
      <ul class="nav me-auto">
        <li class="nav-item"><a href="index.jsp" class="nav-link link-dark px-2 active text-white" aria-current="page"><img src="./image/회사로고-1.png" style="width: 11%; height:11%;">OneStepTrip</a></li>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;
        <li class="nav-item "><a href="center2.jsp" class="nav-link link-dark px-2 text-white">지역별여행</a>
        <li class="nav-item"><a href="#" class="nav-link link-dark px-2 text-white">여행정보</a></li>
        <li class="nav-item"><a href="#" class="nav-link link-dark px-2 text-white">게시판</a></li>
        <li class="nav-item"><a href="#" class="nav-link link-dark px-2 text-white">이벤트</a></li>
      </ul>
      <ul class="nav">
      <c:if test="${idKey!=null}">
      	   <li class="nav-item"><a href="M_info.do?m_id=${idKey}" class="nav-link link-dark px-2 text-white">${idKey}님 마이페이지</a></li>
      	   <li class="nav-item"><a href="M_logout.do" class="nav-link link-dark px-2 text-white">로그아웃</a></li>
      </c:if>
      <c:if test="${idKey==null }">
        <li class="nav-item"><a href="M_login.jsp" class="nav-link link-dark px-2 text-white">로그인</a></li>
        <li class="nav-item"><a href="M_agreement.jsp" class="nav-link link-dark px-2 text-white">회원가입</a></li>
      </c:if>
      </ul>
    </div>
  </nav>
  </header>
<!-- top -->
<!--  지역별 여행페이지 -->
<div class="container" style="margin-top: 10pt;" text-align="center">
  <div class="row">
    <div class="col">
<ul class="a">
	<h4><li class="a"><a href="#">아시아</a></li></h4>
	<h4><li class="a"><a href="#">유럽</a></li></h4>
	<h4><li class="a"><a href="#">오세아니아</a></li></h4>
	<h4><li class="a"><a href="#">아메리카</a></li></h4>
</ul>
  </div>
  	</div>
  		</div>
<!--  여행 이미지 1, 2, 3, 4, 5~~~ -->
<
<div class="container" style="margin-top: 10pt;">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
          	<a href="#"><img src="./image/korea.jpg" alt="" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">대한민국</p>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            	<a href="#"><img src="./image/japan.jpg" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">일본</p>
            </div>
          </div>
        </div>
          <div class="col">
          <div class="card shadow-sm">
            	<a href="#"><img src="./image/china.png" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">중국</p>
            </div>
          </div>
        </div>
         <div class="col">
          <div class="card shadow-sm">
            	<a href="#"><img src="./image/thai.jpg" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">태국</p>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            	<a href="#"><img src="./image/hongkong.jpg" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">홍콩</p>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            	<a href="#"><img src="./image/vietnam.png" style="width: 100%; height: 225px;"></a>
            <div class="card-body">
              <p class="card-text">베트남</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>