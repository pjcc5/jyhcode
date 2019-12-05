package dao;

import java.sql.Connection;
import java.util.List;

import dto.OrderDetailDto;
import pojo.Orderform;

public interface OrderformDao {
	

	public List<Orderform> getAllOrderform(Connection conn)throws Exception;//获得所有的订单项
	public Orderform getOrderformById(String aid,Connection conn)throws Exception;//通过aid获得一个订单项
	public boolean insertOrderform(Orderform order,Connection conn)throws Exception;//插入订单项的方法
	public boolean deleteOrderformByid(String aid,Connection conn)throws Exception;//删除订单项的方法
	public boolean modifyOrderform(Orderform order,Connection conn)throws Exception;//修改订单项的方法
	public List<OrderDetailDto> getComidsByOrderId(String orderid,Connection conn) throws Exception;
	public boolean modifyOrderformState(String orderid,int orderstatement,int orderpay,Connection conn)throws Exception;//修改订单状态的方法

}
