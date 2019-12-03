package pojo;

import java.io.Serializable;

public class Ordermiddle implements Serializable{
	private int orderindex;
	private String aid;
	private String orderid;
	public int getOrderindex() {
		return orderindex;
	}
	public void setOrderindex(int orderindex) {
		this.orderindex = orderindex;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "Ordermiddle [orderindex=" + orderindex + ", aid=" + aid
				+ ", orderid=" + orderid + "]";
	}

}
