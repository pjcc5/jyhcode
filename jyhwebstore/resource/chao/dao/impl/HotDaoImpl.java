package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Hot;
import chao.dao.HotDao;

public class HotDaoImpl implements HotDao{

	@Override
	public List<Hot> getAllHot(Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
			if(!conn.isClosed()){
				String sql="select * from hot";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				List<Hot> list=new ArrayList<>();
				while(rs.next()){
					Hot hot=new Hot();
					hot.setHotcom(rs.getInt("hotcom"));
					hot.setHotcomid(rs.getString("hotcomid"));
					hot.setHotdatestart(rs.getTimestamp("hotdatestart"));
					hot.setHotdatend(rs.getTimestamp("hotdatend"));
					hot.setTest1(rs.getString("test1"));
					hot.setTest2(rs.getString("test2"));
					hot.setTest3(rs.getString("test3"));
					list.add(hot);
				}
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Hot getHotById(int hotcom, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
			if(!conn.isClosed()){
				String sql="select * from hot where hotcom=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, hotcom);
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()){
					Hot hot=new Hot();
					hot.setHotcom(rs.getInt("hotcom"));
					hot.setHotcomid(rs.getString("hotcomid"));
					hot.setHotdatestart(rs.getTimestamp("hotdatestart"));
					hot.setHotdatend(rs.getTimestamp("hotdatend"));
					hot.setTest1(rs.getString("test1"));
					hot.setTest2(rs.getString("test2"));
					hot.setTest3(rs.getString("test3"));
					return hot;
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean insertHot(Hot hot, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="insert into hot values(?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, hot.getHotcom());
				ps.setString(2, hot.getHotcomid());
				ps.setTimestamp(3, new Timestamp(hot.getHotdatestart().getTime()));
			    ps.setTimestamp(4, new Timestamp(hot.getHotdatend().getTime()));
			    ps.setString(5, hot.getTest1());
			    ps.setString(6, hot.getTest2());
			    ps.setString(7, hot.getTest3());
			    int rs=ps.executeUpdate();
			    if(rs>0){
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
	public boolean deleteHotByid(int aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
			String sql="delete from hot where hotcom=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,aid );
			int rs=ps.executeUpdate();
			  
			    if(rs>0){
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
	public boolean modifyHot(Hot hot, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="update hot set hotcomid=?,hotdatestart=?,hotdatend=?,test1=?,test2=?,test3=? where hotcom=?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setString(1, hot.getHotcomid());
			 ps.setTimestamp(2, new Timestamp(hot.getHotdatestart().getTime()));
			 ps.setTimestamp(3, new Timestamp(hot.getHotdatend().getTime()));
			 ps.setString(4, hot.getTest1());
			 ps.setString(5, hot.getTest2());
			 ps.setString(6, hot.getTest3());
			 ps.setInt(7,hot.getHotcom());
			 int rs=ps.executeUpdate();
			 if(rs>0){
				 return true;
			 }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
