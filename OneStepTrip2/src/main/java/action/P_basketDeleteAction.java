package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductAllDTO;
import model.Product_dateDTO;

public class P_basketDeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");  //마이페이지의 장바구니용 번호
		int p_num = Integer.parseInt(request.getParameter("p_num")); //상품번호
		String m_id = request.getParameter("m_id"); //회원아이디
		
		ProductDAO pdao = new ProductDAO();
		
		// delete 
		int check = pdao.BasketDelete(m_id, p_num);
		System.out.println("basket delete check : " + check);
		
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
		System.out.println("pbasket size =====: "+ pbasket.size());
		request.setAttribute("pbasket",pbasket);
		request.setAttribute("m_id",m_id);
		
		return "/M_info.jsp?id=" + id;
	}

}
