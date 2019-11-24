package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pojo.Compic;
import chao.dao.CompicDao;

public class CompicDaoImpl implements CompicDao{

	@Override
	public List<Compic> getAllCompic(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compic getCompicById(String comid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCompic(Compic compic, Connection conn) {
		if(conn == null)
		{
			return false;
		}
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteCompicByid(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCompic(Compic compic, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
