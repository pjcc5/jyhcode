package pojo;

import java.io.Serializable;

public class Shopmiddle implements Serializable{
	private String aid;
	private String shopid;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	@Override
	public String toString() {
		return "Shopmiddle [ais=" + aid + ", shopid=" + shopid + "]";
	}
	

}
