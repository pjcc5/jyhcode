package pojo;

import java.io.Serializable;


public class Classes  implements Serializable{
	private java.lang.String classid;//classid
	private java.lang.String size;//size
	private java.lang.Integer season;//season
	private java.lang.String color;//color
	private java.lang.String brand;//brand
	private java.lang.String classes;//classes
	private java.lang.String test1;//test1
	private java.lang.String test2;//test2
	private java.lang.String test3;//test3
	private java.lang.String test4;//test4
	private java.lang.String test5;//test5
	
	public java.lang.String getClassid() {
		return classid;
	}
	public void setClassid(java.lang.String classid) {
		this.classid = classid;
	}
	public java.lang.String getSize(){
		return this.size;
	}
	public void setSize(java.lang.String size){
		this.size	= size;
	}
	public java.lang.Integer getSeason(){
		return this.season;
	}
	public void setSeason(java.lang.Integer season){
		this.season	= season;
	}
	public java.lang.String getColor(){
		return this.color;
	}
	public void setColor(java.lang.String color){
		this.color	= color;
	}
	public java.lang.String getBrand(){
		return this.brand;
	}
	public void setBrand(java.lang.String brand){
		this.brand	= brand;
	}
	public java.lang.String getClasses(){
		return this.classes;
	}
	public void setClasses(java.lang.String classes){
		this.classes	= classes;
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
	public java.lang.String getTest5(){
		return this.test5;
	}
	public void setTest5(java.lang.String test5){
		this.test5	= test5;
	}
	@Override
	public String toString() {
		return "Classes [classid=" + classid + ", size=" + size + ", season="
				+ season + ", color=" + color + ", brand=" + brand
				+ ", classes=" + classes + ", test1=" + test1 + ", test2="
				+ test2 + ", test3=" + test3 + ", test4=" + test4 + ", test5="
				+ test5 + "]";
	}
	
	
	
}