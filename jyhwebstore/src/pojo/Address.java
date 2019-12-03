package pojo;

import java.io.Serializable;

public class Address implements Serializable{
	private String addressid;
	private String aid;
	private int isdefault;
	private String province;
	private String town;
	private String county;
	private String addressdetail;
	private String recivename;
	private String recivephone;
	private String proval;
	private String townval;
	private String countyval;
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	private String test3;
	public String getProval() {
		return proval;
	}
	public void setProval(String proval) {
		this.proval = proval;
	}
	public String getTownval() {
		return townval;
	}
	public void setTownval(String townval) {
		this.townval = townval;
	}
	public String getCountyval() {
		return countyval;
	}
	public void setCountyval(String countyval) {
		this.countyval = countyval;
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
				+ ", recivephone=" + recivephone + ", proval=" + proval
				+ ", townval=" + townval + ", countyval=" + countyval
				+ ", test3=" + test3 + "]";
	}
	
	
}
