package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Ordermiddle;


public interface OrderMiddleDao {
	boolean insertOrdermiddle(Ordermiddle ordermiddle,Connection conn)throws Exception;//添加连接表
	boolean deleteOrdermiddle(String orderid,Connection conn)throws Exception; //删除一条信息
	public List<Ordermiddle> getOrdermiddleByAid(String aid,Connection conn) throws Exception;//通过Aid查询连接表中某个用户所有的订单
	public Ordermiddle getOrdermiddleByorderid(String orderid,Connection conn) throws Exception;//通过orderid查询一条连接信息
	boolean modifyOrdermiddle(Ordermiddle ordermiddle,Connection conn) throws Exception;
}
