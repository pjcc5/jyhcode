package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import pojo.Acount;
import mao.soft.web.dao.SelectAidByNameDao;

public class SelectAidByNameDaoImp implements SelectAidByNameDao{

	@Override
	public List<Acount> getAllAcount(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acount getAcountById(String aid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertAcount(Acount acount, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAcountByid(String aid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyAcount(Acount acount, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Acount selectAidByName(String aname, Connection conn)
			throws Exception {
		Acount acount = null;
		if(conn==null||conn.isClosed())
		{
			return null;
		}
		else
		{
			String sql="select aid from acount where aname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aname);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				acount.setAid(rs.getString("aname"));
				return acount;
			}else
			{
				return null;
			}
			
		}
	}

}
