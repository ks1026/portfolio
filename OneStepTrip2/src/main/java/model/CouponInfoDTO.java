package model;

public class CouponInfoDTO { //사용자별 쿠본정보
	private int c_num; //사용자별 쿠폰정보에 대한 번호
	private String m_id; //회원아이디
	private int e_num; //이벤트번호
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	
}
