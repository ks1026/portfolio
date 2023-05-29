package model;

public class ProductAllJoinDTO {

	private String m_id; // 회원아이디 
	private int p_num;//상품번호
	private String p_name;//상품이름
	private String pi_way;//이미지경로
	private String s_date; // 출발일 
	private String e_date; // 종료일 
	private int p_price; // 결제금액 
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getPi_way() {
		return pi_way;
	}
	public void setPi_way(String pi_way) {
		this.pi_way = pi_way;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	
}
