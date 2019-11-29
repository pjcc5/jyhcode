package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.AddTab;
import dao.AddTabDao;

public class AddTabDaoImp implements AddTabDao{

	@Override
	public boolean insertAdd(Connection conn, AddTab addtab) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}
		else {
			String sql = "insert into addtab(aid,add1) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, addtab.getAid());
			ps.setString(2, addtab.getAdd1());
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteAdd(Connection conn, String aid) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}else
		{
			String sql = "delete from addtab where aid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public AddTab getAddByAid(String aid, Connection conn) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return null;
		}
		else
		{
			String sql = "select * from addtab where aid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				AddTab addtab = new AddTab();
				addtab.setAid(rs.getString("aid"));
				
			}
		}
		return null;
	}

	@Override
	public boolean modifyAdd(AddTab addtab, Connection conn) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}
		else {
			String sql = "update addtab set add1=? where aid=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, addtab.getAid());
			ps.setString(2, addtab.getAdd1());
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		
		return false;
	}

}
