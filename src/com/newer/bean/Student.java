package com.newer.bean;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{
	
	private int sid;
	private String sname;
	private String ssex;
	private Date sbirthday;
	private ClassInfo sclass;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public Date getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	public ClassInfo getSclass() {
		return sclass;
	}
	public void setSclass(ClassInfo sclass) {
		this.sclass = sclass;
	}
	
	
	

}
