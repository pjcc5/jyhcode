package pojo;

import java.io.Serializable;

public class Shopmiddle implements Serializable{
	private String ais;
	private int shopid;
	public String getAis() {
		return ais;
	}
	public void setAis(String ais) {
		this.ais = ais;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	@Override
	public String toString() {
		return "Shopmiddle [ais=" + ais + ", shopid=" + shopid + "]";
	}
	

}
