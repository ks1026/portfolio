package model;

public class EventInfoDTO { //이벤트정보
	private int e_num; //이번트번호
	private String e_name; //이벤트명
	private String e_content; //이벤트내용
	private String e_coupon; // 쿠폰코드
	private int e_discount; // 쿠폰할인금액
	private String e_enddate; //이벤트 만료일
	
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
	}
	public String getE_coupon() {
		return e_coupon;
	}
	public void setE_coupon(String e_coupon) {
		this.e_coupon = e_coupon;
	}
	public int getE_discount() {
		return e_discount;
	}
	public void setE_discount(int e_discount) {
		this.e_discount = e_discount;
	}
	public String getE_enddate() {
		return e_enddate;
	}
	public void setE_enddate(String e_enddate) {
		this.e_enddate = e_enddate;
	}
	
}
