package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Acount;

public interface CompicDao {
	
	public List<Acount> getAllAcount(Connection conn);//获得所有的账号
	public Acount getAcountById(String aid,Connection conn);//通过aid获得一个账户
	public boolean insertAcount(Acount acount,Connection conn);//插入账户号的方法
	public boolean deleteAcountByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyAcount(Acount acount,Connection conn);//修改账号的方法
	
	
}
