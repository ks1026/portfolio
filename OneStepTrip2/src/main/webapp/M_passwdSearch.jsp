<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
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
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<center><img class="im" alt="a-1" src="./image/asia/china.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<!-- center -->
<p>
<form action="M_passwdSearch.do" id="M_passSearch" method="post" align="center">
	<table align="center" style="width: 35%; margin: auto;" class="table table-bordered" >
		<tr align="center">
			<th width="15%">이름</th>
			<td width="20%">
				<input type="text" name="m_name" id="m_name" />
			</td>
		</tr>
		<tr align="center">
			<th width="15%">아이디</th>
			<td width="20%">
				<input type="text" name="m_id" id="m_id" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="비밀번호찾기" class="btn btn-warning"></td>
		</tr>
	</table>
</form>



<div style="clear: both;"></div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>