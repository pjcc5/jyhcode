package dao.impl;

import java.sql.Connection;
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
					shopping.setShopid(rs.getString("shopid"));
					shopping.setColor(rs.getString("color"));
					shopping.setComname(rs.getString("comname"));
					shopping.setCompic(rs.getString("compic"));
					shopping.setComprice(rs.getString("comprice"));
					shopping.setCount(rs.getString("count"));
					shopping.setDate(rs.getString("date"));
					shopping.setSize(rs.getString("size"));
					shopping.setUuid(rs.getString("uuid"));
					shopping.setSelected(rs.getString("selected"));
				   list.add(shopping);
				}
				return list;
			}
		
		return null;
	}

	@Override
	public Shopping getShopingById(String aid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		
			if(!conn.isClosed()){
				String sql="select * from shopping where shopid=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, aid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					Shopping shopping=new Shopping();
					shopping.setShopid(rs.getString("shopid"));
					shopping.setColor(rs.getString("color"));
					shopping.setComname(rs.getString("comname"));
					shopping.setCompic(rs.getString("compic"));
					shopping.setComprice(rs.getString("comprice"));
					shopping.setCount(rs.getString("count"));
					shopping.setDate(rs.getString("date"));
					shopping.setSize(rs.getString("size"));
					shopping.setUuid(rs.getString("uuid"));
					shopping.setSelected(rs.getString("selected"));
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
				String sql="insert into shopping values(?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, shoping.getShopid());
				ps.setString(2, shoping.getCompic());
				ps.setString(3, shoping.getCount());
				ps.setString(4, shoping.getDate());
				ps.setString(5, shoping.getComprice());
				ps.setString(6, shoping.getSize());
				ps.setString(7, shoping.getColor());
				ps.setString(8, shoping.getComname());
				ps.setString(9, shoping.getUuid());
				ps.setString(10,shoping.getSelected());
			    int rs=ps.executeUpdate();
			    if(rs>0){
			    	return true;
			    }
			}
		
		return false;
	}

	@Override
	public boolean deleteShopingtByid(String aid, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}

			String sql="delete from shopping where shopid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			
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
				String sql="update shopping set compic=?,count=?,datees=?,comprice=?,size=?,color=?,comname=?,uuid=?,selected=? where shopid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, shoping.getCompic());
				ps.setString(2, shoping.getCount());
				ps.setString(3, shoping.getDate());
				ps.setString(4, shoping.getComprice());
				ps.setString(5, shoping.getSize());
				ps.setString(6, shoping.getColor());
				ps.setString(7, shoping.getComname());
				ps.setString(8, shoping.getUuid());
				ps.setString(9, shoping.getShopid());
				ps.setString(10, shoping.getSelected());
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
		
		return false;
	}

}
