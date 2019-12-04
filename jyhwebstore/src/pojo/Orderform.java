package pojo;

import java.io.Serializable;
import java.util.Date;

public class Orderform implements Serializable{
	
	private String aid;
	private String comid;
	private String comname;
	private String orderadd;
	private String ordername;
	private String orderphone;
	private double orderprice;
	private Date orderdate;
	private int orderstatement;
	private int orderpay;
	private int orderreturn;
	private String orderid;
	private String ordercompany;
	private int comcount;
	private String test2;
	private String test3;
	private String test4;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
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
	public String getOrderadd() {
		return orderadd;
	}
	public void setOrderadd(String orderadd) {
		this.orderadd = orderadd;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getOrderphone() {
		return orderphone;
	}
	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrderstatement() {
		return orderstatement;
	}
	public void setOrderstatement(int orderstatement) {
		this.orderstatement = orderstatement;
	}
	public int getOrderpay() {
		return orderpay;
	}
	public void setOrderpay(int orderpay) {
		this.orderpay = orderpay;
	}
	public int getOrderreturn() {
		return orderreturn;
	}
	public void setOrderreturn(int orderreturn) {
		this.orderreturn = orderreturn;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrdercompany() {
		return ordercompany;
	}
	public void setOrdercompany(String ordercompany) {
		this.ordercompany = ordercompany;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	public String getTest3() {
		return test3;
	}
	public void setTest3(String test3) {
		this.test3 = test3;
	}
	public String getTest4() {
		return test4;
	}
	public void setTest4(String test4) {
		this.test4 = test4;
	}
	public int getComcount() {
		return comcount;
	}
	public void setComcount(int comcount) {
		this.comcount = comcount;
	}
	@Override
	public String toString() {
		return "Orderform [aid=" + aid + ", comid=" + comid + ", comname="
				+ comname + ", orderadd=" + orderadd + ", ordername="
				+ ordername + ", orderphone=" + orderphone + ", orderprice="
				+ orderprice + ", orderdate=" + orderdate + ", orderstatement="
				+ orderstatement + ", orderpay=" + orderpay + ", orderreturn="
				+ orderreturn + ", orderid=" + orderid + ", ordercompany="
				+ ordercompany + ", comcount=" + comcount + ", test2=" + test2
				+ ", test3=" + test3 + ", test4=" + test4 + "]";
	}
	
	
	
	
	
	
}
