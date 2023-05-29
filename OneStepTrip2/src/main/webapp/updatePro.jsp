<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${Check==1}">
<meta http-equiv="Refresh" content="0;url=list.do">
</c:if>

<c:if test="${Check!=1}">
		<script>
		alert("정상적으로 수정되셨습니다.")
		location.href="list.do";
		</script>		
</c:if>

