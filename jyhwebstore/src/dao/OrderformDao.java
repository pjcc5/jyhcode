package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Orderform;

public interface OrderformDao {
	

	public List<Orderform> getAllOrderform(Connection conn)throws Exception;//获得所有的订单项
	public Orderform getOrderformById(int aid,Connection conn)throws Exception;//通过aid获得一个订单项
	public boolean insertOrderform(Orderform order,Connection conn)throws Exception;//插入订单项的方法
	public boolean deleteOrderformByid(int aid,Connection conn)throws Exception;//删除订单项的方法
	public boolean modifyOrderform(Orderform order,Connection conn)throws Exception;//修改订单项的方法

	

}
