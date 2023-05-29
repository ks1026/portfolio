package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;
import model.PaymentInfoDTO;

public class M_infoAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_id = request.getParameter("m_id");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.searchMember(m_id);
		
		

		//결제내역
//		ProductDAO pdao = new ProductDAO();
//		List<PaymentInfoDTO> payList = pdao.payInfo(m_id);//결제데이터 조회
//		System.out.println("payList사이즈 =>"+payList.size());
//		request.setAttribute("payList", payList);
		request.setAttribute("mdto", mdto);
		
		return "/M_info.jsp?id=area1"; 
	}

}
