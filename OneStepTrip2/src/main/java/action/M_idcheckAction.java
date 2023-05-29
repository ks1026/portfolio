package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;


public class M_idcheckAction implements CommandAction{
	
@Override
public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			
			request.setCharacterEncoding("UTF-8");
	
			String id = request.getParameter("id");
			System.out.println("id = " + id);
			
			// 전달받은 ID를 DB에서 조회하여 중복된 ID인지 아닌지를 체크 
			MemberDAO mdao = new MemberDAO();
			boolean check = mdao.memberIdCheck(id);
			
			System.out.println("idCheck = " + check);
			
			request.setAttribute("id", id);
			request.setAttribute("idCheck", check);
			return "/M_register.jsp";
			
	}
}