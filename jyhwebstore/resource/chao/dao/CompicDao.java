package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Compic;
import pojo.Compic;

public interface CompicDao {
	
	public List<Compic> getAllCompic(Connection conn)throws Exception;//获得所有的连接表项
	public Compic getCompicById(String comid,Connection conn)throws Exception;//通过comid获得一个连接项
	public boolean insertCompic(Compic compic,Connection conn)throws Exception;//插入账户号的方法
	public boolean deleteCompicByid(String aid,Connection conn)throws Exception;//删除账号的方法
	public boolean modifyCompic(Compic compic,Connection conn)throws Exception;//修改账号的方法
	
	
}
