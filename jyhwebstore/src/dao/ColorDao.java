package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Color;

public interface ColorDao {
	

	public List<Color> getAllcolor(Connection conn) throws Exception;//获得所有的颜色
	public Color getColorById(String comid,Connection conn) throws Exception;//通过获得一个颜色
	public boolean insertColor(Color color,Connection conn) throws Exception;//插入颜色的方法
	public boolean deleteColorByid(String comid,Connection conn)throws Exception ;//删除颜色的方法
	public boolean modifyColor(Color color,Connection conn)throws Exception;//修改颜色的方法
	

	
}
