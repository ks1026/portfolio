<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아시아</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript" src="Basket.js"></script>
</head>
<style>
body {
	margin-top: 20px;
}
</style>
<!-- top -->
<jsp:include page="top.jsp" flush="false" />
<body>

	<!--  여행정보 상세보기 -->

	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="./image/${imgFolderName}/${pdto.pi_way}">
				</div>
				<div class="col-md-6">
					<hr />
					<div class="small mb-1">여행 패키지</div>
					<h1 class="display-5 fw-bolder">${pdto.p_name}</h1>
					<hr />
					<div class="fs-5 mb-5">
						<span>가격: <fmt:formatNumber value="${pdto.p_price}" pattern="#,###" />원</span>
						<hr />
						<span> </span>
					</div>
					<p class="lead"></p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity"
							type="num" value="1" style="max-width: 3rem">
						 <input type="text" id="from" name="from" value="${fromDate}"> 
						 <input type="text" id="to" name="to" value="${toDate}">
						 <input type="hidden" value="${pdto.p_num}" id="p_num"/>
						<button class="btn btn-outline-dark flex-shrink-0" type="button" id="basketButton" >
						<i class="bi-cart-fill me-1"></i> 장바구니 담기
						</button>
						<br />
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp" />
</body>

<script>
	$("#from").datepicker(
			{
				changeMonth : true,
				changeYear : true,
				showOn : "both",
				numberOfMonths : 2,
				dateFormat : 'yy-mm-dd',
				showOtherMonths : true,
				selectOtherMonths : true,
				showMonthAfterYear : true,
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
				monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
						'8월', '9월', '10월', '11월', '12월' ],
				monthNames : [ '년 1월', '년 2월', '년 3월', '년 4월', '년 5월', '년 6월',
						'년 7월', '년 8월', '년 9월', '년 10월', '년 11월', '년 12월' ],
				nextText : '다음 달',
				prevText : '이전 달',
				beforeShowDay : disableAllTheseDays
			});

	//특정날짜들 배열
	var orgFromDate = $("#from").val();
	var orgToDate = $("#to").val();

	//주말(토, 일요일) 선택 막기
	function noWeekendsOrHolidays(date) {
		var noWeekend = jQuery.datepicker.noWeekends(date);
		return noWeekend[0] ? [ true ] : noWeekend;
	}

	//일요일만 선택 막기
	function noSundays(date) {
		return [ date.getDay() != 0, '' ];
	}

	//이전 날짜들은 선택막기
	function noBefore(date) {
		if (date < new Date())
			return [ false ];
		return [ true ];
	}

	//특정일 선택막기
	function disableAllTheseDays(date) {
		var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();

		m = m + 1;
		if (m < 10) {
			m = "0" + m;
		}
		if (d < 10) {
			d = "0" + d;
		}
		var cmpDate = y + "" + m + "" + d;
		orgFromDate = orgFromDate.replaceAll("-", "");
		orgToDate = orgToDate.replaceAll("-", "");

		if (Number(orgFromDate) <= Number(cmpDate)
				&& Number(cmpDate) <= Number(orgToDate)) {
			return [ true, "", "" ];
		} else {
			return [ false, "", "" ];
		}
	}
</script>
</html>