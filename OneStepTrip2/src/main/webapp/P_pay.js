 $(function(){
/**
 * 2022 10 14 
 th kim
 */

	
		
	$("#payHistory").on("click", function(){
		var m_id = $("#m_id").val();
		var total = $("#total").val();
		var payment = $("input[type=radio][name=pay]:checked").val();
		if(payment==null || payment==""){
			alert("결제방법을 체크해주세요");
			return;
		} 
			
			alert("결제가 완료되셨습니다. 즐거운 여행 되시길 바랍니다.");
			location.href="P_pHistory.do?id=area4&m_id=" + m_id + "&total="+ total + "&payment="+payment;			
			
		
		
	});
	
	
});