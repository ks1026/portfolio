<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>글수정하기</title>
<link href="style.css" rel="stylesheet" type="text/css">
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
<p>
<body bgcolor="#ffffff">  
<center><h3><b>글수정</h3></b>
<br>
<form method="post" name="writeform"
		   action="updatePro.do" 
		   onsubmit="return writeSave()">
<table width="800" cellspacing="0" cellpadding="0"  bgcolor="#ffffff" align="center">
  <tr>
	   <input type="hidden" name="c_num" value="${article.c_num}">
	   <input type="hidden" name="pageNum" value="${pageNum}">
  </tr>
  <tr>
    <td  width="80"  bgcolor="#ffffff" align="center" ><h4><strong>제 목 : </strong></h4></td>
    <td align="left" width="350">
       	<input type="text" size="30" maxlength="50" name="c_subject" value="${article.c_subject}" class="form-control invalid form-control-lg">
    	<p><br>
    </td>
  </tr>
  <tr>
    <td  width="80"  bgcolor="#ffffff" align="center" ><h4><strong>내 용 : </strong></h4></td>
    <td align="left" width="330">
     <textarea name="c_content" rows="10" cols="50" class="form-control invalid form-control-lg">${article.c_content}</textarea></td>
  </tr>

  <tr>      
   <td colspan=2 bgcolor="#ffffff" align="center"> 
   	 <p><br>
     <input type="submit" value="글수정" class="btn btn-sm-5 btn-success">  
     <input type="reset" value="다시작성" class="btn btn-sm-5 btn-success">
     <input type="button" value="목록보기" 
       onclick="document.location.href='list.do?pageNum=${pageNum}'" class="btn btn-sm-5 btn-success">
      <p>
   </td>
 </tr>
 </table>
</form>     
</body>
<footer>
<jsp:include page="footer.jsp" flush="false" />
</footer>
</html>      
