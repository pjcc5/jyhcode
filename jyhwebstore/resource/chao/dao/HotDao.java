package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Hot;

public interface HotDao {

	public List<Hot> getAllHot(Connection conn);//获得所有的
	public Hot getHotById(String hotcom,Connection conn);//通过获得一个账户
	public boolean insertHot(Hot hot,Connection conn);//插入账户号的方法
	public boolean deleteHotByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyHot(Hot hot,Connection conn);//修改账号的方法
	
	
}
