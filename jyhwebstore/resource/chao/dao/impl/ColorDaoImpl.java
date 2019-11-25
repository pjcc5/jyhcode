package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Color;
import chao.dao.ColorDao;

public class ColorDaoImpl implements ColorDao{

	@Override
	public List<Color> getAllcolor(Connection conn) {
		if(conn == null)
		{
			return null;
		}
		try {
			if(!conn.isClosed()){
				String sql="select * from Color";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				List<Color> list=new ArrayList<Color>();
				while(rs.next()){
					Color s = new Color();
					s.setComid(rs.getString("comid"));
					s.setColor1(rs.getString("color1"));
					s.setColor2(rs.getString("color2"));
					s.setColor3(rs.getString("color3"));
					s.setColor4(rs.getString("color4"));
					s.setColor5(rs.getString("color5"));
				     list.add(s);//将s插入到集合中
				}
				return list;//返回所有的color
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Color getColorById(String comid, Connection conn) {
		if(conn==null){
			return null;
		}
		try {
			if(!conn.isClosed()){
				String sql="select * from color where comid=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, comid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					Color s = new Color();
					s.setComid(rs.getString("comid"));
					s.setColor1(rs.getString("color1"));
					s.setColor2(rs.getString("color2"));
					s.setColor3(rs.getString("color3"));
					s.setColor4(rs.getString("color4"));
					s.setColor5(rs.getString("color5"));
					return s;
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertColor(Color color, Connection conn) {
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="insert into color values(?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,color.getComid());
				ps.setString(2,color.getColor1());
				ps.setString(3,color.getColor2());
				ps.setString(4,color.getColor3());
				ps.setString(5,color.getColor4());
				ps.setString(6,color.getColor5());
				
			    int rs=ps.executeUpdate();
			    if(rs > 0){
			    	return true;
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteColorByid(String comid, Connection conn) {
		if(conn==null){
			return false;
		}
		try {
			String sql="delete from color where comid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, comid);
			 int rs=ps.executeUpdate();
			 if(rs > 0){
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

	@Override
	public boolean modifyColor(Color color, Connection conn) {
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="update color set color1=?,color2=?,color3=?,color4=?,color5=? where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,color.getColor1());
				ps.setString(2,color.getColor2());
				ps.setString(3,color.getColor3());
				ps.setString(4,color.getColor4());
				ps.setString(5,color.getColor5());
				ps.setString(6, color.getComid());

				int rs=ps.executeUpdate();
				if(rs > 0){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
