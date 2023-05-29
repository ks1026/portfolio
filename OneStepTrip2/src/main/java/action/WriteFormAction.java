package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int c_num=0,ref=1,re_step=0,re_level=0;   
		
		System.out.println("request.getParameter(\"c_num\") --------->");
		System.out.println(request.getParameter("c_num"));
	   //content.do에서 매개변수로 전달
	   if(request.getParameter("c_num")!=null){//0,음수 X=>양수1이상
		   c_num=Integer.parseInt(request.getParameter("c_num"));
		   ref=Integer.parseInt(request.getParameter("ref"));
		   re_step=Integer.parseInt(request.getParameter("re_step"));
		   re_level=Integer.parseInt(request.getParameter("re_level"));
		   System.out.println("content.jsp에서 넘어온 매개변수 확인");
		   System.out.println("c_num=>"+c_num+",ref=>"+ref);
		   System.out.println(",re_step=>"+re_step+",re_level=>"+re_level);
	   }
	   //2.실행결과->서버의 메모리에 저장=>공유해서 이동
	   request.setAttribute("c_num", c_num); 
	   request.setAttribute("ref", ref);
	   request.setAttribute("re_step", re_step);
	   request.setAttribute("re_level", re_level);
	   
	   return "/writeForm.jsp";
	}

}
