package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Compic;
import pojo.Compic;

public interface CompicDao {
	
	public List<Compic> getAllCompic(Connection conn);//获得所有的连接表项
	public Compic getCompicById(String comid,Connection conn);//通过comid获得一个连接项
	public boolean insertCompic(Compic compic,Connection conn);//插入账户号的方法
	public boolean deleteCompicByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyCompic(Compic compic,Connection conn);//修改账号的方法
	
	
}
