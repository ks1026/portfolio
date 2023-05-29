<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
 #m_register, #m_idSearch,#m_passSearch {
 	text-decoration : none;
 	color : black;
 	text-align:center;
 }

</style>
</head>
<body align="center">
<!-- top -->
<jsp:include page="top.jsp"/>

<p>
<!-- center -->
<table align="center" border="1px solid black" height="200px" width="30%" >
	<form action="M_login.do" id="M_login.do" method="post" align="center">
		<tr align="center">
			<td width="10%">로그인</td>
			<td width="20%">
				<input type="text" name="m_id" id="m_id" />
			</td>
		</tr>
		<tr align="center">
			<td width="10%">비밀번호</td>
			<td width="20%">
				<input type="password" name="m_passwd" id="m_passwd" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	</form>
	<tr align="center">
		<td colspan="2" >
			<a href="M_agreement.jsp" id="m_register">회원가입</a>&nbsp;&nbsp;  | &nbsp;&nbsp;
			<a href="M_idSearch.jsp" id="m_idSearch">아이디찾기</a>&nbsp;&nbsp;  | &nbsp;&nbsp;
			<a href="M_passwdSearch.jsp" id="m_passSearch">비밀번호찾기</a> 
		</td>
	</tr>
		
</table>
		
	

<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>