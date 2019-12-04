package dto;

public class OrderDetailDto {
	private java.lang.String comid;//商品id
	private java.lang.String comname;//商品名称
	private java.lang.String compic;//商品图片
	private java.lang.Double comprice;//商品单价
	private java.lang.String color;//商品颜色
	private java.lang.String size;//商品尺寸
	private java.lang.Integer detailsdot;//点击量
	private java.lang.String pai;//品牌
	private java.lang.Integer comcount;//商品库存
	private java.lang.Integer comnum;//商品个数
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
	public java.lang.Double getComprice() {
		return comprice;
	}
	public void setComprice(java.lang.Double comprice) {
		this.comprice = comprice;
	}
	public java.lang.Integer getDetailsdot() {
		return detailsdot;
	}
	public void setDetailsdot(java.lang.Integer detailsdot) {
		this.detailsdot = detailsdot;
	}
	public java.lang.String getPai() {
		return pai;
	}
	public void setPai(java.lang.String pai) {
		this.pai = pai;
	}
	public java.lang.Integer getComcount() {
		return comcount;
	}
	public void setComcount(java.lang.Integer comcount) {
		this.comcount = comcount;
	}
	
	public java.lang.String getColor() {
		return color;
	}
	public void setColor(java.lang.String color) {
		this.color = color;
	}
	
	public java.lang.String getSize() {
		return size;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}
	
	public java.lang.Integer getComnum() {
		return comnum;
	}
	public void setComnum(java.lang.Integer comnum) {
		this.comnum = comnum;
	}
	@Override
	public String toString() {
		return "OrderDetailDto [comid=" + comid + ", comname=" + comname
				+ ", compic=" + compic + ", comprice=" + comprice + ", color="
				+ color + ", size=" + size + ", detailsdot=" + detailsdot
				+ ", pai=" + pai + ", comcount=" + comcount + ", comnum="
				+ comnum + "]";
	}
	
		
}
