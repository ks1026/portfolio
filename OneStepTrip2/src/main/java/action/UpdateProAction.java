package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommunityDAO;
import model.CommunityDTO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.updatePro.jsp의 자바처리 구문
		request.setCharacterEncoding("utf-8");//한글처리
		//추가(수정할 페이지로 이동)
		String pageNum=request.getParameter("pageNum");
		System.out.println("UpdateProAction에서의 pageNum=>"+pageNum);
		
		HttpSession session = request.getSession();
		
		CommunityDTO article=new CommunityDTO();
		String sId = (String) session.getAttribute("idKey");
		
		article.setC_num(Integer.parseInt(request.getParameter("c_num")));//hidden
		article.setM_id(sId);
		article.setC_subject(request.getParameter("c_subject"));
		article.setC_content(request.getParameter("c_content"));
		   
		
		if(sId!=null) {
			CommunityDAO dbPro=new CommunityDAO();
			int Check=dbPro.updateArticle(article,sId);			
	
		//2.공유
		request.setAttribute("pageNum",pageNum);//페이지이동
		request.setAttribute("Check",Check);//${check}수정성공유무
	
		}
		//3.공유해서 페이지 이동
		return "/updatePro.jsp";
	}

}
