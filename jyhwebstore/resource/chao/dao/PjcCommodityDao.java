package chao.dao;

import java.util.List;

import pojo.Commodity;
import dao.CommodityDao;

public interface PjcCommodityDao extends CommodityDao {
	public List<Commodity> getIndexfifproduct() throws Exception; 
	
}
