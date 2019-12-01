package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import pojo.User;
import mao.soft.web.dao.SelectUserByAidDao;

public class SelectUserByAidDaoImpl implements SelectUserByAidDao{

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
	public User selectUserByAid(String aid, Connection conn) throws Exception {
		User user = new User();
		if (conn==null||conn.isClosed()) {
			return null;
		} else {
			String sql = "select uname,pic,birth,sex,uphone,mail,setadd from user where aids=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				user.setUname(rs.getString("uname"));
				user.setPic(rs.getString("pic"));
				user.setBirth(rs.getDate("birth"));
				user.setSex(rs.getString("sex"));
				user.setUphone(rs.getString("uphone"));
				user.setMail(rs.getString("mail"));
				user.setSetadd(rs.getString("setadd"));
				return user;
			}else
			{
				return null;
			}
		}
	}

}
