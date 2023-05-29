package model;

public class MemberDTO { //회원
	private String m_id; //회원아이디
	private String m_passwd; 
	private String m_name;
	private String m_email;
	private String m_address; 
	private String m_zipcode;
	private String m_phone;
	private int m_point; //포인트유무
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = convert(m_id);
	}
	public String getM_passwd() {
		return m_passwd;
	}
	public void setM_passwd(String m_passwd) {
		this.m_passwd = convert(m_passwd);
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = convert(m_name);
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = convert(m_email);
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = convert(m_address);
	}
	public String getM_zipcode() {
		return m_zipcode;
	}
	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = convert(m_zipcode);
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = convert(m_phone);
	}
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	} 
	
		//이 클래스에서만 사용하기 위해서 접근지정자 private <,>,(,) =>변경 메서드
		private static String convert(String name) {
			 if(name!=null){
		    	   //문자열메서드->replaceAll(1.변경전문자열,2.변경후문자열) 
		    	   name=name.replaceAll("<","&lt");
		    	   name=name.replaceAll(">","&gt");
		    	   //추가 ->eval함수의 ()때문에 (,)
		    	   name=name.replaceAll("\\(","&#40");
		    	   name=name.replaceAll("\\)","&#41");
		    	   //추가2=>"test"<-\"test\" ,\'test\' =>'test'
		    	   name=name.replaceAll("\"","&quot");
		    	   name=name.replaceAll("\'","&apos");
		    	     
		       }else{//name==null
		    	   return null;//입력을 하지 않았따면 더 이상 실행X
		       }  
			 return name;
		}
//		-----------------------------------------------------------------------
	
}
