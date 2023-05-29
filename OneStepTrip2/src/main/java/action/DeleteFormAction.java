package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		//deleteForm.jsp?num=2&pageNum=1 => deletePro.jsp
		int c_num=Integer.parseInt(request.getParameter("c_num"));
		String pageNum=request.getParameter("pageNum");//페이지번호
		System.out.println("DeleteFormAction의c_num=>"+c_num+",pageNum=>"+pageNum);
		
		request.setAttribute("c_num",c_num);//삭제할 게시물번호
	    request.setAttribute("pageNum",pageNum);
		
		return "/deleteForm.jsp";
	}

}
