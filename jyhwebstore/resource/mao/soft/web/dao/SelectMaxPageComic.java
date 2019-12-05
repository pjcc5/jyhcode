package mao.soft.web.dao;

import java.sql.Connection;
import java.util.List;

import mao.soft.web.dateuti.CommodityUtil;
import dao.CommodityDao;

public interface SelectMaxPageComic extends CommodityDao{
	public int selectMaxPageNo(int pageSize,Connection conn)throws Exception;
	public List<CommodityUtil> selectAllStudent(int pageNo, int pageSize,Connection conn)throws Exception;
}
