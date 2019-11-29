package pojo;

import java.io.Serializable;


public class Acount  implements Serializable{
	private java.lang.String aid;//aid
	private java.lang.String aname;//aname
	private java.lang.String apass;//apass
	private java.lang.Integer isadm;//isadm
	private java.lang.String aphone;//aphone
	private java.lang.String amail;//amail
	private java.lang.String addr;//addr
	
	public java.lang.String getAid(){
		return this.aid;
	}
	public void setAid(java.lang.String aid){
		this.aid	= aid;
	}
	public java.lang.String getAname(){
		return this.aname;
	}
	public void setAname(java.lang.String aname){
		this.aname	= aname;
	}
	public java.lang.String getApass(){
		return this.apass;
	}
	public void setApass(java.lang.String apass){
		this.apass	= apass;
	}
	public java.lang.Integer getIsadm(){
		return this.isadm;
	}
	public void setIsadm(java.lang.Integer isadm){
		this.isadm	= isadm;
	}
	public java.lang.String getAphone(){
		return this.aphone;
	}
	public void setAphone(java.lang.String aphone){
		this.aphone	= aphone;
	}
	public java.lang.String getAmail(){
		return this.amail;
	}
	public void setAmail(java.lang.String amail){
		this.amail	= amail;
	}
	public java.lang.String getAddr(){
		return this.addr;
	}
	public void setAddr(java.lang.String addr){
		this.addr	= addr;
	}
	@Override
	public String toString() {
		return "Acount [aid=" + aid + ", aname=" + aname + ", apass=" + apass
				+ ", isadm=" + isadm + ", aphone=" + aphone + ", amail="
				+ amail + ", addr=" + addr + ", uuids=" + "]";
	}
}