<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>


<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
<title>이벤트 페이지</title>
<style type="text/css">
	body{
		display:inline-block;
		margin:auto;
		}
	.im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
</style>
</head>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<img class="im" alt="a-1" src="./image/test1.jpg" style="opacity:0.5; vertical-align: bottom">
<!-- 제목 -->
<p>
<br>
<h1><center>EVENT</center></h1>
<p><br>
<div class="dic" align="center">
<!-- 이벤트 3-4개 배너 -->
<center><a href="#"><img src="./image/캡처.PNG" width="700" height="600"></a></center>
<p><p><p><p><br> 
<hr width="75%" align="center">
<br>
<center><a href="#"><img src="./image/캡처-1.PNG" width="700" height="600"></a></center>
<p><p><p><p><br>
<hr width="75%" align="center">
<br>
<center><a href="#"><img src="./image/캡처-2.PNG" width="700" height="600"></a></center>
<p>
<br>
<br><br><p>
</div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>