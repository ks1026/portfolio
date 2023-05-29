<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="model.CommunityDAO" />
<!DOCTYPE html>
<html>
<head>
<style>
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
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<jsp:include page="top.jsp" flush="false" />
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<body bgcolor="#ffffff">
<p>
<center><h3><b>글삭제</h3></b>
<br>
<form method="POST" name="delForm" action="deletePro.do?pageNum=${pageNum}&c_num=${c_num}" 
   		  onsubmit="return deleteSave()"> 
 <table border="1" cellspacing="0" cellpadding="0" width="360" class="table table-bordered" style="margin-top: 100px; margin-bottom: 100px; width: 30%; margin: auto;">
  <tr height="30">
     <th  bgcolor="#ffffff">
       <b><center>비밀번호를 입력해 주세요.</center></b>
     </th>
  </tr>
  <tr height="30">
     <td align=center ><b>비밀번호 :</b>   
       <input type="password" name="c_passwd" size="8" maxlength="12">
	 </td>
 </tr>
 </table>
 <p><br>
 <input type="submit" value="글삭제" class="btn btn-sm-5 btn-success">
 <input type="button" value="글목록" onclick="document.location.href='list.do?pageNum=${pageNum}'" class="btn btn-sm-5 btn-success">
</form>
</body>
<footer>
<jsp:include page="footer.jsp" flush="false" />
</footer>
</html> 
