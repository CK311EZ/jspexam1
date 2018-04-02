package com.newer.bean;

import java.io.Serializable;
import java.sql.Date;

public class ClassInfo implements Serializable{
	
	private String cid;
	private String cname;
	private Date cdate;
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
	

}
