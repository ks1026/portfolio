<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="M_info.css"/>
<link rel="stylesheet" href="./css/bootstrap.css"/>
<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="M_info.js"></script>
</head>
<style>
.wrapper {
    text-align: center;
}
.im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
	
table > tbody > tr > th {
    background: #7cc1a1 !important;
	color: white;
}
</style>
<body align="center">

<!-- top -->
<jsp:include page="top.jsp"/>

<!-- center -->
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>


<div class="leftPanel">
	<p id="btn1" class="btnClick"><a href="M_info.do?m_id=${idKey}&id=area1">회원정보</a></p>
	<p id="btn2" class="btnClick"><a href="P_basket.do?m_id=${idKey}&id=area2">장바구니</a></p>
	<p id="btn3" class="btnClick">쿠폰입력</p> 
	<p id="btn4" class="btnClick"><a href="P_pHistory.do?m_id=${idKey}&id=area4">결제내역</a></p>
</div>

<div class="parent" text-align="center";>
		<div id="area1" class="area" style="display: none;">
		<br><br>
		<h4 align="center">회원정보</h4>
		<br><br>
		<form action="M_update.do" method="post" id="updateForm">
			<table class="table table-bordered" style="width: 50%; margin: auto;">
				<tr>
					<th style="width: 30%;">아이디</th>
					<td style="width: 70%;"><input type="text" name="m_id" id="m_id"  value="${mdto.m_id }" size="30" readonly ></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
					<input type="password" name="m_passwd" id="m_passwd" value="${mdto.m_passwd }" size="30" required>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
					<input type="text" name="m_name" id="m_name" size="30" value="${mdto.m_name }" required>
					</td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td>
					<input type="text" name="m_email" id="m_email" size="30" value="${mdto.m_email }" required>
					</td>
				</tr>
				
				<tr>  
		            <th>전화번호</th>
		            <td> <input type="text" name="m_phone" id="m_phone" size="30" value="${mdto.m_phone }" required> </td>  
		        </tr>
		        
				<tr> 
		            <th>우편번호</th>
		            <td> <input type="text" name="m_zipcode" id="m_zipcode" size="20">
		                 <input type="button" id="btnZipcode" value="우편번호찾기" class="btn btn-secondary" value="${mdto.m_zipcode }" required></td>
		          </tr>
		          
				 <tr>  
		            <th>주소</th>
		            <td><input type="text" name="m_address" id="m_address" size="60" value="${mdto.m_address }" required></td>
		         </tr>
				<tr>  
		            <th>포인트</th>
		            <td> 
		                 <input type="text" name="m_point" id="m_point" value="${mdto.m_point }"  readonly></td>
		          </tr>
		         <tr align="center">  
		     		<td colspan="2">
		            <input type="submit" value="회원수정" id="btnM_update" class="btn btn-success">
		            <input type="button" value="회원탈퇴" id="btnM_delete" class="btn btn-warning">
		            </td>
		         </tr>
			</table>
		</form>
		</div>
		<p><br>
	
<!-- 장바구니 -->
	<div id="area2" class="area row-lg-1" style="display: none;">
		<h1><center>장바구니</center></h1>
		<p><br><p><p>
		<div class="col-md-15 clearfix" id="basket">
			<div class="box">
				<form method="post">
					<div class="table-responsive">
						<table  class="table table-success">
							<thead>
								<tr class="table-active">
									<th>상품번호</th>
									<th>상품명</th>
									<th>상품이미지</th>
									<th>상품수량</th>
									<th>상품금액</th>
									<th>선택취소</th>
								</tr>
							</thead>
							<c:forEach var="pb" items="${pbasket}">
							<tbody>
								<tr>
									<td>
										${pb.p_num}
									</td>
									<td>
										${pb.p_name}
									</td>
									<td>
										<img src="image/${pb.pi_way}" style="width: 200px;">
									</td>
									<td>
										1
									</td>
									<td>
										<fmt:formatNumber value="${pb.p_price}" pattern="#,###" />
									</td>
									<td>
										<input id="${pb.p_num}" class="rdoClick" type="radio" value="cart cancel">
									</td>
								</tr>
							</tbody>
							</c:forEach>
							<tfoot>
								<tr>
									<th colspan="6">총 금액:
									<c:set var = "sum" value = "0" />
									<c:forEach var="pb" items="${pbasket}">
									<c:set var= "sum" value="${sum + (pb.p_price)}"/>
									</c:forEach>
									<fmt:formatNumber value="${sum}" pattern="#,###" />
									</th>
								</tr>
							</tfoot>
						</table>
						<a class="btn btn-secondary" href="P_pay.do?m_id=${m_id}&total=${sum}">결제</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<p><br>
	
	<div id="area3" class="area" style="display: none;">
		<h1><center>쿠폰 입력</center></h1>
		<p><br><p><p><br><p><p><br><p>
		<center>
			<table class="box">
				<tr>
					<td colspan="2">쿠폰 입력 :
						<input type="text" value="쿠폰입력">
					</td>
				</tr>
			</table>
		</center>
	</div>
	
	<!-- 결제내역 -->
	<div id="area4" class="area" align="center" style="display: none;">
		<div class="col-lx-6" align="center">
		<h1><center>결제내역</center></h1>
		<p><br><p><p>
		<div class="col-md-14 clearfix" id="basket">
			<div class="box">
				<form method="post">
					<div class="table-responsive">
						<table  class="table table-secondary">
							<thead>
								<tr class="table-active">
									<th>결제번호</th>
									<th>상품번호</th>
									<th>상품명</th>
									<th>회원아이디</th>
									<th>상품날짜</th>
									<th>결제금액</th>
									<th>결제방법</th>
									<th>결제상태</th>
									<th>환불유무</th>
									<th>환불사유</th>
								</tr>
							</thead>							
								<tbody>
								 <c:forEach var="p" items="${payList}">
									<tr>
										<td>
											${p.pay_num}
										</td>
										<td>
											${p.p_num}
										</td>
										<td>
											${p.p_name}
										</td>
										<td>
											${p.m_id}
										</td>
										<td>
											${p.pay_date}
										</td>
										<td>
											<fmt:formatNumber value="${p.pay_price}" pattern="#,###" />
										</td>
										<td>
											 ${p.pay_payment }
										</td>
							
									<td>
										결제완료
									</td>
									<td>
										<input type="checkbox" id="refund" name="refund" >
									</td>
									<td>
										<select id="select" >
											<option selected >주문 실수</option>
											<option>구매자 개인 사정</option>
											<option>제품 결함</option>
											<option>반품 및 교환 원함</option>
										</select>
									</td>
								</tr>
							</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th colspan="5">환불하기</th>
									<th colspan="4">총 환불금액:
									<c:set var = "sum" value = "0" />
									<c:forEach var="pl" items="${payList}">
									<c:set var= "sum" value="${sum + (pl.pay_price)}"/>
									</c:forEach>
									<fmt:formatNumber value="${sum}" pattern="#,###" />
									</th>
									<input type="hidden" id="m_id2" value="${m_id }" />
									<th><a class="btn btn-secondary" id="payRefund">환불신청</a></th>
								</tr>
							</tfoot>
						</table>
						<p><p><br>
						<hr>
						<span class="title weight-600 ls-03" style="padding-top:50px"><h4>유의사항</h4></span>
						<div class="cost-table info" style="padding-top:20px" id="require-notice">
							<div class="row">
								<div class="col-md-6" style="min-height: 250px;">
									<div class="info-inner-wrap" >
										<div class="title d-flex justify-content-center align-items-end">
											<span class="ls-03 f-black weight-600"><h4>여행사용방법</h4></span>
										</div>
										<div class="content ls-03">
											★ 추가 옵션을 선택하시는 경우 아래 추가정보를 반드시 확인바랍니다.<br>
											<br>
											① 매표소에 바우처를 제시하고 농눅빌리지 입장권(선택옵션사항 포함)으로 교환합니다.<br>
											② 쇼를 포함한 티켓을 구매하신 경우 입장권(티켓)에 쇼타임을 지정해서 발권됩니다.<br>
											③ 이용전 전에 꼭! 확인해주세요. <br>이용시간을 매표직원에게 이야기하시면 미리 지정이 가능합니다. <p>확인을 안하시고 쇼타임 지난후에 변경하실경우 쇼를 이용 못하실수있으니 주의해주세요. <br>
											<br>
											VIP 좌석으로 업그레이드하고 가셨는데, <br>
											현지에서 좌석이 없어서 배정되지 못하는 경우가 아주 간혹 있습니다.<br>
											이 경우에는 현지에서 연락주시면 VIP 좌석 추가 요금은 환불 처리해드립니다.<br>
											VIP 좌석은 객석 중앙 쪽에 위치해 있으며, 관람하기 좋은 위치입니다.<br>
											※ 현지에서 관련 문제가 발생할 경우, 각 해외 한국 영사관 번호로 전화 바랍니다.
										</div>
									</div>
								</div>
								<div class="col-md-6" style="min-height: 250px">
									<div class="info-inner-wrap">
										<div class="title d-flex justify-content-center align-items-end">
											<span class="ls-03 f-black weight-600"><h4>취소 및 환불 규정</h4></span>
										</div>
										<div class="content ls-03">																																																		예약일 기준 2일 18시 이전 : 취소/변경 수수료 없이 취소/변경 가능합니다.<br />
											* 단, 호텔이나 업체에서 매기는 수수료는 별개입니다.<br />
											예약일 기준 2일 18시 이후 : 취소 또는 <br>노쇼(No Show)결제하신 금액 전액이 차지로 발생합니다.<br />
											*정확한 처리를 위해서 취소/변경은 <br>
											월-금 10:00-18:00 영업시간 중 해외 한국 영사관 전화로 연락바랍니다.<br />
											이후의 취소 접수 시 다음 영업일(영업시간 기준) 접수로 처리됩니다.<br />
											*취소 요청은 한국시간을 기준으로 합니다.<br />
											*노쇼(No-Show):예약을 했지만 취소 연락 없이<br>
											 예약장소에 나타나지 않는 경우를 말합니다.																							
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div style="clear: both;"></div>

<!-- footer -->
<jsp:include page="footer.jsp"/>

</body>
</html>