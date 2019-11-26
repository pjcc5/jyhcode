package chao.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import pojo.Commodity;
import pojo.Details;
import chao.dao.PjcCommodityDao;
import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import db.DbHelp2;

public class PjCommodityDaoImpl extends CommodityDaoImpl implements PjcCommodityDao{

	@Override
	public List<Commodity> getIndexfifproduct(List<Details> details50) {
		List<Commodity> comms =new ArrayList<Commodity>();
		Connection conn =DbHelp2.getConnection();
		CommodityDao commd = new CommodityDaoImpl();
		for (Details details : details50) {
			comms.add(commd.getCommodityById(details.getDetailsid(), conn));
			
		}
		return null;
	}
	

}
