package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Acount;
import pojo.Shopmiddle;

public interface ShopmiddleDao {
	
	public List<Shopmiddle> getAllShopmiddle(Connection conn);//获得所有的账号
	public Shopmiddle getSById(String aid,Connection conn);//通过aid获得一个账户
	public boolean insertShopmiddle(Shopmiddle shopmiddle,Connection conn);//插入账户号的方法
	public boolean deleteShopmiddleByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyShopmiddle(Shopmiddle shopmiddle,Connection conn);//修改账号的方法
	
	
}
