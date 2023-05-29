package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M_idSearchAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		System.out.println("m_name=>" + m_name);
		System.out.println("m_email=>" + m_email);
		
		MemberDAO mdao = new MemberDAO();
		String m_id = mdao.idSearch(m_name, m_email);
		if(m_id!=null) {
			request.setAttribute("m_id", m_id);			
			request.setAttribute("idSearch", 2);			
		} else {
			request.setAttribute("idSearch", 3);
		}
		
		return "/index.jsp";
	}

}
