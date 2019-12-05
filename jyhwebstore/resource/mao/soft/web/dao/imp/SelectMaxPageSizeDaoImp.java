package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mao.soft.web.dao.SelectMaxPageComic;
import mao.soft.web.dateuti.CommodityUtil;
import pojo.Commodity;
import db.DbHelp;

public class SelectMaxPageSizeDaoImp implements SelectMaxPageComic{

	@Override
	public List<Commodity> getAllCommodity(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity getCommodityById(String comid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCommodity(Commodity commodity, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCommodityByid(String comid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int selectMaxPageNo(int pageSize,Connection conn) throws Exception{
		//定义一个变量用来记录总的条数
		int count=0;
		try {
			String sql = "select count(*) from commodity";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			DbHelp.closeConnection(conn);
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize + 1;
	}

	@Override
	//分页
	public List<CommodityUtil> selectAllStudent(int pageNo, int pageSize,Connection conn)
			throws Exception {
		List<CommodityUtil> list = new ArrayList<CommodityUtil>();
		String sql = "select comid,comname,comprice,color,pai,size from commodity limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			CommodityUtil commo = new CommodityUtil();
			commo.setComid(rs.getString("comid"));
			commo.setComname(rs.getString("comname"));
			commo.setComprice(rs.getDouble("comprice"));
			commo.setColor(rs.getString("color"));
			commo.setPai(rs.getString("pai"));
			commo.setSize(rs.getString("size"));
			list.add(commo);
		}
		return list;
	}

}
