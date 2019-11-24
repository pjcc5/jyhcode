package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Commodity;
import chao.dao.CommodityDao;
import db.DbHelp2;
//github.com/pjcc5/jyhcode.git
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl implements CommodityDao{
/**
 * 商品表操作
 */
	@Override
	public List<Commodity> getAllCommodity(Connection conn) {
		
		if(conn==null){
			return null;
		}
		
		List<Commodity> list=new ArrayList<>();
		try {
			if(!conn.isClosed()){
				String sql="select * from commodity";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Commodity commodity=new Commodity();
			commodity.setComid(rs.getString("comid"));
			commodity.setComname(rs.getString("comname"));
			commodity.setCompic(rs.getString("compic"));
			commodity.setComdetails(rs.getString("comdetails"));
			commodity.setComprice(rs.getDouble("comprice"));
			commodity.setComclass(rs.getInt("comclass"));
			commodity.setTest1(rs.getString("test1"));
			commodity.setTest2(rs.getString("test2"));
			commodity.setTest3(rs.getString("test3"));
			commodity.setTest4(rs.getString("test4"));
			list.add(commodity);
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Commodity getCommodityById(String comid, Connection conn) {
		// TODO Auto-generated method stub
		
		if(conn==null){
			return null;
		}
		
	
		try {
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
			commodity.setComdetails(rs.getString("comdetails"));
			commodity.setComprice(rs.getDouble("comprice"));
			commodity.setComclass(rs.getInt("comclass"));
			commodity.setTest1(rs.getString("test1"));
			commodity.setTest2(rs.getString("test2"));
			commodity.setTest3(rs.getString("test3"));
			commodity.setTest4(rs.getString("test4"));
			
			}
				return commodity;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertCommodity(Commodity commodity, Connection conn) {
//<<<<<<< HEAD
//		String sql = "insert into commodity(comid,comname,compic,comdetails,comprice,comclass) value(?,?,?,?,?,?)";
//		try {
//			PreparedStatement ps =conn.prepareStatement(sql);
//			ps.setString(1, commodity.getComid());
//			ps.setString(2, commodity.getComname());
//			ps.setString(3, commodity.getCompic());
//			ps.setString(4, commodity.getComdetails());
//			ps.setDouble(5, commodity.getComprice());
//			ps.setInt(6, commodity.getComclass());
//			int result = ps.executeUpdate();
//			if(result > 0)
//			{
//				return true;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//=======
		
		if(conn==null){
			return false;
		}
		
	
		try {
			if(!conn.isClosed()){
				String sql = "insert into commodity values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, commodity.getComid());
				ps.setString(2, commodity.getComname());
				ps.setString(3, commodity.getCompic());
				ps.setString(4, commodity.getComdetails());
				ps.setDouble(5, commodity.getComprice());
				ps.setInt(6, commodity.getComclass());
				ps.setString(7, commodity.getTest1());
				ps.setString(8, commodity.getTest2());
				ps.setString(9, commodity.getTest3());
				ps.setString(10, commodity.getTest4());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
		
		return false;
	}
	
	@Override
	public boolean deleteCommodityByid(String comid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql = "delete from commodity where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, comid);
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
	public boolean modifyCommodity(Commodity commodity, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		
	
		try {
			if(!conn.isClosed()){
				String sql = "update commodity set comname=?,compic=?,comdetails=?,"
						+"comprice=?,comclass=?,test1=?,test2=?,test3=?,test4=? where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			
				ps.setString(1, commodity.getComname());
				ps.setString(2, commodity.getCompic());
				ps.setString(3, commodity.getComdetails());
				ps.setDouble(4, commodity.getComprice());
				ps.setInt(5, commodity.getComclass());
				ps.setString(6, commodity.getTest1());
				ps.setString(7, commodity.getTest2());
				ps.setString(8, commodity.getTest3());
				ps.setString(9, commodity.getTest4());
				ps.setString(10, commodity.getComid());
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
