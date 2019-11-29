package dao;

import java.sql.Connection;

import pojo.AddTab;

public interface AddTabDao {
	boolean insertAdd(Connection conn, AddTab addtab)throws Exception;//添加地址
	boolean deleteAdd(Connection conn ,String aid)throws Exception; //删除收货地址
	public AddTab getAddByAid(String aid,Connection conn) throws Exception;//通过Aid查询地址表中的地址
	boolean modifyAdd(AddTab addtab,Connection conn) throws Exception;
}
