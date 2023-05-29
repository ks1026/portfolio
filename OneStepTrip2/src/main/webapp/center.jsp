<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center</title>
<style type="text/css">
	.dic{
		font-style:italic;
	}
	body{
		display:inline-block;
		margin:auto;
		}
</style>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/slider.css">
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<!--  슬라이드 1 , 2, 3, ~~~ -->
<div class="slider">
    <input type="radio" name="slide" id="slide1" checked>
    <input type="radio" name="slide" id="slide2">
    <input type="radio" name="slide" id="slide3">
    <ul id="imgholder" class="imgs">
        <li><img src="./image/slide/full-bg-1.jpg"></li>
        <li><img src="./image/slide/full-bg-2.jpg"></li>
        <li><img src="./image/slide/full-bg-3.jpg"></li>
    </ul>
    <div class="bullets">
        <label for="slide1">&nbsp;</label>
        <label for="slide2">&nbsp;</label>
        <label for="slide3">&nbsp;</label>
    </div>
</div>
<br><br><p>
<!-- 여행 홍보글 -->
<div class="dic">
	<center>
		<h3>곳곳 마다 좋은 여행이 숨쉬는 장소를 찾는 원스텝 트립</h3>
		<h6>당신만이 찾는 여행장소 매력적인 장소를 초대합니다.</h6>
		<p><br>
		<hr width="50%" align="center">
		<p><br>
	</center>
</div>

<div class="dic">
		<h3 align="center">인기있는 추천 도시 여행장소</h3>
</div>
<br><br><p>
<!--  여행장소 -->
<div class="container" style="margin-top: 10pt;">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		<c:if test="${imageList ==null}">
		<div class="col">
        	<div class="card shadow-sm">
          		<a href="#"><img src="./image/asia/korea.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Korea(한국)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./image/europe/france.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">France(프랑스)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./image/oceania/australia.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Australia(오스트리아)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./image/northAmerica/canada.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Canada(캐나다)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./image/asia/japan.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Japan(일본)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./image/europe/italy.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Italy(이탈리아)</p>
            	</div>
          	</div>
        </div>
		</c:if>
		<c:if test="${imageList !=null}">
		<div class="col">
        	<div class="card shadow-sm">
          		<a href="#"><img src="./upload/${imageList[0].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Korea(한국)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./upload/${imageList[1].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">France(프랑스)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./upload/${imageList[2].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Australia(오스트리아)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./upload/${imageList[3].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Canada(캐나다)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./upload/${imageList[4].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Japan(일본)</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="#"><img src="./upload/${imageList[5].pi_way}" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">Italy(이탈리아)</p>
            	</div>
          	</div>
        </div>
		</c:if>
    	
 	</div>
</div>
<p><br>
<div class="dic" align="center">
	<p><br>
	<hr width="50%" align="center">
	<p><br>
	<h3>인기있는 여행정보</h3>
</div>
<br>
<div class="container">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
    	<div class="col">
        	<div class="card shadow-sm">
          		<a href="trip_info_detail.jsp"><img src="./image/trip_info/biketrip.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">국토종주 자전거길 소개</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="trip_info_detail2.jsp"><img src="./image/trip_info/glamping.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">경기 근교 글램핑 추천</p>
            	</div>
          	</div>
        </div>
        <div class="col">
        	<div class="card shadow-sm">
            	<a href="trip_info_detail3.jsp"><img src="./image/trip_info/cablecar.jpg" style="width: 100%; height: 225px;"></a>
            	<div class="card-body">
              		<p class="card-text">가족여행자들을 위한 국내케이블 정보</p>
            	</div>
          	</div>
        </div>
</div>
<br><br><p>
<div class="dic" align="center">
	<p><br>
	<hr width="50%" align="center">
	<p><br>
	<h3>SNS 들어가기</h3>
	<p><br>
	<a href="https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0"><img alt="Blog" src="./image/blog.png" width="3%" height="3%"></a>
	<a href="https://ko-kr.facebook.com"><img alt="FaceBook" src="./image/facebook.png" width="3%" height="3%"></a>
	<a href="https://www.instagram.com/"><img alt="instagram" src="./image/insta.png" width="3%" height="3%"></a>
	<a href="https://www.youtube.com/"><img alt="Youtube" src="./image/youtube.png" width="3%" height="3%"></a>
</div>
<br><br><p>
</body>
</html>