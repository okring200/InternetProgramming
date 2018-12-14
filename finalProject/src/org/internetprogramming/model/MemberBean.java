package org.internetprogramming.model;

public class MemberBean {
	private String uid;
	private String pw;
	private String name;
	public MemberBean() {
		this.uid = null;
		this.pw = null;
		this.name=null;
	}
	public MemberBean(String uid, String pw, String name) {
		super();
		this.uid = uid;
		this.pw = pw;
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberBean [uid=" + uid + ", pw=" + pw + "]";
	}
}
