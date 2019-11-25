package pojo;

import java.io.Serializable;

public class Color implements Serializable{
	private String comid;
	private String color1;
	private String color2;
	private String color3;
	private String color4;
	private String color5;
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getColor3() {
		return color3;
	}
	public void setColor3(String color3) {
		this.color3 = color3;
	}
	public String getColor4() {
		return color4;
	}
	public void setColor4(String color4) {
		this.color4 = color4;
	}
	public String getColor5() {
		return color5;
	}
	public void setColor5(String color5) {
		this.color5 = color5;
	}
	@Override
	public String toString() {
		return "Color [comid=" + comid + ", color1=" + color1 + ", color2="
				+ color2 + ", color3=" + color3 + ", color4=" + color4
				+ ", color5=" + color5 + "]";
	}
	
	
}
