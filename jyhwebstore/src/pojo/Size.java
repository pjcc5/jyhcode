package pojo;

import java.io.Serializable;

public class Size implements Serializable{
	private String comid;
	private String size1;
	private String size2;
	private String size3;
	private String size4;
	private String size5;
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getSize1() {
		return size1;
	}
	public void setSize1(String size1) {
		this.size1 = size1;
	}
	public String getSize2() {
		return size2;
	}
	public void setSize2(String size2) {
		this.size2 = size2;
	}
	public String getSize3() {
		return size3;
	}
	public void setSize3(String size3) {
		this.size3 = size3;
	}
	public String getSize4() {
		return size4;
	}
	public void setSize4(String size4) {
		this.size4 = size4;
	}
	public String getSize5() {
		return size5;
	}
	public void setSize5(String size5) {
		this.size5 = size5;
	}
	@Override
	public String toString() {
		return "Size [comid=" + comid + ", size1=" + size1 + ", size2=" + size2
				+ ", size3=" + size3 + ", size4=" + size4 + ", size5=" + size5
				+ "]";
	}
	
	
	
	
	
	
}
