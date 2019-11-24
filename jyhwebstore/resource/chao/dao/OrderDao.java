package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Order;

public interface OrderDao {
	
	public List<Order> getAllOrder(Connection conn);//获得所有的订单项
	public Order getOrderById(String aid,Connection conn);//通过aid获得一个订单项
	public boolean insertOrder(Order order,Connection conn);//插入订单项的方法
	public boolean deleteOrderByid(String aid,Connection conn);//删除订单项的方法
	public boolean modifyOrder(Order order,Connection conn);//修改订单项的方法
	

}
