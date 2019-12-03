package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Orderform;
import pojo.Ordermiddle;
import pojo.Shopmiddle;
import dao.OrderMiddleDao;

public class OrderMiddleDaoImpl implements OrderMiddleDao{

	@Override
	public boolean insertOrdermiddle(Ordermiddle ordermiddle, Connection conn)
			throws Exception {
		if(conn==null){
			return false;
		}
	
			if(conn.isClosed()){
				return false;
			}
			String sql="insert into ordermiddle(aid,orderid) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ordermiddle.getAid());
			ps.setString(2, ordermiddle.getOrderid());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	
	}

	@Override
	public boolean deleteOrdermiddle(String orderid, Connection conn)
			throws Exception {
		if(conn==null){
			return false;
		}
	
			if(conn.isClosed()){
				return false;
			}
			String sql="delete from ordermiddle where orderid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, orderid);
		
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	}

	@Override
	public List<Ordermiddle> getOrdermiddleByAid(String aid, Connection conn)
			throws Exception {
		if(conn==null){
			return null;
		}

			if(!conn.isClosed()){
			String sql="select * from ordermiddle where aid =?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,aid);
			ResultSet rs= ps.executeQuery();
			List<Ordermiddle> list= new ArrayList<Ordermiddle>();
			while(rs.next()){
				Ordermiddle ordermiddle=new Ordermiddle();
				ordermiddle.setAid(rs.getString("aid"));
				ordermiddle.setOrderid(rs.getString("orderid"));
				list.add(ordermiddle);
			}
			return list;
			}
		
		return null;
	}

	@Override
	public Ordermiddle getOrdermiddleByorderid(String orderid, Connection conn)
			throws Exception {
		if(conn==null){
			return null;
		}
	
			if(!conn.isClosed()){
			String sql="select * from ordermiddle where orderid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, orderid);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()){
				Ordermiddle ordermiddle=new Ordermiddle();
				ordermiddle.setAid(rs.getString("aid"));
				ordermiddle.setOrderid(rs.getString("orderid"));
				return ordermiddle;
			}
			
			}
	
		return null;
	}

	@Override
	public boolean modifyOrdermiddle(Ordermiddle ordermiddle, Connection conn)
			throws Exception {
		if(conn==null){
			return false;
		}
		
			if(conn.isClosed()){
				return false;
			}
			String sql="update shopmiddle set orderid=? where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,ordermiddle.getOrderid());
			ps.setString(2, ordermiddle.getAid());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	}
	

}
