package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

public class M_updateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberDTO mdto = new MemberDTO();
		mdto.setM_id(request.getParameter("m_id"));
		System.out.println("M_id=>" +  request.getParameter("m_id"));
		System.out.println("m_point=>" +  request.getParameter("m_point"));
		System.out.println("m_passwd=>" +  request.getParameter("m_passwd"));
		mdto.setM_passwd(request.getParameter("m_passwd"));
		mdto.setM_name(request.getParameter("m_name"));
		mdto.setM_email(request.getParameter("m_email"));
		mdto.setM_zipcode(request.getParameter("m_zipcode"));
		mdto.setM_address(request.getParameter("m_address"));
		mdto.setM_phone(request.getParameter("m_phone"));
		mdto.setM_point(Integer.parseInt(request.getParameter("m_point")));

		MemberDAO mdao = new MemberDAO();
		System.out.println("mdao=>" +mdao);
		boolean m_updatecheck = mdao.memberUpdate(mdto);
		
		request.setAttribute("m_updatecheck", m_updatecheck);
		return "/index.jsp";
	}

}
