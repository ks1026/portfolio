package model;

public class ManagerDTO { //관리자정보
	private String manager_id; //관리자아이디
	private String manager_passwd; //관리자비번
	
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_passwd() {
		return manager_passwd;
	}
	public void setManager_passwd(String manager_passwd) {
		this.manager_passwd = manager_passwd;
	}
	
	
}
