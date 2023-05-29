package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommunityDAO;
import model.CommunityDTO;

// /updateForm.do?c_num=3&pageNum=1
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//content.jsp->글수정->updateForm.jsp?c_num=3&page=1
		int c_num=Integer.parseInt(request.getParameter("c_num"));
		String pageNum=request.getParameter("pageNum");
		System.out.println
		("UpdateFormAction에서의 pageNum=>"+pageNum+",c_num=>"+c_num);
		
		CommunityDAO dbPro=new CommunityDAO();
		CommunityDTO article=dbPro.updateGetArticle(c_num);//조회수X
		//2.서버에 저장
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("article",article);
		
		return "/updateForm.jsp";
	}

}
