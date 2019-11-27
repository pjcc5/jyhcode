package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import mao.soft.web.dao.MaoRegisterDao;
import pojo.Acount;

public class MaoRegisterDaoImp implements MaoRegisterDao{

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
	public boolean selectPhoneIsExist(String phone, Connection conn) throws Exception {
		if (conn == null || conn.isClosed()) {
			return false;
		}else
		{
			String sql="select * from acount where phone=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("好的查询成功了");
				return true;
			} else {
				System.out.println("暂时没得该账号");
				return false;
			}
		}
	}

}
