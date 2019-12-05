package dto;

import java.util.List;

public class InnerOrderDto {
	private Double orderprice;//整个订单的价格
	private List<OrderDetailDto> orderdetaildtos;//存放所有订单详情中商品的dto们
	public Double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}
	public List<OrderDetailDto> getOrderdetaildtos() {
		return orderdetaildtos;
	}
	public void setOrderdetaildtos(List<OrderDetailDto> orderdetaildtos) {
		this.orderdetaildtos = orderdetaildtos;
	}
	@Override
	public String toString() {
		return "InnerOrderDto [orderprice=" + orderprice + ", orderdetaildtos="
				+ orderdetaildtos + "]";
	}
	
}
