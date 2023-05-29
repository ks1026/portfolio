package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P_payRefundAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_id = request.getParameter("m_id");
		
		ProductDAO pdao = new ProductDAO();
		int check = pdao.deletePaymentInfo(m_id);
		System.out.println("결제데이터삭제 : " + check);
		
		return "/index.jsp";
	}

}
