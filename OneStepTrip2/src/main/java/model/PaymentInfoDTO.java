package model;

public class PaymentInfoDTO {

	private int pay_num;//결제번호
	private int p_num;//상품번호
	private String m_id;//회원아이디
	private String pay_date;//상품날짜
	private int pay_price;//결제금액
	private String pay_payment;//결제수단
	private String pay_paydate;//결제일자
	private String pay_refund;//환불유무
	private String p_name;//상품명
	
	public int getPay_num() {
		return pay_num;
	}
	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public String getPay_payment() {
		return pay_payment;
	}
	public void setPay_payment(String pay_payment) {
		this.pay_payment = pay_payment;
	}
	public String getPay_paydate() {
		return pay_paydate;
	}
	public void setPay_paydate(String pay_paydate) {
		this.pay_paydate = pay_paydate;
	}
	public String getPay_refund() {
		return pay_refund;
	}
	public void setPay_refund(String pay_refund) {
		this.pay_refund = pay_refund;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	
	
}
