package pojo;

import java.io.Serializable;


public class Hot  implements Serializable{
	private java.lang.String hotcom;//hotcom
	private java.lang.Integer hotcomid;//hotcomid
	private java.sql.Timestamp hotdatestart;//hotdatestart
	private java.sql.Timestamp hotdatend;//hotdatend
	private java.lang.String test1;//test1
	private java.lang.String test2;//test2
	private java.lang.String test3;//test3
	public java.lang.String getHotcom(){
		return this.hotcom;
	}
	public void setHotcom(java.lang.String hotcom){
		this.hotcom	= hotcom;
	}
	public java.lang.Integer getHotcomid(){
		return this.hotcomid;
	}
	public void setHotcomid(java.lang.Integer hotcomid){
		this.hotcomid	= hotcomid;
	}
	public java.sql.Timestamp getHotdatestart(){
		return this.hotdatestart;
	}
	public void setHotdatestart(java.sql.Timestamp hotdatestart){
		this.hotdatestart	= hotdatestart;
	}
	public java.sql.Timestamp getHotdatend(){
		return this.hotdatend;
	}
	public void setHotdatend(java.sql.Timestamp hotdatend){
		this.hotdatend	= hotdatend;
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
	@Override
	public String toString() {
		return "Hot [hotcom=" + hotcom + ", hotcomid=" + hotcomid
				+ ", hotdatestart=" + hotdatestart + ", hotdatend=" + hotdatend
				+ ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3
				+ "]";
	}
	
	
}