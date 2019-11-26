package dto;

import java.io.Serializable;

public class IndexGoodsDto implements Serializable{
	private java.lang.String comid;//comid
	private java.lang.String comname;//comname
	private java.lang.String compic;//compic
	private java.lang.Double comprice;//商品价格
	private java.lang.Integer detailsdot;//detailsdot点击量
	private java.lang.String pai;//品牌
	public java.lang.String getPai() {
		return pai;
	}
	public void setPai(java.lang.String pai) {
		this.pai = pai;
	}
	public java.lang.Double getComprice() {
		return comprice;
	}
	public void setComprice(java.lang.Double comprice) {
		this.comprice = comprice;
	}
	public java.lang.String getComid() {
		return comid;
	}
	public void setComid(java.lang.String comid) {
		this.comid = comid;
	}
	public java.lang.String getComname() {
		return comname;
	}
	public void setComname(java.lang.String comname) {
		this.comname = comname;
	}
	public java.lang.String getCompic() {
		return compic;
	}
	public void setCompic(java.lang.String compic) {
		this.compic = compic;
	}
	public java.lang.Integer getDetailsdot() {
		return detailsdot;
	}
	public void setDetailsdot(java.lang.Integer detailsdot) {
		this.detailsdot = detailsdot;
	}
	@Override
	public String toString() {
		return "IndexGoodsDto [comid=" + comid + ", comname=" + comname
				+ ", compic=" + compic + ", comprice=" + comprice
				+ ", detailsdot=" + detailsdot + ", pai=" + pai + "]";
	}
	
	
	
	
	
	
}
