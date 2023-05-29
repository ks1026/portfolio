package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;


public class M_registerAction implements CommandAction{
	
@Override
public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// TODO Auto-generated method stub
	
			request.setCharacterEncoding("UTF-8");
			
			MemberDTO mdto = new MemberDTO();
			mdto.setM_id(request.getParameter("m_id"));
			mdto.setM_passwd(request.getParameter("m_passwd"));
			mdto.setM_name(request.getParameter("m_name"));
			mdto.setM_email(request.getParameter("m_email"));
			mdto.setM_address(request.getParameter("m_address"));
			mdto.setM_zipcode(request.getParameter("m_zipcode"));
			mdto.setM_phone(request.getParameter("m_phone"));
			
			MemberDAO mdao = new MemberDAO();
			boolean check = mdao.memberInsert(mdto);
			
			request.setAttribute("check",check);
			request.setAttribute("mdao", mdao);
			return "/index.jsp";
			
	}
}