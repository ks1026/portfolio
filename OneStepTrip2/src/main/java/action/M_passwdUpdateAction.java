package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M_passwdUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_passwd = request.getParameter("m_passwd");
		String m_id = request.getParameter("m_id");
		
		System.out.println("m_passwd=>" + m_passwd);
		System.out.println("m_id=>" + m_id);
		
		MemberDAO mdao = new MemberDAO();
		boolean passwdUpdate = mdao.passwdUpdate(m_passwd, m_id);
		if(passwdUpdate == true) {
			request.setAttribute("passwdUpdate", 5);					
		} else {
			request.setAttribute("passwdUpdate", 6);					
		}
		
		return "/index.jsp";
	}

}
