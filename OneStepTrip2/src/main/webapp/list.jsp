<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
	table > thead > tr > th {
    background: #7cc1a1 !important;
	color: white;
	}
</style>
<title>게시판</title>
</head>
<jsp:include page="top.jsp" flush="false" />
<center><img class="im" alt="a-1" src="./image/mountain.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<p>
<body bgcolor="#ffffff">
<center><h3><b>게시판(전체 글:${pgList.count})</b></h3>
<c:choose>
<c:when test="${not empty idKey}">
<table width="900">
	<tr>
   	 <td align="right" bgcolor="#ffffff">
		<a href="writeForm.do"><button class="btn btn-secondary">글쓰기</button></a>
	 </td>
	</tr>
</table>	
<br>
</c:when>
<c:when test="${empty idKey}">
<table width="900">
	<tr>
   	 <td align="right" bgcolor="#ffffff">
		<button onclick="if(confirm('로그인을 해주세요.'))location.href='M_login.jsp';"
					  type="button">글쓰기</button>
	 </td>
	</tr>
</table>
</c:when>
</c:choose>


<!-- 데이터의 유무 -->

<c:if test="${pgList.count==0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
	<thead>
	<tr>
		<th align="center">게시판에 저장된 글이 없습니다.</td>
	</tr>
	</thead>
</table>
</c:if>
<c:if test="${pgList.count > 0}">
<table border="1" width="600" cellpadding="0" cellspacing="0" align="center" class="ui celled table" style="width: 50%; margin: auto;"> 
<thead class="table">
    <tr height="20"> 
      <th width="50"><center>번 호</center></td> 
      <th width="250"><center>제   목</center></td> 
      <th width="100"><center>작성자</center></td>
      <th width="150"><center>작성일</center></td> 
      <th width="50"><center>조 회</center></td>
    </tr>
    </thead>
    <!-- 실질적으로 레코드를 출력시켜주는 부분
    		this(현재 마우스를 갖다댄 객체(tr)을 의미 -->
    		
    <c:set var="number" value="${pgList.number}"/>
    <c:forEach var="article" items="${articleList}">
   <tr height="30" onmouseover="this.style.backgroundColor='#cccccc'"
   							onmouseout="this.style.backgroundColor='#ffffff'">
   <!-- 하나씩 감소하면서 출력하는 게시물번호 -->
    <td align="center"  width="50" >
    	<c:out value="${number}"/>
    	<c:set var="number" value="${number-1}"/>
    </td>
    <td  width="250" >
	  <!-- 답변글인 경우 먼저 답변이미지를 부착시키는 코드 -->
	 <c:if test="${article.re_level > 0 }">
		  <img src="image/level.gif" width="${7*article.re_level }" height="16">
		  <img src="image/re.gif">
	  </c:if> 
	  <c:if test="${article.re_level == 0 }">
		  <img src=" image/level.gif" width="0" height="16">  
	 </c:if>
	  
      <a href="content.do?c_num=${article.c_num}&pageNum=${pgList.currentPage}">
           ${article.c_subject}</a> 
         
         <c:if test="${article.c_readcount >= 20}">
         <img src="image/hot.gif" border="0"  height="16"> 
         </c:if>
       </td>
       <td align="center"  width="150">
       	${article.m_id}
       </td>
    <td align="center"  width="150">
   		 <fmt:formatDate value="${article.date}"
   		 							timeStyle="medium"
   		 							pattern="yy.MM.dd" />
    </td>
    <td align="center"  width="50">${article.c_readcount}</td>
  </tr>
  </c:forEach>
</table>
</c:if>
<!-- 페이징처리 -->

	<c:if test="${pgList.startPage > pgList.blockSize}">
		<a href="/OneStepTrip/list.do?pageNum=${pgList.startPage-pgList.blockSize}&search=${search}&searchtext=${searchtext}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${pgList.startPage}" end="${pgList.endPage}">
		<a href="/OneStepTrip/list.do?pageNum=${i}&search=${search}&searchtext=${searchtext}">
			<c:if test="${pgList.currentPage==i}">
				<font color="red"><b>[${i}]</b></font>
			</c:if>
			<c:if test="${pgList.currentPage!=i}">
				[${i}]
			</c:if>
		</a>
	</c:forEach>
	
	<c:if test="${pgList.endPage < pgList.pageCount}">
		<a href="/OneStepTrip/list.do?pageNum=${pgList.startPage+pgList.blockSize}&search=${search}&searchtext=${searchtext}">[다음]</a>
	</c:if>
 
 <p>
  <!-- 
 	검색어 추가(자주 검색이 되는 항목을 잘 선택) 제목,작성자,제목+본문
 	ex) search.do=>새로운 요청명령어를 이용해서 추가
 		 list.do=>기존의 내용을 추가
 		 검색분야=>필드명과 일치하게 이름을 작성->검색을 편하게 작업
  -->
 <form name="test" action="list.do">
 	<select name="search">
 		<option value="m_id">작성자</option>
 		<option value="c_subject">제목</option>
 		<option value="c_subject_c_content">제목+본문</option>
 	</select>
 	<input type="text" size="15" name="searchtext">&nbsp;
 	<input type="submit" value="검색" class="btn btn-sm-5 btn-success">
 </form>
</center>
</body>
<footer>
<jsp:include page="footer.jsp" flush="false" />
</footer>

</html>