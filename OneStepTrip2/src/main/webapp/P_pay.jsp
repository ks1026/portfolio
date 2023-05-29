<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
	<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="P_pay.js"></script>
</head>
<style>
 .im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
	button{
		margin-left:500px;
	}
</style>
<body align="center">
	<!-- top -->
	<jsp:include page="top.jsp"/>
	<center><img class="im" alt="a-1" src="./image/northAmerica/usa.jpg" style="opacity:0.5; vertical-align: bottom"></center>
	<p>
	<!-- center -->
	<div class="col-lx-6" align="center">
		<h1><center>결제</center></h1>
		<p><br><p><p>
		<div class="col-md-14 clearfix" id="basket">
			<div class="box">
				<form method="post">
					<div class="table-responsive">
						<table  class="table table-info">
							<thead>
								<tr class="table-active" >
									<th>회원아이디</th>
									<th>상품번호</th>
									<th>상품명</th>
									<th>상품이미지</th>
									<th>상품날짜</th>
									<th>인원수</th>
									<th>결제금액</th>
								</tr>
							</thead>
							<tbody>							
									<c:forEach var="p" items="${plist}"  >
								<tr>
									<td>
										${p.m_id}
									</td>
									<td>
										${p.p_num}
									</td>
									<td>
										${p.p_name}
									</td>
									<td>
										<img src="image/${p.pi_way}" style="width:200px">
									</td>
										<td>
											${p.s_date} ~ ${p.e_date}
										</td>
									<td>
										<input type="number" value="1">
									</td>
									<td>
										<fmt:formatNumber value="${p.p_price}" pattern="#,###" />
									</td>
								</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th colspan="3">합계 :</th>
									<th colspan="4">
										
										<input type="hidden" id="m_id" value="${m_id}" >
										<input type="hidden" id="total" value="${total}" >
										<fmt:formatNumber value="${total}" pattern="#,###" />
										<%-- <span>${total}</span> --%>
									</th>
								</tr>
								<tr>
									<th colspan="3">결제수단:</th>
									<th colspan="4">
										<input type="radio" name="pay" id="pay" value="신용카드">신용카드
										<input type="radio" name="pay" id="pay" value="계좌이체">계좌이체
										<input type="radio" name="pay" id="pay" value="휴대폰결제">휴대폰결제
										<input type="radio" name="pay" id="pay" value="무통장입금">무통장입금
									</th>
								</tr>
							</tfoot>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	<button class="btn btn-secondary" id="payHistory">결제하기</button>
<%-- 	<a class="btn btn-secondary"href="P_pHistory.do?id=area4&m_id=${m_id}"> --%>
	<p><br>
	<!-- Footer -->
	<jsp:include page="footer.jsp"/>
</body>
</html>