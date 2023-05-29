<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아시아</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
</head>
<style>
ul li {
	list-style-type: none;
}

ul li {
	list-style-type: none;
	float: left;
	margin-left: 20px;
}

ul li {
	list-style-type: none;
	text-align: center;
	display: inline;
	margin-left: 20px;
}

ul.a {
	text-align: center;
}

li.a {
	width: 150px;
	height: 50px;
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
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}

.wrapper {
	width: 1285px;
	margin: 0 auto;
}
</style>
<jsp:include page="top.jsp" flush="false" />
<body>
	<!--  지역별 여행페이지 -->
	<div class="container" style="margin-top: 10pt;" text-align="center">
		<div class="row">
			<div class="col" style="border-bottom: 1px solid #cabfbf;">
				<ul class="a">
					<h5>
						<li class="a"><a href="P_asia.do?cType=1">아시아</a></li>
					</h5>
					<h5>
						<li class="a"><a href="P_asia.do?cType=2">유럽</a></li>
					</h5>
					<h5>
						<li class="a"><a href="P_asia.do?cType=3">오세아니아</a></li>
					</h5>
					<h5>
						<li class="a"><a href="P_asia.do?cType=4">아메리카</a></li>
					</h5>
				</ul>
			</div>
		</div>
	</div>
	<!--  아시아 여행상품에 대한 정보 -->
	<input type="hidden" />
	<div class="container" style="margin-top: 10pt; margin-top: 50px; margin-bottom: 100px;">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

			<c:forEach var="prod" items="${P_list}">
				<div class="col">
					<div class="card shadow-sm">
						<a href="P_detail.do?p_num=${prod.p_num}"><img src="./image/${imgFolderName}/${prod.pi_way }" alt="${prod.pi_way }"
							style="width: 100%; height: 225px;"></a>
						<div class="card-body">
							<p class="card-text">${prod.p_name }</p>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>