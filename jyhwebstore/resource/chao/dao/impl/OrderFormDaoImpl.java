package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Orderform;
import chao.dao.OrderFormDao;
import dao.impl.OrderformDaoImpl;

public class OrderFormDaoImpl extends OrderformDaoImpl implements OrderFormDao{

	@Override
	public List<Orderform> getAllOrderformByAid(String aid,Connection conn) {
			
			if(conn==null)
			{
				return null;
			}
			
			List<Orderform> list=new ArrayList<Orderform>();
			
				try {
					if(!conn.isClosed())
					{	
						String sql ="select * from orderform where aid=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, aid);
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							Orderform order =new Orderform();
							order.setAid(rs.getString("aid"));
							order.setComid(rs.getString("comid"));
							order.setComname(rs.getString("comname"));
							order.setOrderadd(rs.getString("orderadd"));
							order.setOrdername(rs.getString("ordername"));
							order.setOrderphone(rs.getString("orderphone"));
							order.setOrderprice(rs.getDouble("orderprice"));
							order.setOrderdate(rs.getTimestamp("orderdate"));
							order.setOrderstatement(rs.getInt("orderstatement"));
							order.setOrderpay(rs.getInt("orderpay"));
							order.setOrderreturn(rs.getInt("orderreturn"));
							order.setOrderid(rs.getString("orderid"));
							order.setOrdercompany(rs.getString("ordercompany"));
							order.setComcount(rs.getInt("comcount"));
							order.setTest2(rs.getString("test2"));
							order.setTest3(rs.getString("test3"));
							order.setTest4(rs.getString("test4"));
							list.add(order);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			
		}
	

	@Override
	public List<Orderform> getAllOrderformByOrderid(String orderid,
			Connection conn) {
		if(conn==null)
		{
			return null;
		}
		
		List<Orderform> list=new ArrayList<Orderform>();
		
			try {
				if(!conn.isClosed())
				{	
					String sql ="select * from orderform where orderid=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, orderid);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Orderform order =new Orderform();
						order.setAid(rs.getString("aid"));
						order.setComid(rs.getString("comid"));
						order.setComname(rs.getString("comname"));
						order.setOrderadd(rs.getString("orderadd"));
						order.setOrdername(rs.getString("ordername"));
						order.setOrderphone(rs.getString("orderphone"));
						order.setOrderprice(rs.getDouble("orderprice"));
						order.setOrderdate(rs.getTimestamp("orderdate"));
						order.setOrderstatement(rs.getInt("orderstatement"));
						order.setOrderpay(rs.getInt("orderpay"));
						order.setOrderreturn(rs.getInt("orderreturn"));
						order.setOrderid(rs.getString("orderid"));
						order.setOrdercompany(rs.getString("ordercompany"));
						order.setComcount(rs.getInt("comcount"));
						order.setTest2(rs.getString("test2"));
						order.setTest3(rs.getString("test3"));
						order.setTest4(rs.getString("test4"));
						list.add(order);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}
	
}
