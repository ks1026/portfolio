package model;

public class NoticeDTO {//공지사항
	private String n_num; //공지사항글번호
	private String manager_id; //관리자아이디
	private String n_subejct; //공지글제목
	private String n_content; //공지글내용
	private String n_date; //작성날짜
	
	public String getN_num() {
		return n_num;
	}
	public void setN_num(String n_num) {
		this.n_num = n_num;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getN_subejct() {
		return n_subejct;
	}
	public void setN_subejct(String n_subejct) {
		this.n_subejct = n_subejct;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	
	
}
