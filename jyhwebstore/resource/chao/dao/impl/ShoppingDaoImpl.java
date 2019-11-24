package chao.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Shopping;
import chao.dao.ShoppingDao;

public class ShoppingDaoImpl implements ShoppingDao{

	@Override
	public List<Shopping> getAllAcount(Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
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
					shopping.setDate(rs.getDate("date"));
					shopping.setTest1(rs.getString("test1"));
					shopping.setTest2(rs.getString("test2"));
					shopping.setTest3(rs.getString("test3"));
					shopping.setTest4(rs.getString("test4"));
				   list.add(shopping);
				}
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Shopping getShopingById(int aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
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
					shopping.setDate(rs.getDate("date"));
					shopping.setTest1(rs.getString("test1"));
					shopping.setTest2(rs.getString("test2"));
					shopping.setTest3(rs.getString("test3"));
					shopping.setTest4(rs.getString("test4"));
				   return shopping;
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertShoping(Shopping shoping, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="insert into shopping values(?,?,?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, shoping.getShopid());
				ps.setString(2, shoping.getComid());
				ps.setInt(3, shoping.getCount());
				ps.setDate(4, new Date(shoping.getDate().getTime()));
			    ps.setString(5, shoping.getTest1());
			    ps.setString(6, shoping.getTest2());
			    ps.setString(7, shoping.getTest3());
			    ps.setString(8, shoping.getTest4());
			    int rs=ps.executeUpdate();
			    if(rs>0){
			    	return true;
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteShopingtByid(int aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			String sql="delete from shopping where shopid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, aid);
			 int rs=ps.executeUpdate();
			 if(rs>0){
				 return true;
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean modifyShoping(Shopping shoping, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="update shopping set comid=?,count=?,date=?,test1=?,test2=?,test3=?,test4=? where shopid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, shoping.getComid());
				ps.setInt(2, shoping.getCount());
				ps.setDate(3, new Date(shoping.getDate().getTime()));
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
