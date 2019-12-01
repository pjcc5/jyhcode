package tan.dto;

import java.util.Date;

import util.DateFromat;

public class Cart {
private Date date;

private String shopid;
private	String comname;
private	String compic;
private	int comprice;
private	int count;
private	String size;
private	String color;
private String uuid;
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	    
	this.date = date; 
}
public String getShopid() {
	return shopid;
}
public void setShopid(String shopid) {
	this.shopid = shopid;
}
public String getComname() {
	return comname;
}
public void setComname(String comname) {
	this.comname = comname;
}
public String getCompic() {
	return compic;
}
public void setCompic(String compic) {
	this.compic = compic;
}
public int getComprice() {
	return comprice;
}
public void setComprice(int comprice) {
	this.comprice = comprice;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
@Override
public String toString(){
	return "Cart [comname=" + comname + ", compic=" + compic + ", comprice="
			+ comprice + ", count=" + count + ", size=" + size + ", color="
			+ color + "]";
}
}
