package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Orderform;

public interface OrderDao {
	
<<<<<<< HEAD
	public List<Orderform> getAllOrder(Connection conn);//获得所有的订单项
	public Orderform getOrderById(int aid,Connection conn);//通过aid获得一个订单项
	public boolean insertOrder(Orderform order,Connection conn);//插入订单项的方法
	public boolean deleteOrderByid(int aid,Connection conn);//删除订单项的方法
	public boolean modifyOrder(Orderform order,Connection conn);//修改订单项的方法
=======
	public List<Order> getAllOrder(Connection conn)throws Exception;//获得所有的订单项
	public Order getOrderById(int aid,Connection conn)throws Exception;//通过aid获得一个订单项
	public boolean insertOrder(Order order,Connection conn)throws Exception;//插入订单项的方法
	public boolean deleteOrderByid(int aid,Connection conn)throws Exception;//删除订单项的方法
	public boolean modifyOrder(Order order,Connection conn)throws Exception;//修改订单项的方法
>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
	

}
