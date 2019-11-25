package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Size;

public interface SizeDao {
	
	public List<Size> getAllSize(Connection conn);//获得所有的尺寸
	public Size getShopingById(int comid,Connection conn);//通过comid获得一个尺寸
	public boolean insertSize(Size size,Connection conn);//插入尺寸的方法
	public boolean deleteSizetByid(int comid,Connection conn);//删除尺寸的方法
	public boolean modifySize(Size size,Connection conn);//修改尺寸的方法

	
}
