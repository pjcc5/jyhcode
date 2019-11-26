package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Hot;

public interface HotDao {

	public List<Hot> getAllHot(Connection conn)throws Exception;//获得所有的
	public Hot getHotById(int hotcom,Connection conn)throws Exception;//通过获得一个账户
	public boolean insertHot(Hot hot,Connection conn) throws Exception;//插入账户号的方法
	public boolean deleteHotByid(int aid,Connection conn)throws Exception;//删除账号的方法
	public boolean modifyHot(Hot hot,Connection conn) throws Exception;//修改账号的方法
	
	
}
