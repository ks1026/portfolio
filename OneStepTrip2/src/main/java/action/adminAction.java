package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

public class adminAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		List<Map<String, Object>> list = new ArrayList();

		AdminDAO dao = new AdminDAO();
		System.out.println("dao=>" +dao);

		list = dao.searchMainImages();
		
		request.setAttribute("imageList", list);
		return "/admin.jsp";
	}

}
