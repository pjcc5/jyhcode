package pojo;

import java.io.Serializable;



public class Shopping  implements Serializable{
	private java.lang.Integer shopid;//aid
	private java.lang.String comid;//comid
	private java.lang.Integer count;//count
	private java.sql.Timestamp date;//date
	private java.lang.String test1;//test1
	private java.lang.String test2;//test2
	private java.lang.String test3;//test3
	private java.lang.String test4;//test4
	
	public java.lang.Integer getShopid() {
		return shopid;
	}
	public void setShopid(java.lang.Integer shopid) {
		this.shopid = shopid;
	}
	public java.lang.String getComid(){
		return this.comid;
	}
	public void setComid(java.lang.String comid){
		this.comid	= comid;
	}
	public java.lang.Integer getCount(){
		return this.count;
	}
	public void setCount(java.lang.Integer count){
		this.count	= count;
	}
	public java.sql.Timestamp getDate(){
		return this.date;
	}
	public void setDate(java.sql.Timestamp date){
		this.date	= date;
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
		return "Shopping [shopid=" + shopid + ", comid=" + comid + ", count="
				+ count + ", date=" + date + ", test1=" + test1 + ", test2="
				+ test2 + ", test3=" + test3 + ", test4=" + test4 + "]";
	}
	
	
}