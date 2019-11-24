package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Details;
import pojo.Order;
import chao.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> getAllOrder(Connection conn) {
		if(conn==null)
		{
			return null;
			
		}
		List<Order> list=new ArrayList<Order>();
		try {
			if(!conn.isClosed())
			{
				String sql ="select * from order";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Order order =new Order();
					order.setAid(rs.getInt("aid"));
					order.setComid(rs.getString("comid"));
					order.setComname(rs.getString("comname"));
					order.setOrderadd(rs.getString("orderadd"));
					order.setOrdername(rs.getString("ordername"));
					order.setOrderphone(rs.getString("orderphone"));
					order.setOrderprice(rs.getDouble("orderprice"));
					order.setOrderdate(rs.getDate("orderdate"));
					order.setOrderstatement(rs.getInt("orderstatement"));
					order.setOrderpay(rs.getInt("orderpay"));
					order.setOrderreturn(rs.getInt("orderreturn"));
					order.setOrderid(rs.getString("orderid"));
					order.setOrdercompany(rs.getString("ordercompany"));
					order.setTest1(rs.getString("test1"));
					order.setTest2(rs.getString("test2"));
					order.setTest3(rs.getString("test3"));
					list.add(order);
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Order getOrderById(String aid, Connection conn) {
		if(conn == null)
		{
			return null;
		}
		try {
			if(!conn.isClosed()){
			String sql="select * from order where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Order o =new Order();
			o.setAid(rs.getInt("aid"));
			o.setComid(rs.getString("comid"));
			o.setComname(rs.getString("comname"));
			o.setOrderadd(rs.getString("orderadd"));
			o.setOrdername(rs.getString("ordername"));
			o.setOrderphone(rs.getString("orderphone"));
			o.setOrderprice(rs.getDouble("orderprice"));
			o.setOrderdate(rs.getDate("orderdate"));
			o.setOrderstatement(rs.getInt("orderstatement"));
			o.setOrderpay(rs.getInt("orderpay"));
			o.setOrderreturn(rs.getInt("orderreturn"));
			o.setOrderid(rs.getString("orderid"));
			o.setOrdercompany(rs.getString("ordercompany"));
			o.setTest1(rs.getString("test1"));
			o.setTest2(rs.getString("test2"));
			o.setTest3(rs.getString("test3"));
			o.setTest4(rs.getString("test4"));
			
			return o;
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertOrder(Order order, Connection conn) {
		
		return false;
	}

	@Override
	public boolean deleteOrderByid(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyOrder(Order order, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
