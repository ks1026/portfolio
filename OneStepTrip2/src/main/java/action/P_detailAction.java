package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductAllDTO;
import model.Product_dateDTO;

public class P_detailAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		
		ProductDAO pdao = new ProductDAO();
		ProductAllDTO pdto = pdao.DetailProduct(p_num);
		List<Product_dateDTO> pdate =pdao.dateProduct(p_num);
		
		
		String imgFolderName = "";
		if(pdto.getP_num()>=1 && pdto.getP_num()<= 6) { // 아시아			
			imgFolderName = "asia";
		} else if(pdto.getP_num()>=7 && pdto.getP_num()<= 12) { // 유럽			
			imgFolderName = "europe";
		} else if(pdto.getP_num()>=13 && pdto.getP_num()<= 14) { // 오세아니아 		
			imgFolderName = "oceania";
		} else { // 아메리카	
			imgFolderName = "northAmerica";
		}
		
	//	HttpSession session = request.getSession();    //세션 객체 만들기
	
	
		System.out.println("pdate - ");
		System.out.println(pdate);
		
		
		request.setAttribute("pdto", pdto); //여행상품디테일 정보
		request.setAttribute("imgFolderName", imgFolderName); //이미지폴더이름
		request.setAttribute("pdate", pdate); //여행날짜
		request.setAttribute("fromDate", pdate.get(0).getPd_date());
		request.setAttribute("toDate", pdate.get(pdate.size()-1).getPd_date());
		//request.setAttribute("id",session.getAttribute("idKey"));
		return "/P_detail.jsp";
	}

}
