<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="M_info.css"/>
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
</style>
<body align="center">

<!-- top -->
<jsp:include page="top.jsp"/>

<!-- center -->
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>


<div class="leftPanel">
	<p id="btn1" class="btnClick">회원정보</p>
	<p id="btn2" class="btnClick">장바구니</p>
	<p id="btn3" class="btnClick">쿠폰입력</p>
	<p id="btn4" class="btnClick">결제/주문</p>
</div>

<!-- <div class="rightPanel" text-align="center";> -->
<div class="parent" text-align="center";>

	<!-- <div id="area1" class="area"> -->
	<!-- 회원정보 -->
		<div id="area1" class="area" style="display: none;">
		<p><br>
		<h4 align="center">회원정보</h4>
		<table width="50%" border="1px solid black" align="center">
		<form action="M_update.do" method="post" id="updateForm">
		<form action="M_info.do" id="M_info.do" method="post" align="right">
			<tr>
				<td width="20%">아이디</td>
				<td width="60%"><input type="text" name="m_id" id="m_id"  value="${mdto.m_id }" size="15" readonly ></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
				<input type="password" name="m_passwd" id="m_passwd" value="${mdto.m_passwd }" size="15" required>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
				<input type="text" name="m_name" id="m_name" size="15" value="${mdto.m_name }" required>
				</td>
			</tr>
			 
			<tr>
				<td>이메일</td>
				<td>
				<input type="text" name="m_email" id="m_email" size="15" value="${mdto.m_email }" required>
				</td>
			</tr>
			
			<tr>  
	            <td>전화번호</td>
	            <td> <input type="text" name="m_phone" id="m_phone" size="20" value="${mdto.m_phone }" required> </td>  
	        </tr>
	        
			<tr>  
	            <td>우편번호</td>
	            <td> <input type="text" name="m_zipcode" id="m_zipcode" size="7">
	                 <input type="button" id="btnZipcode" value="우편번호찾기"  value="${mdto.m_zipcode }" required></td>
	          </tr>
	          
			 <tr>  
	            <td>주소</td>
	            <td><input type="text" name="m_address" id="m_address" size="80" value="${mdto.m_address }" required></td>
	         </tr>
			<tr>  
	            <td>포인트</td>
	            <td> 
	                 <input type="text" name="m_point" id="m_point" value="${mdto.m_point }"  readonly></td>
	          </tr>
	         <tr align="center">  
	     		<td colspan="2">
	            <input type="submit" value="회원수정" id="btnM_update" >
	            <input type="button" value="회원탈퇴" id="btnM_delete" >
	            </td>
	         </tr>
	         </form>
	      </form>
		</table>
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
										${pb.p_price}
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
									<c:out value="${sum}"/>
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
	
<!-- 쿠폰입력 -->
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


	<div id="area4" class="area row-cols-2" align="center" text-align="center" style="display: none;">
		<h1><center>결제/환불 페이지</center></h1><p><br>
		<div class="card mb-3">
 	 		<h3 class="card-header">결제(Order)</h3>
  			<div class="card-body">
    			<h5 class="card-subtitle">${product.name}(상품명)</h5>
    			<h6 class="card-subtitle text-muted">(상품 결제 번호)</h6>
  			</div>
  			<center>
  			<svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="40%" height="300" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle;">
    			<rect width="100%" height="100%" fill="#868e96" />
    			<text x="50%" y="50%" fill="#dee2e6" dy=".3em">상품이미지</text>
  			</svg>
  			</center>
  			<div class="card-body">
    			<p class="card-text">상품명${product.name}</p>
  			</div>
  			<ul class="list-group list-group-flush">
    			<li class="list-group-item" style={background-color:gray;}>인원</li>
    			<br>성인:</br>
    			<input type="number" placeholder="1" class="input-group form-control">명
    			<br>청소년:</br>
    			<input type="number" placeholder="1" class="input-group form-control">명
    			<br>어린이:</br>
    			<input type="number" placeholder="1" class="input-group form-control">명
    			<li class="list-group-item">Dapibus ac facilisis in</li>
    			<li class="list-group-item">Vestibulum at eros</li>
  			</ul>
  			<div class="card-body">
    			<a href="#" class="card-link">Card link</a>
    			<a href="#" class="card-link">Another link</a>
  			</div>
  			<div class="card-footer text-muted">2 days ago</div>
		</div>
		<div class="card">
  			<div class="card-body">
    			<h4 class="card-title">Card title</h4>
    			<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<a href="#" class="card-link">Card link</a>
    			<a href="#" class="card-link">Another link</a>
  			</div>
		</div>
	</div>
</div>

<div style="clear: both;"></div>

<!-- footer -->
<jsp:include page="footer.jsp"/>

</body>
</html>