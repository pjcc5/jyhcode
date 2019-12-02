package pojo;

import java.io.Serializable;

public class Address implements Serializable{
	private int addressid;
	private String aid;
	private int isdefault;
	private String province;
	private String town;
	private String county;
	private String addressdetail;
	private String recivename;
	private String recivephone;
	private String test3;
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public int getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public String getTest3() {
		return test3;
	}
	public void setTest3(String test3) {
		this.test3 = test3;
	}
	public String getRecivename() {
		return recivename;
	}
	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}
	public String getRecivephone() {
		return recivephone;
	}
	public void setRecivephone(String recivephone) {
		this.recivephone = recivephone;
	}
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", aid=" + aid
				+ ", isdefault=" + isdefault + ", province=" + province
				+ ", town=" + town + ", county=" + county + ", addressdetail="
				+ addressdetail + ", recivename=" + recivename
				+ ", recivephone=" + recivephone + ", test3=" + test3 + "]";
	}
	
}
