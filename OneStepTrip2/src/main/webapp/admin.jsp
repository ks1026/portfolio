<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>관리자 페이지</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
</head>
<style>
body {
	display: inline-block;
	margin: auto;
}

.im {
	width: 100%;
	height: 480px;
	display: inline-block;
	margin: auto;
}

body {
	font-family: 'Open Sans', sans-serif;
	background-color: #f7f7f7;
}

.lib-panel {
	margin-bottom: 20Px;
}

.lib-panel img {
	width: 100%;
	background-color: transparent;
}

.lib-panel .row, .lib-panel .col-md-6 {
	padding: 0;
	background-color: #FFFFFF;
}

.lib-panel .lib-row {
	padding: 0 20px 0 20px;
}

.lib-panel .lib-row.lib-header {
	background-color: #FFFFFF;
	font-size: 20px;
	padding: 10px 20px 0 20px;
}

.lib-panel .lib-row.lib-header .lib-header-seperator {
	height: 2px;
	width: 26px;
	background-color: #d9d9d9;
	margin: 7px 0 7px 0;
}

.lib-panel .lib-row.lib-desc {
	position: relative;
	height: 100%;
	display: block;
	font-size: 13px;
}

.lib-panel .lib-row.lib-desc a {
	position: absolute;
	width: 100%;
	bottom: 10px;
	left: 20px;
}

.row-margin-bottom {
	margin-bottom: 20px;
}

.box-shadow {
	-webkit-box-shadow: 0 0 10px 0 rgba(0, 0, 0, .10);
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, .10);
}

.no-padding {
	padding: 0;
}

.row {
	text-align: center;
}

div {
	text-align: center;
}

#nav {
	border: 1px solid #ccc;
	border-width: 1px 0;
	list-style: none;
	margin: 0;
	padding: 0;
	text-align: center;
}

#nav li {
	display: inline;
}

#nav a {
	display: inline-block;
	padding: 10px;
}
</style>

</head>
<body>
	<!-- top -->
	<jsp:include page="top.jsp" />
	<img class="im" alt="a-1" src="./image/test1.jpg"
		style="opacity: 0.5; vertical-align: bottom">
	<!-- main -->

	<div class="container" style="margin-top: 10pt;">
		<div class="row">
			<h2>관리자 페이지</h2>
			<p></p>
		</div>
		<hr>

		<div class="row">
			<table>
				<c:forEach var="item" items="${imageList}">
				<form action="adminUpdate.do?type=${item.rnum}"   method="post"   enctype="multipart/form-data"  onsubmit="return formCheck();">
					<tr>
						<th>메인 ${item.rnum}번째 이미지</th>
						<td>${item.pi_way}</td>
						<td>
							<input type="hidden" name="pi_num" value="${item.pi_num}">
							<input type="file" name="filename">
						</td>
						<td><button type="submit">이미지 업데이트</button></td>
					</tr>
				</form>
				</c:forEach>
			</table>
		</div>
	</div>


	<!-- footer -->
	<jsp:include page="footer.jsp" />
</body>
</html>