package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P_asiaAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int start = 0;
		int end = 0;

		String imgFolderName = "";
		String cType = request.getParameter("cType");
		if(cType.equals("1")) { // 아시아			
			start = 1;
			end = 6;
			imgFolderName = "asia";
		} else if(cType.equals("2")) { // 유럽			
			start = 7;
			end = 12;	
			imgFolderName = "europe";
		} else if(cType.equals("3")) { // 오세아니아 		
			start = 13;
			end = 14;
			imgFolderName = "oceania";
		} else { // 아메리카		
			start = 15;
			end = 16;
			imgFolderName = "northAmerica";
		}
		
		ProductDAO pdao = new ProductDAO();
		List P_list = pdao.searchProduct(start, end);
		
		System.out.println("P_asiaAction P_list : " + P_list.size());
		request.setAttribute("P_list", P_list);
		request.setAttribute("imgFolderName", imgFolderName);
		
		return "/P_asia.jsp";
		
	}

}
