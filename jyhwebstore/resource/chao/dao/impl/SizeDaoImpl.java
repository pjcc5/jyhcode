package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Size;
import chao.dao.SizeDao;

public class SizeDaoImpl implements SizeDao{

	@Override
	public List<Size> getAllSize(Connection conn)throws Exception {
		if(conn == null)
		{
			return null;
		}
	
			if(!conn.isClosed()){
				String sql="select * from size";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				List<Size> list=new ArrayList<Size>();
				while(rs.next()){
					Size s = new Size();
					s.setComid(rs.getString("comid"));
					s.setSize1(rs.getString("size1"));
					s.setSize2(rs.getString("size2"));
					s.setSize3(rs.getString("size3"));
					s.setSize4(rs.getString("size4"));
					s.setSize5(rs.getString("size5"));
				   list.add(s);//将s插入到集合中
				}
				return list;//返回所有的size
			}
		
		
		
		
		return null;
	}

	@Override
	public Size getSizeById(int comid, Connection conn) throws Exception{
		if(conn==null){
			return null;
		}
	
			if(!conn.isClosed()){
				String sql="select * from size where comid=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, comid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					Size s = new Size();
					s.setComid(rs.getString("comid"));
					s.setSize1(rs.getString("size1"));
					s.setSize2(rs.getString("size2"));
					s.setSize3(rs.getString("size3"));
					s.setSize4(rs.getString("size4"));
					s.setSize5(rs.getString("size5"));
					return s;
				}
			
			}
	
		return null;
	}

	@Override
	public boolean insertSize(Size size, Connection conn)throws Exception {
		if(conn==null){
			return false;
		}
		
			if(!conn.isClosed()){
				String sql="insert into size values(?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,size.getComid());
				ps.setString(2,size.getSize1());
				ps.setString(3,size.getSize2());
				ps.setString(4,size.getSize3());
				ps.setString(5,size.getSize4());
				ps.setString(6,size.getSize5());
				
			    int rs=ps.executeUpdate();
			    if(rs > 0){
			    	return true;
			    }
			}
		
		return false;
	}

	@Override
	public boolean deleteSizetByid(int comid, Connection conn)throws Exception {
		if(conn==null){
			return false;
		}
		
			String sql="delete from size where comid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, comid);
			 int rs=ps.executeUpdate();
			 if(rs > 0){
				 return true;
			 }
		
		return false;
	}

	@Override
	public boolean modifySize(Size size, Connection conn)throws Exception {
		if(conn==null){
			return false;
		}
	
			if(!conn.isClosed()){
				String sql="update size set size1=?,size2=?,size3=?,size4=?,size5=? where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, size.getSize1());
				ps.setString(2, size.getSize2());
				ps.setString(3, size.getSize3());
				ps.setString(4, size.getSize4());
				ps.setString(5, size.getSize5());
				ps.setString(6, size.getComid());
				int rs=ps.executeUpdate();
				if(rs > 0){
					return true;
				}
			}
	
		return false;
	}

	
}
