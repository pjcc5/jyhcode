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
	public List<Details> getAllDetails() {
		// TODO Auto-generated method stub
		Connection conn=DbHelp2.getConnection();
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
			details.setDetailsid(rs.getString("detailsid"));
			details.setDetailsprice(rs.getDouble("detailsprice"));
			details.setDetailssale(rs.getInt("detailssal"));
			details.setDetailsstock(rs.getInt("detailsstock"));
			details.setTest1(rs.getString("test1"));
			details.setTest1(rs.getString("test2"));
			details.setTest1(rs.getString("test3"));
			details.setTest1(rs.getString("test4"));
			details.setTest1(rs.getString("test5"));
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
	public Details getDetailsById(String detailsid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn == null)
		{
			return null;
		}
		
		List<Details> list=new ArrayList<>();
		try {
			if(!conn.isClosed()){
				String sql="select * from details where detailsid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, detailsid);
				ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Details details=new Details();
			details.setDetailsdot(rs.getInt("detailsdot"));
			details.setDetailsdrawing(rs.getString("detailsdrawing"));
			details.setDetailsid(rs.getString("detailsid"));
			details.setDetailsprice(rs.getDouble("detailsprice"));
			details.setDetailssale(rs.getInt("detailssale"));
			details.setDetailsstock(rs.getInt("detailsstock"));
			details.setTest1(rs.getString("test1"));
			details.setTest1(rs.getString("test2"));
			details.setTest1(rs.getString("test3"));
			details.setTest1(rs.getString("test4"));
			details.setTest1(rs.getString("test5"));
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
				ps.setString(1, details.getDetailsid());
				ps.setInt(2, details.getDetailsstock());
				ps.setDouble(3, details.getDetailsprice());
				ps.setString(4, details.getDetailsdrawing());
				ps.setInt(5, details.getDetailsdot());
				ps.setInt(6, details.getDetailssale());
				ps.setString(7, details.getTest1());
				ps.setString(8, details.getTest2());
				ps.setString(9, details.getTest3());
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
	public boolean deleteDetailsByid(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyDetails(Details details, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
