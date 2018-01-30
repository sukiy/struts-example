package com.struts.entity;

/**
 * 封装科目信息
 * @author Administrator
 *
 */
public class Subjects {

	private int subno;
	private String subname;
	
	public Subjects() {
		super();
	}
	public Subjects(int subno, String subname) {
		super();
		this.subno = subno;
		this.subname = subname;
	}
	public int getSubno() {
		return subno;
	}
	public void setSubno(int subno) {
		this.subno = subno;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	
}






