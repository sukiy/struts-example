package com.struts.entity;

import java.util.Date;

/**
 * 封装学生信息
 * @author Administrator
 *
 */
public class TbStu {
	
	private int sno;
	private String sname;
	private String ssex;
	private String shobby;
	private Date sintime;
	private String simage;
	private int scno;
	
	public TbStu() {
		super();
	}
	public TbStu(int sno, String sname, String ssex, String shobby, Date sintime, String simage, int scno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.shobby = shobby;
		this.sintime = sintime;
		this.simage = simage;
		this.scno = scno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getShobby() {
		return shobby;
	}
	public void setShobby(String shobby) {
		this.shobby = shobby;
	}
	public Date getSintime() {
		return sintime;
	}
	public void setSintime(Date sintime) {
		this.sintime = sintime;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}
	public int getScno() {
		return scno;
	}
	public void setScno(int scno) {
		this.scno = scno;
	}
}






