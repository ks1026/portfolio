package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class M_deleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String m_id = request.getParameter("m_id");
		System.out.println("m_id=>" + m_id);
		MemberDAO mdao = new MemberDAO();
		int m_deleteCheck = mdao.memberDelete(m_id);
		if(m_deleteCheck>0) {
		HttpSession session = request.getSession();
		 session.invalidate(); //세션종료(메모리해제)
		}
		request.setAttribute("m_deleteCheck", m_deleteCheck);
		return "/index.jsp";
	}

}
