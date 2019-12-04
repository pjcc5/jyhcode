package pojo;

import java.io.Serializable;
import java.util.Date;



public class Shopping  implements Serializable{
	private java.lang.String shopid;//aid
	private java.lang.String compic;//comid
	private java.lang.String count;//count
	private String date;//date
	private java.lang.String comprice;//test1
	private java.lang.String size;//test2
	private java.lang.String color;//test3
	private java.lang.String comname;//test4
	private String uuid;
	private String selected="";
	private String comid="";
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public java.lang.String getShopid() {
		return shopid;
	}
	public void setShopid(java.lang.String shopid) {
		this.shopid = shopid;
	}
	public java.lang.String getCompic() {
		return compic;
	}
	public void setCompic(java.lang.String compic) {
		this.compic = compic;
	}
	public java.lang.String getCount() {
		return count;
	}
	public void setCount(java.lang.String count) {
		this.count = count;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public java.lang.String getComprice() {
		return comprice;
	}
	public void setComprice(java.lang.String comprice) {
		this.comprice = comprice;
	}
	public java.lang.String getSize() {
		return size;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}
	public java.lang.String getColor() {
		return color;
	}
	public void setColor(java.lang.String color) {
		this.color = color;
	}
	public java.lang.String getComname() {
		return comname;
	}
	public void setComname(java.lang.String comname) {
		this.comname = comname;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	
	@Override
	public String toString() {
		return "Shopping [shopid=" + shopid + ", compic=" + compic + ", count="
				+ count + ", date=" + date + ", comprice=" + comprice
				+ ", size=" + size + ", color=" + color + ", comname="
				+ comname + ", uuid=" + uuid + ", selected=" + selected
				+ ", comid=" + comid + "]";
	}
	
	
	
	
	
	
	
}