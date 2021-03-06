package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Commodity;
import dao.CommodityDao;
import db.DbHelp2;

//github.com/pjcc5/jyhcode.git
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl implements CommodityDao{
/**
 * 商品表操作
 */
	@Override
	public List<Commodity> getAllCommodity(Connection conn) throws Exception{
		
		if(conn==null){
			return null;
		}
		
		List<Commodity> list=new ArrayList<>();
		
			if(!conn.isClosed()){
				String sql="select * from commodity";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Commodity commodity=new Commodity();
			commodity.setComid(rs.getString("comid"));
			commodity.setComname(rs.getString("comname"));
			commodity.setCompic(rs.getString("compic"));
			commodity.setComdetails(rs.getInt("comdetails"));
			commodity.setComprice(rs.getDouble("comprice"));
			commodity.setComclass(rs.getString("comclass"));

			commodity.setColor(rs.getString("color"));
			commodity.setPai(rs.getString("pai"));
			commodity.setSize(rs.getString("size"));

			
			commodity.setTest4(rs.getString("test4"));
			list.add(commodity);
			}
				
			}
		
		
		return list;
	}

	@Override
	public Commodity getCommodityById(String comid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		
		if(conn==null){
			return null;
		}
		
	
	
			if(!conn.isClosed()){
				String sql="select * from commodity where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, comid);
			ResultSet rs=ps.executeQuery();
			Commodity commodity=new Commodity();
			if(rs.next()){
			
			commodity.setComid(rs.getString("comid"));
			commodity.setComname(rs.getString("comname"));
			commodity.setCompic(rs.getString("compic"));
			commodity.setComdetails(rs.getInt("comdetails"));
			commodity.setComprice(rs.getDouble("comprice"));
			commodity.setComclass(rs.getString("comclass"));

			commodity.setColor(rs.getString("color"));
			commodity.setPai(rs.getString("pai"));
			commodity.setSize(rs.getString("size"));

			
			commodity.setTest4(rs.getString("test4"));
			
			}
				return commodity;
			}
		
		return null;
	}
	
	@Override
	public boolean insertCommodity(Commodity commodity, Connection conn)throws Exception {
		
		if(conn==null){
			return false;
		}
		
	
	
			if(!conn.isClosed()){
				String sql = "insert into commodity values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, commodity.getComid());
				ps.setString(2, commodity.getComname());
				ps.setString(3, commodity.getCompic());
				ps.setInt(4, commodity.getComdetails());
				ps.setDouble(5, commodity.getComprice());
				ps.setString(6, commodity.getComclass());

				ps.setString(7, commodity.getColor());
				ps.setString(8, commodity.getPai());
				ps.setString(9, commodity.getSize());

				
				ps.setString(10, commodity.getTest4());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
			}
	
		return false;
	}
	
	@Override
	public boolean deleteCommodityByid(String comid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}

			if(!conn.isClosed()){
				String sql = "delete from commodity where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, comid);
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
			}
		
		return false;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		
	
	
			if(!conn.isClosed()){
				String sql = "update commodity set comname=?,compic=?,comdetails=?,"
						+"comprice=?,comclass=?,color=?,pai=?,size=?,test4=? where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);

//			
				ps.setString(1, commodity.getComname());
				ps.setString(2, commodity.getCompic());
				ps.setInt(3, commodity.getComdetails());
				ps.setDouble(4, commodity.getComprice());
				ps.setString(5, commodity.getComclass());
				ps.setString(6, commodity.getColor());
				ps.setString(7, commodity.getPai());
				ps.setString(8, commodity.getSize());
				ps.setString(9, commodity.getTest4());
				ps.setString(10, commodity.getComid());

			
				
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
			}
	
		return false;
	}

}
