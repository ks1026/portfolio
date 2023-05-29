$(function() {
	
	// 페이지가 로드될 때
	// 파라미터를 체크해서 
	// div 영역을 보여줌
	var url = window.location.href; // 브라우저에 입력된 url 정보를 가져온다.  (http://localhost:8090/OneStepTrip/P_basket.do?id=area3)
	
	if(url.indexOf("area1") > -1) {
		$(".area").hide();
		$("#area1").show();
	} else if(url.indexOf("area2") > -1) {
		$(".area").hide();
		$("#area2").show();
	} else if(url.indexOf("area3") > -1) {
		$(".area").hide();
		$("#area3").show();
	} else {
		$(".area").hide();
		$("#area4").show();
	}
	 
	 
	var height = $( document ).height();
	$(".leftPanel").css("height", height/2);
	
	// 회원정보, 장바구니, 쿠폰입력, 결제/주문 버튼을 클릭했을 때 이벤트 처리 
	$(".btnClick").on("click", function() {
		
		$(".area").hide(); // 숨기기
		
		var id = $(this)[0].id;
		if(id == "btn1") {
			$("#area1").show();
		} else if(id == "btn2") {
			$("#area2").show();
		} else if(id == "btn3"){
			$("#area3").show();
		}else {
			$("#area4").show();
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


	
	//회원탈퇴 버튼 눌렀을떄 이벤트처리
	$('#btnM_delete').on("click",function(){
		var m_id = $("#m_id").val();
		var delConfirm = confirm(m_id + "님 회원탈퇴 하시겠습니까? ");
		//alert(delConfirm);
		if(delConfirm==true){
		location.href="M_delete.do?m_id=" + m_id;
	
		} else {
			alert("탈퇴가 취소되었습니다.");
		}
	});
	
	// 선택취소 클릭 이벤트 
	$(".rdoClick").on("click", function() {
		var m_id = $("#hidUserId").val();
		var p_num = $(this)[0].id;
		
		location.href="P_basketDelete.do?id=area2&p_num=" + p_num + "&m_id=" + m_id;
	});
	
	//환불처리 이벤트
	$("#payRefund").on("click", function(){
		var m_id = $("#m_id2").val();
		var refund =($('#refund').is(":checked"));
		var select = $("select option:selected").val();
		//alert("refund: " + refund);
		//alert("select: " + select);
		if(refund==null || refund=="" || select == null || select == ""){
			alert("환불유무 또는 환불사유를 선택해주세요.");
			return;
		} 
			alert("환불 처리되었습니다.");
			location.href="P_payRefund.do?m_id="+m_id;			
		
	});
	
	
});