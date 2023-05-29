package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommunityDAO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int c_num=Integer.parseInt(request.getParameter("c_num"));
		String c_passwd = request.getParameter("c_passwd");
		String pageNum = request.getParameter("pageNum");
		System.out.println("deletePro.do의 c_num="+c_num+"c_passwd->" + c_passwd);
		
		CommunityDAO dbPro=new CommunityDAO();
		HttpSession session = request.getSession();
		String m_id = (String)session.getAttribute("idKey");
		System.out.println("세션m_id=>" + m_id);
		int check=dbPro.deleteArticle(c_num, c_passwd, m_id);
		System.out.println("check->" + check);
		request.setAttribute("check",check);
		request.setAttribute("pageNum",pageNum);
		
		return "/deletePro.jsp";
	}

}
