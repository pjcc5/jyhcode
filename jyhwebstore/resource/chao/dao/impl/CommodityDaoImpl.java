package chao.dao.impl;

import java.sql.Connection;
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
