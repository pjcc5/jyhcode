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
	public User selectUserName(String uname, Connection conn) throws Exception {
		if (conn == null || conn.isClosed()) {
			return null;
		}else
		{
			String sql="select * from user where uname=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			User user = null;
			
			if (rs.next()) {
				System.out.println("好的查询成功uname了");
			    user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPic(rs.getString("pic"));
				user.setBirth(rs.getTimestamp("birth"));
				user.setSex(rs.getString("sex"));
				user.setUphone(rs.getString("uphone"));
				user.setMail(rs.getString("mail"));
				user.setSetadd(rs.getString("setadd"));
				user.setAid(rs.getString("aids"));
				return user;
			} 
		}
		return null;
	}

	@Override
	public User selectUserPhone(String uphone, Connection conn)
			throws Exception {
		if (conn == null || conn.isClosed()) {
			return null;
		}else
		{
			String sql="select * from user where uphone=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, uphone);
			ResultSet rs = ps.executeQuery();
			User user = null;
			
			if (rs.next()) {
				System.out.println("好的查询成功uphone了");
			    user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPic(rs.getString("pic"));
				user.setBirth(rs.getTimestamp("birth"));
				user.setSex(rs.getString("sex"));
				user.setUphone(rs.getString("uphone"));
				user.setMail(rs.getString("mail"));
				user.setSetadd(rs.getString("setadd"));
				user.setAid(rs.getString("aids"));
				return user;
			} 
		}
		return null;
	}
}
