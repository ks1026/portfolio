package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommunityDAO;
import model.CommunityDTO;

// /content.do?num=3&pageNum=1
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String idKey=(String)session.getAttribute("idKey");
		System.out.println("로그인여부:"+idKey);//체크
		request.setAttribute("idKey", idKey);
		
		//1.content.jsp에서 처리한 자바코드를 대신실행
		//글상세보기=>게시판(쇼핑몰 상품의 정보 SangDetail.jsp?sangid=3&pageNum=1)
		int c_num=Integer.parseInt(request.getParameter("c_num"));//게시물번호
		String pageNum=request.getParameter("pageNum");//페이지번호
		System.out.println
		("contentAction의 pageNum->"+pageNum+",c_num=>"+c_num);
		
		CommunityDAO dbpro=new CommunityDAO();
		CommunityDTO article=dbpro.getArticle(c_num);//Null
		//링크문자열의 길이를 줄이기위해서
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		System.out.println("content.do의 매개변수 확인용");
		System.out.println("ref="+ref+",re_step="+re_step+",re_level="+re_level);
		
		//해당 게시물의 조회수 c_readcount >100->해당글쓴사람(m_id)에 대한  point증가 
			String m_id = article.getM_id();
			int c_readCount = article.getC_readcount();
			if(c_readCount%10==0) {
				int updateResult = dbpro.updatePoint(m_id);
				System.out.println("updateResult=>" + updateResult);
			}
				
		//2.실행결과 서버에 저장
		request.setAttribute("c_num",c_num);//${키명}
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("article",article);//${artucle.ref}~
		//${ref}
		//3.페이지 공유
		return "/content.jsp";
		
		
		
		
	
		
	}

}
