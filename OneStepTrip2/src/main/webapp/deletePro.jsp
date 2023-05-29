<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
	<script>
	alert("삭제되었습니다.");
	</script>
<meta http-equiv="Refresh" content="0;url=list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
	<script>
		alert("비밀번호를 확인해주세요.");
		history.go(-1);
	</script>		
</c:if>

