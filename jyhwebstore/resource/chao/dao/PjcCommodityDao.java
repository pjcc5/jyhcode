package chao.dao;

import java.util.List;

import pojo.Commodity;
import pojo.Details;
import dao.CommodityDao;

public interface PjcCommodityDao extends CommodityDao {
	public List<Commodity> getIndexfifproduct(List<Details> details50) throws Exception; 
	
}
