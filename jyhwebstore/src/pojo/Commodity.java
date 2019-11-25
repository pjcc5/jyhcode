package pojo;

import java.io.Serializable;

public class Commodity  implements Serializable{
	private java.lang.String comid;//comid
	private java.lang.String comname;//comname
	private java.lang.String compic;//compic
	private java.lang.Integer comdetails;//comdetails
	private java.lang.Double comprice;//comprice
	private java.lang.String comclass;//comclass
	private java.lang.String color;//test1
	private java.lang.String pai;//test2
	private java.lang.String size;//test3
	private java.lang.String test4;//test4
	public java.lang.String getComid() {
		return comid;
	}
	public void setComid(java.lang.String comid) {
		this.comid = comid;
	}
	public java.lang.String getComname() {
		return comname;
	}
	public void setComname(java.lang.String comname) {
		this.comname = comname;
	}
	public java.lang.String getCompic() {
		return compic;
	}
	public void setCompic(java.lang.String compic) {
		this.compic = compic;
	}
	public java.lang.Integer getComdetails() {
		return comdetails;
	}
	public void setComdetails(java.lang.Integer comdetails) {
		this.comdetails = comdetails;
	}
	public java.lang.Double getComprice() {
		return comprice;
	}
	public void setComprice(java.lang.Double comprice) {
		this.comprice = comprice;
	}
	public java.lang.String getComclass() {
		return comclass;
	}
	public void setComclass(java.lang.String comclass) {
		this.comclass = comclass;
	}
	public java.lang.String getColor() {
		return color;
	}
	public void setColor(java.lang.String color) {
		this.color = color;
	}
	public java.lang.String getPai() {
		return pai;
	}
	public void setPai(java.lang.String pai) {
		this.pai = pai;
	}
	public java.lang.String getSize() {
		return size;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}
	public java.lang.String getTest4() {
		return test4;
	}
	public void setTest4(java.lang.String test4) {
		this.test4 = test4;
	}
	@Override
	public String toString() {
		return "Commodity [comid=" + comid + ", comname=" + comname
				+ ", compic=" + compic + ", comdetails=" + comdetails
				+ ", comprice=" + comprice + ", comclass=" + comclass
				+ ", color=" + color + ", pai=" + pai + ", size=" + size
				+ ", test4=" + test4 + "]";
	}
	
	
	
	
}