package pojo;

import java.io.Serializable;
import java.util.Date;





public class User  implements Serializable{
	private java.lang.Integer uid;//uid
	private java.lang.String uname;//uname
	private java.lang.String pic;//pic
	private Date birth;//birth
	private java.lang.String sex;//sex
	private java.lang.String uphone;//uphone
	private java.lang.String mail;//mail
	private java.lang.String setadd;//setadd
	private String aid;
	public String getAid()
	{
		return this.aid;
	}
	public void setAid(String aid)
	{
		this.aid=aid;
	}
	
	public java.lang.Integer getUid(){
		return this.uid;
	}
	public void setUid(java.lang.Integer uid){
		this.uid	= uid;
	}
	public java.lang.String getUname(){
		return this.uname;
	}
	public void setUname(java.lang.String uname){
		this.uname	= uname;
	}
	public java.lang.String getPic(){
		return this.pic;
	}
	public void setPic(java.lang.String pic){
		this.pic	= pic;
	}

	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public java.lang.String getSex(){
		return this.sex;
	}
	public void setSex(java.lang.String sex){
		this.sex	= sex;
	}
	public java.lang.String getUphone(){
		return this.uphone;
	}
	public void setUphone(java.lang.String uphone){
		this.uphone	= uphone;
	}
	public java.lang.String getMail(){
		return this.mail;
	}
	public void setMail(java.lang.String mail){
		this.mail	= mail;
	}
	public java.lang.String getSetadd(){
		return this.setadd;
	}
	public void setSetadd(java.lang.String setadd){
		this.setadd	= setadd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pic=" + pic
				+ ", birth=" + birth + ", sex=" + sex + ", uphone=" + uphone
				+ ", mail=" + mail + ", setadd=" + setadd + ", aid=" + aid
				+ "]";
	}
}