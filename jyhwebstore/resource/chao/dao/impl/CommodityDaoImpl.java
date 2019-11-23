package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;




import pojo.Commodity;
import chao.dao.CommodityDao;

public class CommodityDaoImpl implements CommodityDao{
/**
 * 商品表操作
 */
	@Override
	public List<Commodity> getAllCommodity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity getCommodityById(String comid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean insertCommodity(Commodity commodity, Connection conn) {
		String sql = "insert into commodity(comid,comname,compic,comdetails,comprice,comclass) value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, commodity.getComid());
			ps.setString(2, commodity.getComname());
			ps.setString(3, commodity.getCompic());
			ps.setString(4, commodity.getComdetails());
			ps.setDouble(5, commodity.getComprice());
			ps.setInt(6, commodity.getComclass());
			int result = ps.executeUpdate();
			if(result > 0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
