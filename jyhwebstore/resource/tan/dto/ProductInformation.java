package tan.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductInformation {
	List<String> color;
	List<String> picurl;
	List<String> size;
	String comid;
	String comname;
	int comprice;
	String pai;

	int detailsdot;
	int detailssale;
	public List<String> getColor() {
		return color;
	}
	@Override
	public String toString() {
		return "ProductInformation [color=" + color + ", picurl=" + picurl
				+ ", comid=" + comid + ", comname=" + comname + ", comprice="
				+ comprice + ", pai=" + pai + ", size=" + size
				+ ", detailsdot=" + detailsdot + ", detailssale=" + detailssale
				+ "]";
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public List<String> getPicurl() {
		return picurl;
	}
	public void setPicurl(List<String> picurl) {
		this.picurl = picurl;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public int getComprice() {
		return comprice;
	}
	public void setComprice(int comprice) {
		this.comprice = comprice;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public List<String> getSize() {
		return size;
	}
	public void setSize(List<String> size) {
		this.size = size;
	}
	public int getDetailsdot() {
		return detailsdot;
	}
	public void setDetailsdot(int detailsdot) {
		this.detailsdot = detailsdot;
	}
	public int getDetailssale() {
		return detailssale;
	}
	public void setDetailssale(int detailssale) {
		this.detailssale = detailssale;
	}
	
	
	
	
	
	
	

}
