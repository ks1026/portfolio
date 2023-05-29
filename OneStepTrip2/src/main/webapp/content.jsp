<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
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
</head>
<body bgcolor="#ffffff">  
	<jsp:include page="top.jsp" flush="false" />
	<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>
	<p>
	<center><h3><b>글내용 보기</h3></b>
	<br>
	<form>
		<table width="800" border="1" cellspacing="0" cellpadding="0"  bgcolor="#ffffff" align="center" class="table table-bordered" style="width: 50%; margin: auto;" align="center">  
		  	<tr height="30">
		    	<th align="right" width="125" bgcolor="#ffffff">
		    		글번호
		    	</th>
		    	<td align="center" width="125" align="center">
			     	${article.c_num}
				</td>
		    	<th align="center" width="125" bgcolor="#ffffff">
		    		조회수
		    	</th>
		    	<td align="center" width="125" align="center">
			     	${article.c_readcount}
				</td>
		  	</tr>
		  	<tr height="30">
		    	<th align="center" width="125" bgcolor="#ffffff">
		    		작성자
		    	</th>
		    	<td align="center" width="125" align="center">
			     	${article.m_id}
			    </td>
		    	<th align="center" width="125" bgcolor="#ffffff" >
		    		작성일
		    	</th>
		    <td align="center" width="125" align="center">
			     ${article.date}
			</td>
		  </tr>
		  <tr height="30">
		    <th align="center" width="125" bgcolor="#ffffff">
		    	글제목
		    </th>
		    <td align="center" width="375" align="center" colspan="3">
			      ${article.c_subject}
			</td>
		  </tr>
		  <tr>
		    <th align="left" width="125" bgcolor="#ffffff">
		    	글내용
		    </th>
		    <td align="left" width="375" colspan="3">
		    	<pre>
		    		${article.c_content}
		    	</pre>
		    </td>
		  </tr>
		  </table>
		  <p><br>
		  <c:if test="${not empty idKey}"> 
			  <input type="button" value="글수정" 
		       onclick="document.location.href='updateForm.do?c_num=${article.c_num}&pageNum=${pageNum}'" class="btn btn-sm-5 btn-success">
			   &nbsp;&nbsp;&nbsp;&nbsp;
			  
			  <input type="button" value="글삭제"
		       onclick="document.location.href='deleteForm.do?c_num=${article.c_num}&pageNum=${pageNum}'" class="btn btn-sm-5 btn-success">
			   &nbsp;&nbsp;&nbsp;&nbsp;
			 	
		      <input type="button" value="글목록" 
		       onclick="document.location.href='list.do?pageNum=${pageNum}'" class="btn btn-sm-5 btn-success">
		   </c:if>
	</form>
</body>
<footer>
	<jsp:include page="footer.jsp" flush="false" />
</footer>
</html>      
