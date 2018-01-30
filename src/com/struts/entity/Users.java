package com.struts.entity;

public class Users {

	private int uno;
	private String uname;
	private String upwd;
	
	public Users(int uno, String uname, String upwd) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.upwd = upwd;
	}
	public Users() {
		super();
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	
}
