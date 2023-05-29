package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberLoginDTO;

public class M_loginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberLoginDTO mdto = new MemberLoginDTO();
		String m_id = request.getParameter("m_id");
		String m_passwd = request.getParameter("m_passwd");
		
		// 최초에 암호화된 프로퍼티 파일이 없을 것이므로 
		// 아래 코드를 통해 파일 암호화 후 
		// 해당 파일을 불러와서 복호화 하는 것으로 진행 
		// 암호화된 파일이 location2 경로에 저장되어 있음 
		
//		String decryptFileName = "orclEnc.properties"; // 암호화된 파일 지정할 이름
//		String location="C:/webtest/4.jsp/sou/OneStepTrip/src/main/webapp/dbtest/oracle.properties";
//		String location2="C:/webtest/4.jsp/sou/OneStepTrip/src/main/webapp/dbtest/"+decryptFileName;//암호파일
		
		//1)DB파일설정파일->암호화시켜서 암호화파일 생성
//		Crypt.encryptFile(location, location2);//원본파일명,생성할암호화파일명
		
	
		MemberDAO mdao = new MemberDAO();
		boolean loginCheck = mdao.loginCheck(m_id, m_passwd);
		HttpSession session = request.getSession();    //세션 객체 만들기
		System.out.println("loginCheck=>" + loginCheck);
	
		request.setAttribute("loginCheck", loginCheck);
		session.setAttribute("idKey", m_id);	
	
		return "/index.jsp";
		
	}

}
