package dto;

import java.io.Serializable;
import java.util.List;

import pojo.Orderform;

public class OrderDto implements Serializable{
	private int orderIndex;//订单编号
	private List<Orderform> orderForms;//订单中的商品
	
	
	
	
	public int getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
	public List<Orderform> getOrderForms() {
		return orderForms;
	}
	public void setOrderForms(List<Orderform> orderForms) {
		this.orderForms = orderForms;
	}
	@Override
	public String toString() {
		return "OrderDto [orderIndex=" + orderIndex + ", orderForms="
				+ orderForms + "]";
	}
	
	
	
	
	
}
