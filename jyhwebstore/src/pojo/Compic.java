package pojo;

import java.io.Serializable;

public class Compic implements Serializable{
	private String comid;
	private String picurl1;
	private String picurl2;
	private String picurl3;
	private String picurl4;
	private String picurl5;
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getPicurl1() {
		return picurl1;
	}
	public void setPicurl1(String picurl1) {
		this.picurl1 = picurl1;
	}
	public String getPicurl2() {
		return picurl2;
	}
	public void setPicurl2(String picurl2) {
		this.picurl2 = picurl2;
	}
	public String getPicurl3() {
		return picurl3;
	}
	public void setPicurl3(String picurl3) {
		this.picurl3 = picurl3;
	}
	public String getPicurl4() {
		return picurl4;
	}
	public void setPicurl4(String picurl4) {
		this.picurl4 = picurl4;
	}
	public String getPicurl5() {
		return picurl5;
	}
	public void setPicurl5(String picurl5) {
		this.picurl5 = picurl5;
	}
	@Override
	public String toString() {
		return "Compic [comid=" + comid + ", picurl1=" + picurl1 + ", picurl2="
				+ picurl2 + ", picurl3=" + picurl3 + ", picurl4=" + picurl4
				+ ", picurl5=" + picurl5 + "]";
	}
	
	
	
	
}
