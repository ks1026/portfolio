$(function() {
	
	// 회원가입 버튼을 클릭했을 때 이벤트 처리 
	$("#btnSubmit").on("click", function() {
		 // pwd불일치 여부체크
	 	var pwd1=$('#m_passwd').val()
		var pwd2=$('#m_repasswd').val()
		// 불일치 체크
		if(pwd1 != pwd2){
			alert("비밀번호가 일치하지않습니다. 한번더 확인해주세요.");
			return false;
		}
	});
	
	// id중복확인 버튼 클릭했을 때 이벤트 처리 
	$("#btnIdCheck").on("click", function() {
		var id = $("#m_id").val();
		if(id == "") {
			alert("ID를 입력하세요.");
			return;
		}
		location.href="M_idcheck.do?id=" + id;
	});
	
	// 우편번호 찾기 버튼 클릭했을 때 이벤트 처리 
	$("#btnZipcode").on("click", function() {
		new daum.Postcode({
			oncomplete:function(data) {
				$('#m_zipcode').val(data.zonecode); // 우편번호
				$("#m_address").val(data.address); // 주소 
			}
		}).open();
	});

	
	
	
});