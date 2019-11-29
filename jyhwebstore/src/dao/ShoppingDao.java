package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Shopping;

public interface ShoppingDao {
	public List<Shopping> getAllAcount(Connection conn)throws Exception;//获得所有的账号
	public Shopping getShopingById(String aid,Connection conn)throws Exception;//通过aid获得一个账户
	public boolean insertShoping(Shopping shoping,Connection conn)throws Exception;//插入账户号的方法
	public boolean deleteShopingtByid(String aid,Connection conn)throws Exception;//删除账号的方法
	public boolean modifyShoping(Shopping shoping,Connection conn)throws Exception;//修改账号的方法

}
