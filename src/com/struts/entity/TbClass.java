package com.struts.entity;

/**
 * 班级信息
 * @author Administrator
 *
 */
public class TbClass {

	private int cno;
	private String cname;
	private int csubno;
	
	public TbClass() {
		super();
	}
	public TbClass(int cno, String cname, int csubno) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.csubno = csubno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCsubno() {
		return csubno;
	}
	public void setCsubno(int csubno) {
		this.csubno = csubno;
	}
	
	
}






