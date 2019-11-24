package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Classes;
import pojo.Commodity;
import chao.dao.CommodityDao;
import db.DbHelp2;

public class CommodityDaoImpl implements CommodityDao{
/**
 * 商品表操作
 */
	@Override
	public List<Commodity> getAllCommodity() {
		Connection conn= DbHelp2.getConnection();
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
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public Commodity getCommodityById(String comid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean insertCommodity(Commodity commodity, Connection conn) {
		String url = "insert into commodity(comid,comname,compic,)";
		return false;
	}
	
	@Override
	public boolean deleteCommodityByid(String comid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
