package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pojo.Details;
import chao.dao.DetailsDao;

public class DetailsDaoImpl implements DetailsDao{

	@Override
	public List<Details> getAllDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Details getDetailsById(String detailsid, Connection conn) {
		// TODO Auto-generated method stub
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
