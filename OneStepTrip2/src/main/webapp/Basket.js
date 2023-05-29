/**
 *
  2022 10 11
 Taeho Kim
 */
 
 //결제하기전 로그인상태를 확인해주는 함수
$(function() {
	$("#basketButton").on("click", function() {
		var id = getItem();
		var userId = $("#hidUserId").val(); 
		var p_num = $("#p_num").val(); // val --> val()
		if (id == null || id == "") {
			alert("로그인을 먼저 해주세요.");
			location.href = "M_login.jsp";
		} else {
			location.href="P_basket.do?id=area2&p_num="+p_num +"&m_id="+userId ;
		}
	});
	
	function getItem() {
		//Top에서 저장해논 hidden textfield에서 저장된 사용자 아이디를 가져온다.
		var userId = $("#hidUserId").val(); 
		return userId;
	}
});