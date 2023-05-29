package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.MemberDTO;

public class adminUpdateAction implements CommandAction {

	 @Override
	    public String requestPro(HttpServletRequest request,
	            HttpServletResponse response) throws Throwable {
	 
	        request.setCharacterEncoding("UTF-8");
	 
	        // 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
	        MultipartRequest multi = null;
	 
	        // 업로드 될 파일의 최대 사이즈 (10메가)
	        int sizeLimit = 10 * 1024 * 1024;
	 
	        // 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
	        String savePath = request.getRealPath("/upload"); 
	        
	        System.out.println("savePath: " + savePath);
	 
	        // 
	        try{
	            multi=new MultipartRequest(
	                    request
	                    , savePath
	                    , sizeLimit
	                    , "UTF-8"
	                    , new DefaultFileRenamePolicy()); 
	 
	         }catch (Exception e) {
	                e.printStackTrace();
	         } 
	         
	        //파일 이름 저장
	        String pi_num = multi.getParameter("pi_num");
	        String filename = multi.getFilesystemName("filename");
	        System.out.println("filename : " + filename);
	        
	        AdminDAO dao = new AdminDAO();
			System.out.println("dao=>" +dao);
			
	        // 이미지명 업데이트
		    dao.updateImageName(pi_num, filename);
	        
	        // 이미지 다시 조회해서 화면에 출력
	        List<Map<String, Object>> list = new ArrayList();

			list = dao.searchMainImages();
			
			request.setAttribute("imageList", list);
	        return "admin.jsp";
	}

}
