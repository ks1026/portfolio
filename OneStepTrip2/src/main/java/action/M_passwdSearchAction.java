package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M_passwdSearchAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		System.out.println("m_name=>" + m_name);
		System.out.println("m_id=>" + m_id);
		
		MemberDAO mdao = new MemberDAO();
		boolean passwdSearch = mdao.passwdSearch(m_name, m_id);
		if(passwdSearch == true) {
			request.setAttribute("passwdSearch", 3);					
			request.setAttribute("m_id", m_id);					
		} else {
			request.setAttribute("passwdSearch", 4);					
		}
		
		return "/M_passwdSearchProc.jsp?";
	}

}
