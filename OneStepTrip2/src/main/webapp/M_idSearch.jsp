<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
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
	table {
		border-radius: 10px !important;
	}
</style>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<center><img class="im" alt="a-1" src="./image/asia/thai.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<!-- center -->
<p>
<form action="M_idSearch.do" id="M_idSearch" method="post" align="center">
	<table align="center" class="table table-bordered"  style="width: 35%; margin: auto;" >
		<tr align="center">
			<th width="15%">이름</td>
			<td width="20%">
				<input type="text" name="m_name" id="m_name" />
			</td>
		</tr>
		<tr align="center">
			<th width="15%">이메일</td>
			<td width="20%">
				<input type="email" name="m_email" id="m_email" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="아이디찾기" class="btn btn-warning"></td>
		</tr>
	</table>
</form>



<div style="clear: both;"></div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>