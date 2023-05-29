<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css"/>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
 #m_register, #m_idSearch,#m_passSearch {
 	text-decoration : none;
 	color : black;
 	text-align:center;
 	}
 	
 	table tr > th {
    background: #7cc1a1 !important;
	color: white;
	font-size: 17px;
	}
	
	table> tr > td {
	 background: #7cc1a1 !important;
	}
	#register {
		text-align:center;
		margin-bottom:50px;
	}
	form {
		margin-top:50px;
		
	}
	  .im{
      width:100%;
      height:300px;
      display:inline-block;
      margin:auto;
   }
   
  

</style>
</head>
<body align="center">
<!-- top -->
<jsp:include page="top.jsp"/>

<p>
<!-- center -->
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<form action="M_login.do" id="M_login.do" method="post" align="center">
	<table class="table table-bordered" id="table" align="center" border="1px solid grey"  style="margin-top: 100px; margin-bottom: 100px; width: 30%; margin: auto;">
		<tr align="center">
			<th width="15%">로그인</th>
			<td width="20%">
				<input type="text" name="m_id" id="m_id" />
			</td>
		</tr>
		<tr align="center">
			<th width="15%">비밀번호</th>
			<td width="20%">
				<input type="password" name="m_passwd" id="m_passwd" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" class="btn btn-warning" value="로그인"></td>
		</tr>
	</table>
	<p></p>
</form>
		<div id="register">
			<a href="M_agreement.jsp" id="m_register">회원가입</a>&nbsp;&nbsp;  | &nbsp;&nbsp;
			<a href="M_idSearch.jsp" id="m_idSearch">아이디찾기</a>&nbsp;&nbsp;  | &nbsp;&nbsp;
			<a href="M_passwdSearch.jsp" id="m_passSearch">비밀번호찾기</a> 
		</div>


<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>