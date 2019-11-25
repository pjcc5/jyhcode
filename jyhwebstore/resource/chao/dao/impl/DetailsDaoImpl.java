package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Compic;
import pojo.Details;
import chao.dao.DetailsDao;
import db.DbHelp2;

public class DetailsDaoImpl implements DetailsDao{

	@Override
	public List<Details> getAllDetails(Connection conn) {

		if(conn == null)
		{
			return null;
		}
		
		List<Details> list=new ArrayList<>();
		try {
			if(!conn.isClosed()){
				String sql="select * from details";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Details details=new Details();
			details.setDetailsdot(rs.getInt("detailsdot"));
			details.setDetailsdrawing(rs.getString("detailsdrawing"));
			details.setDetailsid(rs.getInt("detailsid"));
			details.setDetailsprice(rs.getDouble("detailsprice"));
			details.setDetailssale(rs.getInt("detailssale"));
			details.setDetailsstock(rs.getInt("detailsstock"));
			details.setColor(rs.getString("color"));
			details.setSize(rs.getString("size"));
			details.setPai(rs.getString("pai"));
			details.setTest4(rs.getString("test4"));
			details.setTest5(rs.getString("test5"));
			details.setTest6(rs.getString("test6"));
			list.add(details);
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Details getDetailsById(int detailsid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn == null)
		{
			return null;
		}
		
		try {
			if(!conn.isClosed()){
				String sql="select * from details where detailsid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, detailsid);
				ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Details details=new Details();
			details.setDetailsdot(rs.getInt("detailsdot"));
			details.setDetailsdrawing(rs.getString("detailsdrawing"));
			details.setDetailsid(rs.getInt("detailsid"));
			details.setDetailsprice(rs.getDouble("detailsprice"));
			details.setDetailssale(rs.getInt("detailssale"));
			details.setDetailsstock(rs.getInt("detailsstock"));
			details.setColor(rs.getString("color"));
			details.setSize(rs.getString("size"));
			details.setPai(rs.getString("pai"));
			details.setTest4(rs.getString("test4"));
			details.setTest5(rs.getString("test5"));
			details.setTest6(rs.getString("test6"));
			return details;
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertDetails(Details details, Connection conn) {
		if(conn == null)
		{
			return false;
		}
		
		try {
			System.out.println("连接状态:"+conn.isClosed());
			if(!conn.isClosed()){
				String sql = "insert into details values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, details.getDetailsid());
				ps.setInt(2, details.getDetailsstock());
				ps.setDouble(3, details.getDetailsprice());
				ps.setString(4, details.getDetailsdrawing());
				ps.setInt(5, details.getDetailsdot());
				ps.setInt(6, details.getDetailssale());
				ps.setString(7, details.getColor());
				ps.setString(8, details.getSize());
				ps.setString(9, details.getPai());
				ps.setString(10, details.getTest4());
				ps.setString(11, details.getTest5());
				ps.setString(12, details.getTest6());
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
	public boolean deleteDetailsByid(int aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="delete from details where detailsid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, aid);
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean modifyDetails(Details details, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			String sql="update details set detailsstock=?,detailsprice=?,detailsdrawing=?,"
					+ "detailsdot=?,detailssale=?,color=?,size=?,pai=?,test4=?,test5=?,test6=? where detailsid=?";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setInt(1, details.getDetailsstock());
		   ps.setDouble(2, details.getDetailsprice());
		   ps.setString(3, details.getDetailsdrawing());
		   ps.setInt(4, details.getDetailsdot());
		   ps.setInt(5, details.getDetailssale());
		   ps.setString(6, details.getColor());
		   ps.setString(7, details.getSize());
		   ps.setString(8, details.getPai());
		   ps.setString(9, details.getTest4());
		   ps.setString(10, details.getTest5());
		   ps.setString(11, details.getTest6());
		   ps.setInt(12, details.getDetailsid());
		   
		  int rs= ps.executeUpdate();
		  if(rs>0){
			  return true;
		  }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
