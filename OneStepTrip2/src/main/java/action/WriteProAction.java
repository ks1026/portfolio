package action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommunityDAO;
//추가
//BoardDAO,BoardDTO
import model.CommunityDTO;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.writePro.jsp의 자바처리 구문
		request.setCharacterEncoding("utf-8");//한글처리
		HttpSession session = request.getSession();    //세션 객체 만들기
		
		String sId = (String) session.getAttribute("idKey");
		CommunityDTO article=new CommunityDTO();
		
		article.setC_num(Integer.parseInt(request.getParameter("c_num")));//hidden
		article.setM_id(sId);
		article.setC_subject(request.getParameter("c_subject"));
		System.out.println("c_subject=>" + article.getC_subject()); //o
		//readcount(0) 생략,오늘날짜(컴퓨터의 날짜),원격주소 ip
//		Date temp=new Date(System.currentTimeMillis());
//		article.setDate(temp);//오늘 날짜 수동저장
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		//조회수->자동으로 0을 default
		article.setC_content(request.getParameter("c_content"));
		
		CommunityDAO dbPro=new CommunityDAO();
		dbPro.insertArticle(article);
		//3.공유해서 페이지 이동
		return "/writePro.jsp";// /list.do로 처리->/list.jsp
	}

}
