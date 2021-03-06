package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Shopmiddle;
import dao.ShopmiddleDao;

public class ShopmiddleDaoImpl implements ShopmiddleDao{

	@Override
	public List<Shopmiddle> getAllShopmiddle(Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}

			if(!conn.isClosed()){
			String sql="select * from shopmiddle";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			List<Shopmiddle> list= new ArrayList<Shopmiddle>();
			while(rs.next()){
				Shopmiddle shopmiddle=new Shopmiddle();
				shopmiddle.setAid(rs.getString("aid"));
				shopmiddle.setShopid(rs.getString("shopid"));
				list.add(shopmiddle);
			}
			return list;
			}
		
		return null;
	}

	@Override
	public Shopmiddle getSById(String aid, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
	
			if(!conn.isClosed()){
			String sql="select * from shopmiddle where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()){
				Shopmiddle shopmiddle=new Shopmiddle();
				shopmiddle.setAid(rs.getString("aid"));
				shopmiddle.setShopid(rs.getString("shopid"));
				return shopmiddle;
			}
			
			}
	
		return null;
	}

	@Override
	public boolean insertShopmiddle(Shopmiddle shopmiddle, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(conn.isClosed()){
				return false;
			}
			String sql="insert into shopmiddle(aid,shopid) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, shopmiddle.getAid());
			ps.setString(2, shopmiddle.getShopid());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	}

	@Override
	public boolean deleteShopmiddleByid(String aid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(conn.isClosed()){
				return false;
			}
			String sql="delete from shopmiddle where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
		
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	}

	@Override
	public boolean modifyShopmiddle(Shopmiddle shopmiddle, Connection conn) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(shopmiddle);
		if(conn==null){
			return false;
		}
		
			if(conn.isClosed()){
				return false;
			}
			String sql="update shopmiddle set shopid=? where aid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,shopmiddle.getShopid());
		 ps.setString(2, shopmiddle.getAid());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
		
		return false;
	}

}
