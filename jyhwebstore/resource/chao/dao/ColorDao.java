package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Color;

public interface ColorDao {
	
	public List<Color> getAllcolor(Connection conn);//获得所有的颜色
	public Color getColorById(int comid,Connection conn);//通过获得一个颜色
	public boolean insertColor(Color color,Connection conn);//插入颜色的方法
	public boolean deleteColorByid(int comid,Connection conn);//删除颜色的方法
	public boolean modifyColor(Color color,Connection conn);//修改颜色的方法
	
}
