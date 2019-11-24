package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Shopmiddle;
import chao.dao.ShopmiddleDao;

public class ShopmiddleDaoImpl implements ShopmiddleDao{

	@Override
	public List<Shopmiddle> getAllShopmiddle(Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
			if(!conn.isClosed()){
			String sql="select * from shopmiddle";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			List<Shopmiddle> list= new ArrayList<Shopmiddle>();
			while(rs.next()){
				Shopmiddle shopmiddle=new Shopmiddle();
				shopmiddle.setAis(rs.getString("ais"));
				shopmiddle.setShopid(rs.getInt("shopid"));
				list.add(shopmiddle);
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
	public Shopmiddle getSById(String aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
			if(!conn.isClosed()){
			String sql="select * from shopmiddle where ais=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()){
				Shopmiddle shopmiddle=new Shopmiddle();
				shopmiddle.setAis(rs.getString("ais"));
				shopmiddle.setShopid(rs.getInt("shopid"));
				return shopmiddle;
			}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertShopmiddle(Shopmiddle shopmiddle, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteShopmiddleByid(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyShopmiddle(Shopmiddle shopmiddle, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
