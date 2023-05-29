<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.CommunityDTO" %>
<%@ page import="model.CommunityDAO" %>
<%@ page import="action.MemberDAO" %>
<%@ page import="model.MemberLoginDTO" %>
<%@ page import="java.util.Enumeration" %>

<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<script language="JavaScript" src="script.js"></script>
</head>
<style>
.im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
</style>
<jsp:include page="top.jsp" flush="false" />
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<body bgcolor="#ffffff">  
<br>
<center><h3><b>글쓰기</b></h3>
<p><br>
<!--onsubmit 이벤트="return 호출할 함수명(~)"  -->
<form method="post" name="writeform" 
		  action="writePro.do" onsubmit="return writeSave()">
	<!-- 입력하지 않고 매개변수로 전달해서 테이블에 저장(hidden 4개) -->
	<input type="hidden" name="c_num" value="${c_num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="re_step" value="${re_step}">
	<input type="hidden" name="re_level" value="${re_level}">	
<table width="800" cellspacing="0" cellpadding="0"  bgcolor="#ffffff" align="center">
  <tr>
    <td  width="80"  bgcolor="#ffffff" align="center" ><h4><strong>제 목 : </strong></h4></td>
    <td  width="350">
       	<input type="text" size="30" maxlength="50" name="c_subject" class="form-control invalid form-control-lg" placeholder="제목">
       	<p><br>
    </td>
  </tr>
  <tr>
    <td  width="80"  bgcolor="#ffffff" align="center" ><h4><strong>내 용 : </strong></h4></td>
    <td  width="330" >
     <textarea name="c_content" rows="10" cols="50" placeholder="내용" class="form-control invalid form-control-lg"></textarea> </td>
  </tr>
	<tr>      
		<!-- a링크,action속성값,이벤트처리를 통해서 이동하는 경우 전부 jsp->do -->
		<td colspan=2 bgcolor="#ffffff" align="center"> 
			<p><br>
			<input type="submit" value="글쓰기" class="btn btn-sm-5 btn-success">  
			<input type="reset" value="다시작성" class="btn btn-sm-5 btn-success">
			<input type="button" value="목록보기"   OnClick="window.location='./list.do'" class="btn btn-sm-5 btn-success">
			<p>
		</td>
	</tr>
</table>    
<p><br>
</form>      
</body>
<footer>
<jsp:include page="footer.jsp" flush="false" />
</footer>
</html>      