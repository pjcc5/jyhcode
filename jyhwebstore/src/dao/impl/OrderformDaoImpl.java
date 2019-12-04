package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import pojo.Orderform;
import dao.OrderformDao;
import dto.OrderDetailDto;

public class OrderformDaoImpl implements OrderformDao{

	@Override
	public List<Orderform> getAllOrderform(Connection conn)throws Exception 
	{	
		if(conn==null)
		{
			return null;
			
		}
		
		List<Orderform> list=new ArrayList<Orderform>();
		
			if(!conn.isClosed())
			{	
				String sql ="select * from orderform";
				PreparedStatement ps=conn.prepareStatement(sql);
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
			return list;
		
	}

	@Override
	public Orderform getOrderformById(String aid, Connection conn)throws Exception {
		if(conn == null)
		{
			return null;
		}

			if(!conn.isClosed()){
			String sql="select * from orderform where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Orderform o =new Orderform();
			o.setAid(rs.getString("aid"));
			o.setComid(rs.getString("comid"));
			o.setComname(rs.getString("comname"));
			o.setOrderadd(rs.getString("orderadd"));
			o.setOrdername(rs.getString("ordername"));
			o.setOrderphone(rs.getString("orderphone"));
			o.setOrderprice(rs.getDouble("orderprice"));
			o.setOrderdate(rs.getTimestamp("orderdate"));
			o.setOrderstatement(rs.getInt("orderstatement"));
			o.setOrderpay(rs.getInt("orderpay"));
			o.setOrderreturn(rs.getInt("orderreturn"));
			o.setOrderid(rs.getString("orderid"));
			o.setOrdercompany(rs.getString("ordercompany"));
			o.setComcount(rs.getInt("comcount"));
			o.setTest2(rs.getString("test2"));
			o.setTest3(rs.getString("test3"));
			o.setTest4(rs.getString("test4"));
			return o;
			}
				
			}
		
		return null;
	}

	@Override
	public boolean insertOrderform(Orderform order, Connection conn)throws Exception {
		if(conn == null)
		{
			return false;
		}
			if(!conn.isClosed()){
				String sql = "insert into orderform values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, order.getAid());
				ps.setString(2, order.getComid());
				ps.setString(3, order.getComname());
				ps.setString(4, order.getOrderadd());
				ps.setString(5, order.getOrdername());
				ps.setString(6, order.getOrderphone());
				ps.setDouble(7, order.getOrderprice());
				ps.setTimestamp(8, new Timestamp(order.getOrderdate().getTime()));
				ps.setInt(9, order.getOrderstatement());
				ps.setInt(10, order.getOrderpay());
				ps.setInt(11, order.getOrderreturn());
				ps.setString(12, order.getOrderid());
				ps.setString(13, order.getOrdercompany());
				ps.setInt(14, order.getComcount());
				ps.setString(15, order.getTest2());
				ps.setString(16, order.getTest3());
				ps.setString(17, order.getTest4());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			 
			}
		
		
		
		return false;
	}

	@Override
	public boolean deleteOrderformByid(String aid, Connection conn)throws Exception {
		if(conn==null){
			return false;
		}
		
			if(!conn.isClosed()){
				String sql="delete from orderform where aid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, aid);
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
		
		return false;
	}

	@Override
	public boolean modifyOrderform(Orderform order, Connection conn)throws Exception  {
		if(conn == null)
		{
			return false;
		}
		
		if(!conn.isClosed()){
				String sql = "update orderform set comid=?,comname=?,orderadd=?,ordername=?,"
						+ "orderphone=?,orderprice=?,orderdate=?,orderstatement=?,orderpay=?,orderreturn=?,"
						+ "orderid=?,ordercompany=?,test1=?,test2=?,test3=?,test4=? where aid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(17, order.getAid());
				ps.setString(1, order.getComid());
				ps.setString(2, order.getComname());
				ps.setString(3, order.getOrderadd());
				ps.setString(4, order.getOrdername());
				ps.setString(5, order.getOrderphone());
				ps.setDouble(6, order.getOrderprice());
				ps.setTimestamp(7, new Timestamp(order.getOrderdate().getTime()));
				ps.setInt(8, order.getOrderstatement());
				ps.setInt(9, order.getOrderpay());
				ps.setInt(10, order.getOrderreturn());
				ps.setString(11, order.getOrderid());
				ps.setString(12, order.getOrdercompany());
				ps.setInt(13, order.getComcount());
				ps.setString(14, order.getTest2());
				ps.setString(15, order.getTest3());
				ps.setString(16, order.getTest4());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			 
			}
		
		
		
		return false;
	}

	@Override
	public List<OrderDetailDto> getComidsByOrderId(String orderid,Connection conn) throws Exception {
			if(conn == null)
			{
				return null;
			}
			List<OrderDetailDto> list = new ArrayList<OrderDetailDto>();
			if(!conn.isClosed()){
			String sql="select commodity.comid,commodity.comname,commodity.compic,commodity.comprice,details.detailsdot,details.pai,details.detailsstock,commodity.color,commodity.size,orderform.comcount from orderform inner join commodity inner join details on orderform.comid = commodity.comid and orderform.comid = details.comid  where orderid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, orderid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				OrderDetailDto odd = new OrderDetailDto();
				odd.setComid(rs.getString("comid"));
				odd.setComname(rs.getString("comname"));
				odd.setCompic(rs.getString("compic"));
				odd.setComprice(rs.getDouble("comprice"));
				odd.setDetailsdot(rs.getInt("detailsdot"));
				odd.setPai(rs.getString("pai"));
				odd.setComcount(rs.getInt("detailsstock"));
				odd.setColor(rs.getString("color"));
				odd.setSize(rs.getString("size"));
				odd.setComcount(rs.getInt("comcount"));
				list.add(odd);
			}
			return list;
				
			}
		
		return list;
	}

}
