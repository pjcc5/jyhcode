package pojo;

import java.io.Serializable;


public class Details  implements Serializable{
	private java.lang.String detailsid;//detailsid
	private java.lang.Integer detailsstock;//detailsstock
	private java.lang.Double detailsprice;//detailsprice
	private java.lang.String detailsdrawing;//detailsdrawing
	private java.lang.Integer detailsdot;//detailsdot
	private java.lang.Integer detailssale;//detailssale
	private java.lang.String color;//color
	private java.lang.String size;//size
	private java.lang.String pai;//
	private java.lang.String test4;//test4
	private java.lang.String test5;//test5
	private java.lang.String test6;//test6
	public java.lang.String getDetailsid(){
		return this.detailsid;
	}
	public void setDetailsid(java.lang.String detailsid){
		this.detailsid	= detailsid;
	}
	public java.lang.Integer getDetailsstock(){
		return this.detailsstock;
	}
	public void setDetailsstock(java.lang.Integer detailsstock){
		this.detailsstock	= detailsstock;
	}
	public java.lang.Double getDetailsprice(){
		return this.detailsprice;
	}
	public void setDetailsprice(java.lang.Double detailsprice){
		this.detailsprice	= detailsprice;
	}
	public java.lang.String getDetailsdrawing(){
		return this.detailsdrawing;
	}
	public void setDetailsdrawing(java.lang.String detailsdrawing){
		this.detailsdrawing	= detailsdrawing;
	}
	public java.lang.Integer getDetailsdot(){
		return this.detailsdot;
	}
	public void setDetailsdot(java.lang.Integer detailsdot){
		this.detailsdot	= detailsdot;
	}
	public java.lang.Integer getDetailssale(){
		return this.detailssale;
	}
	public void setDetailssale(java.lang.Integer detailssale){
		this.detailssale	= detailssale;
	}

	public java.lang.String getColor() {
		return color;
	}
	public void setColor(java.lang.String color) {
		this.color = color;
	}
	public java.lang.String getSize() {
		return size;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}
	public java.lang.String getPai() {
		return pai;
	}
	public void setPai(java.lang.String pai) {
		this.pai = pai;
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
	public java.lang.String getTest6(){
		return this.test6;
	}
	public void setTest6(java.lang.String test6){
		this.test6	= test6;
	}
	@Override
	public String toString() {
		return "Details [detailsid=" + detailsid + ", detailsstock="
				+ detailsstock + ", detailsprice=" + detailsprice
				+ ", detailsdrawing=" + detailsdrawing + ", detailsdot="
				+ detailsdot + ", detailssale=" + detailssale + ", color="
				+ color + ", size=" + size + ", pai=" + pai + ", test4="
				+ test4 + ", test5=" + test5 + ", test6=" + test6 + "]";
	}
	
	
	
	
	
	
}