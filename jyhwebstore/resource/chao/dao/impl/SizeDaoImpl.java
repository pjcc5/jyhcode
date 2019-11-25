package chao.dao.impl;

import java.sql.Connection;
import java.util.List;

import pojo.Size;
import chao.dao.SizeDao;

public class SizeDaoImpl implements SizeDao{

	@Override
	public List<Size> getAllSize(Connection conn) {
		if(conn == null)
		{
			return null;
		}
		try {
			String sql ="select * from size";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

	@Override
	public Size getShopingById(int comid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertSize(Size size, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSizetByid(int comid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifySize(Size size, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
