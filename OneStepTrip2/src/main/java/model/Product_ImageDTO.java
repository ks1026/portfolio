package model;

public class Product_ImageDTO {

	private int pi_num;//상품이미지번호
	private int p_num;//상품번호
	private String pi_way;//이미지경로
	
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getPi_way() {
		return pi_way;
	}
	public void setPi_way(String pi_way) {
		this.pi_way = pi_way;
	}
	
}
