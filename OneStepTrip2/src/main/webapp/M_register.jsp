<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<title>회원가입</title>
</head>
<style>
	.im{
		width:100%;
		height:300px;
		display:inline-block;
		margin:auto;
	}
	table  tr > th {
	    background: #7cc1a1 !important;
		color: white;
		font-size:18px;
	}
	form {
		margin-top:70px;
		margin-bottom:70px;
	}

</style>
<body>
<!-- top -->
<jsp:include page="top.jsp"/>
<center><img class="im" alt="a-1" src="./image/europe/france.jpg" style="opacity:0.5; vertical-align: bottom"></center>
<p>
<!-- center -->	
<form action="M_register.do" name="Register" method="post">
	<table class="table table-bordered" style="width: 60%; margin: auto;" align="center">
		<tr align="center">
			<td colspan="2" style="font-size:20pt; background-color: #e9ecd3;">회원가입</td>
		</tr>
		<tr>
			<th width="20%">아이디</th>
			<td width="30%">
			<input type="text" name="m_id" id="m_id" size="15" required value="${id}">
			<input type="button" id="btnIdCheck" value="id중복확인" class="btn btn-secondary">
			<c:if test="${id != null && idCheck}">
				<p style="color: red;">중복된 아이디 입니다.</p>
			</c:if> 
			<c:if test="${id != null && !idCheck}">
				<p style="color: blue;">사용 가능한 아이디 입니다.</p>
			</c:if> 
			</td>
		</tr>
		
		<tr>
			<th>패스워드</th>
			<td>
			<input type="password" name="m_passwd" id="m_passwd" size="15" required>
			</td>
		</tr>
		
		<tr>
			<th>패스워드확인</th>
			<td>
			<input type="password" name="m_repasswd" id="m_repasswd" size="15" required>
			</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>
			<input type="text" name="m_name" id="m_name" size="15" required>
			</td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td>
			<input type="text" name="m_email" id="m_email" size="15" required>
			</td>
		</tr>
		
		<tr>  
            <th>전화번호</th>
            <td> <input type="text" name="m_phone" id="m_phone" size="20" required> </td>  
        </tr>
        
		<tr>  
            <th>우편번호</th>
            <td> <input type="text" name="m_zipcode" id="m_zipcode" size="7">
                 <input type="button" id="btnZipcode" value="우편번호찾기"  required class="btn btn-secondary"></td>
          </tr>
          
		 <tr>  
            <th>주소</th>
            <td><input type="text" name="m_address" id="m_address" size="60" required></td>
         </tr>
        
        <tr>
        	<td colspan="2" align="center">
        	 <input id="btnSubmit" type="submit" value="가입하기" class="btn btn-success"> 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
             <input type="reset" value="다시쓰기" class="btn btn-warning"> 
        	</td>
        </tr>
	</table>
  </form>
	
<!-- footer -->
<jsp:include page="footer.jsp"/>
	
</body>
<script type="text/javascript" src="M_input.js"></script>
</html>