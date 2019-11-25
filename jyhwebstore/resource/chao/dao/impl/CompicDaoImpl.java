package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Commodity;
import pojo.Compic;
import chao.dao.CompicDao;

public class CompicDaoImpl implements CompicDao{

	@Override
	public List<Compic> getAllCompic(Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn == null)
		{
			return null;
		}
		
		List<Compic> list=new ArrayList<>();
		
			if(!conn.isClosed()){
				String sql="select * from compic";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Compic compic=new Compic();
			compic.setComid(rs.getString("comid"));
			compic.setPicurl1(rs.getString("picurl1"));
			compic.setPicurl2(rs.getString("picurl1"));
			compic.setPicurl3(rs.getString("picurl3"));
			compic.setPicurl4(rs.getString("picurl4"));
			compic.setPicurl5(rs.getString("picurl5"));
			list.add(compic);
			}
				
			}
		
		
		return list;
		
	}
	@Override
	public Compic getCompicById(String comid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn == null)
		{
			return null;
		}
		
		List<Compic> list=new ArrayList<>();
		
			if(!conn.isClosed()){
				String sql="select * from compic where comid=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, comid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Compic compic=new Compic();
			compic.setComid(rs.getString("comid"));
			compic.setPicurl1(rs.getString("picurl1"));
			compic.setPicurl2(rs.getString("picurl1"));
			compic.setPicurl3(rs.getString("picurl3"));
			compic.setPicurl4(rs.getString("picurl4"));
			compic.setPicurl5(rs.getString("picurl5"));
			return compic;
			}
				
			}
	
		return null;
	}

	@Override
	public boolean insertCompic(Compic compic, Connection conn)throws Exception {
		if(conn == null)
		{
			return false;
		}
		
			if(!conn.isClosed()){
				String sql = "insert into compic values(?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, compic.getComid());
				ps.setString(2, compic.getPicurl1());
				ps.setString(3, compic.getPicurl2());
				ps.setString(4, compic.getPicurl3());
				ps.setString(5, compic.getPicurl4());
				ps.setString(6, compic.getPicurl5());
				
				
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
			 
			}
		
		
		
		return false;
	}

	@Override
	public boolean deleteCompicByid(String aid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}

			if(!conn.isClosed()){
				String sql="delete from compic where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, aid);
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
			
		
		return false;
	}

	@Override
	public boolean modifyCompic(Compic compic, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		
			if(!conn.isClosed()){
				String sql="update compic set picurl1=?,picurl2=?,"
						+ "picurl3=?,picurl4=?,picurl5=? where comid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(6, compic.getComid());
				ps.setString(1, compic.getPicurl1());
				ps.setString(2, compic.getPicurl2());
				ps.setString(3, compic.getPicurl3());
				ps.setString(4, compic.getPicurl4());
				ps.setString(5, compic.getPicurl5());
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
			
		
		return false;
	}

}
