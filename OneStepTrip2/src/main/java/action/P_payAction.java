package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductAllDTO;
import model.ProductAllJoinDTO;
import model.Product_dateDTO;

public class P_payAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String m_id = request.getParameter("m_id");
		int total = Integer.parseInt(request.getParameter("total"));
		
		System.out.println("m_id=>"+ m_id);
		System.out.println("total=>"+ total);
		
		ProductDAO pdao = new ProductDAO();
		List<ProductAllJoinDTO> plist = pdao.searchBasketDate(m_id); //한 회원에 대한 여행상품조회
		
		request.setAttribute("m_id", m_id);
		request.setAttribute("total", total); //총결제금액
		request.setAttribute("plist", plist);//여행상품데이터
	
		return "/P_pay.jsp";
	}

}
