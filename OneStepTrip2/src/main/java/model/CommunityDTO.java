package model;

import java.sql.Date;

public class CommunityDTO {//게시판
	private int c_num; //게시글번호
	private String m_id; //아이디
	private String c_subject; //제목
	private String c_content; //내용
	private String c_passwd; //비번
	private Date c_date; //작성날짜
	private int c_readcount; //조회수
	private int ref; //글그룹
	private int re_level; //글여백
	private int re_step; //글순서
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
	public String getC_subject() {
		return c_subject;
	}
	public void setC_subject(String c_subject) {
		this.c_subject = c_subject;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_passwd() {
		return c_passwd;
	}
	public void setC_passwd(String c_passwd) {
		this.c_passwd = c_passwd;
	}
	public Date getDate() {
		return c_date;
	}
	public void setDate(Date date) {
		this.c_date = date;
	}
	public int getC_readcount() {
		return c_readcount;
	}
	public void setC_readcount(int c_readcount) {
		this.c_readcount = c_readcount;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	
	
	
}
