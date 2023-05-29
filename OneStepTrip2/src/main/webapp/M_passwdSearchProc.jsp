<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기(비밀번호 수정)</title>
<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<style>
 .im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
	table tr > th {
    	background: #7cc1a1 !important;
		color: white;
		font-size: 18px;
	}
	form {
		margin-top:70px;
		margin-bottom:70px;
	}
</style>
</head>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<center><img class="im" alt="a-1" src="./image/asia/china.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<c:if test="${passwdSearch==4 }">
	<script>
	alert("입력하신 정보가 없습니다. 다시한번 확인해주세요.");
	history.go(-1);
	</script>
</c:if>
<script>
// 비밀번호 불일치 체크
$(function(){

$("#passwdUpdate").on("click", function() {
	 // pwd불일치 여부체크
 	var pwd1=$('#m_passwd').val()
	var pwd2=$('#m_repasswd').val()
	// 불일치 체크
	if(pwd1 != pwd2){
		alert("비밀번호가 일치하지않습니다. 한번더 확인해주세요.");
		return false;
	}
});
})
</script>

<c:if test="${passwdSearch==3}">
<form action="M_passwdUpdate.do" id="M_passwdUpdate" method="post" align="center">
	<table align="center" style="width: 45%; margin: auto;" class="table table-bordered" >
		<tr align="center">
			<th width="20%">아이디</th>
			<td width="25%">
				<input type="text" name="m_id" id="m_id"  value="${m_id }" readonly >
			</td>
		</tr>
		<tr align="center">
			<th width="20%">새 비밀번호 입력</th>
			<td width="25%">
				<input type="password" name="m_passwd" id="m_passwd" />
			</td>
		</tr>
		<tr align="center">
			<th width="20%">새 비밀번호 입력 확인</th>
			<td width="25%">
				<input type="password" name="m_repasswd" id="m_repasswd" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" id="passwdUpdate" value="비밀번호변경" class="btn btn-warning"></td>
		</tr>
	</table>
</form>
</c:if>

<div style="clear: both;"></div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>