package model;

public class ProductReviewDTO {

	private int pr_num;//리뷰번호
	private int p_num;//상품번호
	private String m_id;//회원아이디
	private String pr_content;//리뷰내용
	private int pr_score;//평점
	private String pr_date;//등록날짜
	private String pr_best;//베스트리뷰여부
	
	public int getPr_num() {
		return pr_num;
	}
	public void setPr_num(int pr_num) {
		this.pr_num = pr_num;
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
	public String getPr_content() {
		return pr_content;
	}
	public void setPr_content(String pr_content) {
		this.pr_content = pr_content;
	}
	public int getPr_score() {
		return pr_score;
	}
	public void setPr_score(int pr_score) {
		this.pr_score = pr_score;
	}
	public String getPr_date() {
		return pr_date;
	}
	public void setPr_date(String pr_date) {
		this.pr_date = pr_date;
	}
	public String getPr_best() {
		return pr_best;
	}
	public void setPr_best(String pr_best) {
		this.pr_best = pr_best;
	}
	
}
