package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PaymentInfoDTO;

public class P_pHistoryAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");//마이페이지-결제내역	
		String m_id = request.getParameter("m_id"); //아이디
		
		ProductDAO pdao = new ProductDAO();
		
		int total = 0;
		String payment = "";
		
		if(request.getParameter("payment") != null) {
			total = Integer.parseInt(request.getParameter("total")); //총금액
			payment = request.getParameter("payment");//결제수단
			
			int payCheck = pdao.insertPay(m_id, total, payment); //결제정보테이블 데이터입력
			System.out.println("payCheck =>"+payCheck);
		}
		
		List<PaymentInfoDTO> payList = pdao.payInfo(m_id);//결제데이터 조회
		System.out.println("payList사이즈 =>"+payList.size());
		
		request.setAttribute("payList", payList);
		request.setAttribute("m_id", m_id);
		
		return "/M_info.jsp?id=" +id;
	}

}
