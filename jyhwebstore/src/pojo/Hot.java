package pojo;

import java.io.Serializable;
import java.util.Date;


public class Hot  implements Serializable{
	private int hotcom;//hotcom
	private java.lang.String hotcomid;//hotcomid
	private Date hotdatestart;//hotdatestart
	private Date hotdatend;//hotdatend
	private java.lang.String test1;//test1
	private java.lang.String test2;//test2
	private java.lang.String test3;//test3
	
	
	public int getHotcom() {
		return hotcom;
	}
	public void setHotcom(int hotcom) {
		this.hotcom = hotcom;
	}
	public java.lang.String getHotcomid() {
		return hotcomid;
	}
	public void setHotcomid(java.lang.String hotcomid) {
		this.hotcomid = hotcomid;
	}
	

	public Date getHotdatestart() {
		return hotdatestart;
	}
	public void setHotdatestart(Date hotdatestart) {
		this.hotdatestart = hotdatestart;
	}
	public Date getHotdatend() {
		return hotdatend;
	}
	public void setHotdatend(Date hotdatend) {
		this.hotdatend = hotdatend;
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