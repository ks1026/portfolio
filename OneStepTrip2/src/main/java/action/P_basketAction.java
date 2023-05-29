package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PaymentInfoDTO;
import model.ProductAllDTO;
import model.Product_dateDTO;

public class P_basketAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");  //마이페이지의 장바구니용 번호
		String m_id = request.getParameter("m_id"); //회원아이디
		
		// insert
		int p_num = 0;
		ProductDAO pdao = new ProductDAO();
		if(request.getParameter("p_num") != null) {
			p_num = Integer.parseInt(request.getParameter("p_num")); //상품번호
			//장바구니테이블에 넣기
			int check = pdao.BasketInsert(m_id, p_num);
			System.out.println("장바구니테이블데이터 성공유무=>" + check);
		}
		
		System.out.println("m_id : >>>>>>>>>>>>>>" + m_id);
		
		//한 회원에 대한 장바구니 조회
		List<ProductAllDTO> pbasket =pdao.searchBasket(m_id);
	
		for(int i = 0; i < pbasket.size();i++) {		
			ProductAllDTO pdto = pbasket.get(i);
			String imgFolderName = "";
			if(pdto.getP_num()>=1 && pdto.getP_num()<= 6) { // 아시아			
				imgFolderName = "/asia/" + pdto.getPi_way();
				pdto.setPi_way(imgFolderName);
			} else if(pdto.getP_num()>=7 && pdto.getP_num()<= 12) { // 유럽			
				imgFolderName = "/europe/" + pdto.getPi_way();
				pdto.setPi_way(imgFolderName);
			} else if(pdto.getP_num()>=13 && pdto.getP_num()<= 14) { // 오세아니아 		
				imgFolderName = "/oceania/" + pdto.getPi_way();
				pdto.setPi_way(imgFolderName);
			} else { // 아메리카	
				imgFolderName = "/northAmerica/" + pdto.getPi_way();
				pdto.setPi_way(imgFolderName);
			}
		}
		
//		결제데이터 조회
//		List<PaymentInfoDTO> payList = pdao.payInfo(m_id);
//		request.setAttribute("payList", payList);

		System.out.println("pbasket size =====: "+ pbasket.size());

		request.setAttribute("pbasket",pbasket);
//		request.setAttribute("payList", payList);
		
		request.setAttribute("m_id",m_id);
		
		return "/M_info.jsp?id=" + id;
	}

}
