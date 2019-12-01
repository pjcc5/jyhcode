package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import pojo.User;
import mao.soft.web.dao.SelecUserPhoneAndNameDao;

public class SelecUserPhoneAndNameDaoImpl implements SelecUserPhoneAndNameDao{

	@Override
	public List<User> getAllUser(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String aid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserByid(String aid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyUser(User user, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectUserPhoneAndName(String uphone, String uname,
			Connection conn) throws Exception {

		if (conn == null || conn.isClosed()) {
			return false;
		}else
		{
			String sql="select * from user where uname=? or uphone=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, uphone);
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
