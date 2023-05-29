<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OneStepTrip</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
<style>
p {
	text-align:center;
}
</style>
</head>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>

<!-- center로 올때 함수처리 -->
<c:if test="${check==false }">
	<script>alert("회원가입 정보를 체크해주세요."); history.go(-1);</script>
</c:if>
<c:if test="${check==true }">
<script>alert("회원가입에 성공하셨습니다.");</script>
</c:if>
<c:if test="${loginCheck==false}">
	<script>alert("아이디 또는 비밀번호를 다시 확인해주세요."); history.go(-1);</script>
</c:if>
<c:if test="${logout==1 }">
	<script>alert("로그아웃 되었습니다.");</script>
</c:if>
<c:if test="${m_updatecheck }">
	<script>alert("회원정보가 수정되었습니다.");</script>
</c:if>
<c:if test="${m_updatecheck==false }">
	<script>alert("회원 정보를 확인해주세요."); history.go(-1);</script>
</c:if>
<c:if test="${m_deleteCheck > 0 }">
	<script>alert("회원탈퇴가 정상적으로 되셨습니다."); </script>
</c:if>
<c:if test="${passwdUpdate==5 }">
	<script>alert("회원님의 비밀번호가 정상적으로 수정되셨습니다."); </script>
</c:if>
<c:if test="${passwdUpdate==6 }">
	<script>alert("비밀번호를 다시한번 입력해주세요."); history.go(-1);</script>
</c:if>




<!-- center -->
<p>
<c:if test="${idSearch==2 }"><p>회원님의 아이디는 ${m_id } 입니다. </p></c:if>
<c:if test="${idSearch==3 }"><p>아이디를 찾을수 없습니다. 다시한번 확인해주세요.</p></c:if>

<jsp:include page="center.jsp"/>

<!-- <div style clear= "both;"></div> -->
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>