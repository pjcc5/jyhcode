package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Classes;
import pojo.Commodity;

public interface CommodityDao {
	public List<Commodity> getAllCommodity(Connection conn) throws Exception;//获得所有的
	public Commodity getCommodityById(String comid,Connection conn) throws Exception;//通过comid获得一个账户
	public boolean insertCommodity(Commodity commodity,Connection conn)throws Exception;//插入账户号的方法
	public boolean deleteCommodityByid(String comid,Connection conn)throws Exception;//删除账号的方法
	public boolean modifyCommodity(Commodity commodity,Connection conn)throws Exception;//修改账号的方法
	
	
	
	
}
