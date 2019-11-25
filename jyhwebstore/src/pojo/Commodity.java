package pojo;

import java.io.Serializable;

public class Commodity  implements Serializable{
	private java.lang.String comid;//comid
	private java.lang.String comname;//comname
	private java.lang.String compic;//compic
	private java.lang.String comdetails;//comdetails
	private java.lang.Double comprice;//comprice
	private java.lang.String comclass;//comclass
	private java.lang.String test1;//test1
	private java.lang.String test2;//test2
	private java.lang.String test3;//test3
	private java.lang.String test4;//test4
	public java.lang.String getComid(){
		return this.comid;
	}
	public void setComid(java.lang.String comid){
		this.comid	= comid;
	}
	public java.lang.String getComname(){
		return this.comname;
	}
	public void setComname(java.lang.String comname){
		this.comname	= comname;
	}
	public java.lang.String getCompic(){
		return this.compic;
	}
	public void setCompic(java.lang.String compic){
		this.compic	= compic;
	}
	public java.lang.String getComdetails(){
		return this.comdetails;
	}
	public void setComdetails(java.lang.String comdetails){
		this.comdetails	= comdetails;
	}
	public java.lang.Double getComprice(){
		return this.comprice;
	}
	public void setComprice(java.lang.Double comprice){
		this.comprice	= comprice;
	}
	
	public java.lang.String getComclass() {
		return comclass;
	}
	public void setComclass(java.lang.String comclass) {
		this.comclass = comclass;
	}
	public java.lang.String getTest1(){
		return this.test1;
	}
	public void setTest1(java.lang.String test1){
		this.test1	= test1;
	}
	public java.lang.String getTest2(){
		return this.test2;
	}
	public void setTest2(java.lang.String test2){
		this.test2	= test2;
	}
	public java.lang.String getTest3(){
		return this.test3;
	}
	public void setTest3(java.lang.String test3){
		this.test3	= test3;
	}
	public java.lang.String getTest4(){
		return this.test4;
	}
	public void setTest4(java.lang.String test4){
		this.test4	= test4;
	}
	@Override
	public String toString() {
		return "Commodity [comid=" + comid + ", comname=" + comname
				+ ", compic=" + compic + ", comdetails=" + comdetails
				+ ", comprice=" + comprice + ", comclass=" + comclass
				+ ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3
				+ ", test4=" + test4 + "]";
	}
	
	
	
}