package model;

public class ProductDTO {

	private int p_num;//상품번호
	private String p_name;//상품이름
	private String p_content;//상품내용
	private String p_date;//등록일
	private int p_readcount;//조회수
	private int p_price;//상품가격
	
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
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_readcount() {
		return p_readcount;
	}
	public void setP_readcount(int p_readcount) {
		this.p_readcount = p_readcount;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	
	
}
