package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class M_logoutAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();    //세션 객체 
		session.invalidate(); //세션종료
		
		request.setAttribute("logout", 1);
		return "/index.jsp";
	}

}
