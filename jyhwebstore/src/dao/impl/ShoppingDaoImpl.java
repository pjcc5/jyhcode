package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import pojo.Shopping;
import dao.ShoppingDao;

public class ShoppingDaoImpl implements ShoppingDao{

	@Override
	public List<Shopping> getAllAcount(Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		
			if(!conn.isClosed()){
				String sql="select * from shopping";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				List<Shopping> list=new ArrayList<>();
				while(rs.next()){
					Shopping shopping=new Shopping();
					shopping.setShopid(rs.getInt("shopid"));
					shopping.setComid(rs.getString("comid"));
					shopping.setCount(rs.getInt("count"));
					shopping.setDate(rs.getTimestamp("date"));
					shopping.setTest1(rs.getString("test1"));
					shopping.setTest2(rs.getString("test2"));
					shopping.setTest3(rs.getString("test3"));
					shopping.setTest4(rs.getString("test4"));
				   list.add(shopping);
				}
				return list;
			}
		
		return null;
	}

	@Override
	public Shopping getShopingById(int aid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		
			if(!conn.isClosed()){
				String sql="select * from shopping where shopid=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, aid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					Shopping shopping=new Shopping();
					shopping.setShopid(rs.getInt("shopid"));
					shopping.setComid(rs.getString("comid"));
					shopping.setCount(rs.getInt("count"));
					shopping.setDate(rs.getTimestamp("date"));
					shopping.setTest1(rs.getString("test1"));
					shopping.setTest2(rs.getString("test2"));
					shopping.setTest3(rs.getString("test3"));
					shopping.setTest4(rs.getString("test4"));
				   return shopping;
				}
			
			}
	
		return null;
	}

	@Override
	public boolean insertShoping(Shopping shoping, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}

			if(!conn.isClosed()){
				String sql="insert into shopping values(?,?,?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, shoping.getShopid());
				ps.setString(2, shoping.getComid());
				ps.setInt(3, shoping.getCount());
				ps.setTimestamp(4, new Timestamp(shoping.getDate().getTime()));
			    ps.setString(5, shoping.getTest1());
			    ps.setString(6, shoping.getTest2());
			    ps.setString(7, shoping.getTest3());
			    ps.setString(8, shoping.getTest4());
			    int rs=ps.executeUpdate();
			    if(rs>0){
			    	return true;
			    }
			}
		
		return false;
	}

	@Override
	public boolean deleteShopingtByid(int aid, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}

			String sql="delete from shopping where shopid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, aid);
			 int rs=ps.executeUpdate();
			 if(rs>0){
				 return true;
			 }
		
		return false;
	}

	@Override
	public boolean modifyShoping(Shopping shoping, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(!conn.isClosed()){
				String sql="update shopping set comid=?,count=?,datees=?,test1=?,test2=?,test3=?,test4=? where shopid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, shoping.getComid());
				ps.setInt(2, shoping.getCount());
				ps.setTimestamp(3, new Timestamp(shoping.getDate().getTime()));
				ps.setString(4, shoping.getTest1());
				ps.setString(5, shoping.getTest2());
				ps.setString(6, shoping.getTest3());
				ps.setString(7, shoping.getTest4());
				ps.setInt(8, shoping.getShopid());
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
		
		return false;
	}

}
