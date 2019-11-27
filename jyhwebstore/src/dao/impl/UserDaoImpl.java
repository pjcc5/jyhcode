package dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import pojo.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUser(Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}

			if(!conn.isClosed()){
				String sql="select * from user";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				List<User> list=new ArrayList<>();
				while(rs.next()){
					User user=new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPic(rs.getString("pic"));
					user.setBirth(rs.getTimestamp("birth"));
					user.setSex(rs.getString("sex"));
					user.setUphone(rs.getString("uphone"));
					user.setMail(rs.getString("mail"));
					user.setSetadd(rs.getString("setadd"));
					list.add(user);
					
				}
				return list;
			}
		
		return null;
	}

	@Override
	public User getUserById(int uid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
	
			if(!conn.isClosed()){
				String sql="select * from user where uid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					User user=new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPic(rs.getString("pic"));
					user.setBirth(rs.getTimestamp("birth"));
					user.setSex(rs.getString("sex"));
					user.setUphone(rs.getString("uphone"));
					user.setMail(rs.getString("mail"));
					user.setSetadd(rs.getString("setadd"));
					return user;
					
				}
			}
		
		
		return null;
	}

	@Override
	public boolean insertUser(User user, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(!conn.isClosed()){
				String sql="insert into user(uname,pic,birth,sex,uphone,mail,setadd) values(?,?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
//				ps.setInt(1, user.getUid());
				ps.setString(1, user.getUname());
				ps.setString(2, user.getPic());
				ps.setTimestamp(3, new Timestamp(new Date().getTime()));
				ps.setString(4, user.getSex());
				ps.setString(5,user.getUphone());
				ps.setString(6, user.getMail());
				ps.setString(7, user.getSetadd());
			    int rs=ps.executeUpdate();
			    if(rs>0){
			    	return true;
			    }
			}
		
		return false;
	}

	@Override
	public boolean deleteUserByid(int uid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			String sql="delete from user where uid=?";
			if(!conn.isClosed()){
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, uid);
			int rs=	ps.executeUpdate();
			if(rs>0){
				return true;
			}
			}
	
		return false;
	}

	@Override
	public boolean modifyUser(User user, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(!conn.isClosed()){
				String sql="update user set uname=?,pic=?,birth=?,sex=?,uphone=?,mail=?,setadd=? where uid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			   ps.setString(1, user.getUname());
				ps.setString(2, user.getPic());
				ps.setTimestamp(3, new Timestamp(user.getBirth().getTime()));
				ps.setString(4, user.getSex());
				ps.setString(5, user.getUphone());
				ps.setString(6, user.getMail());
				ps.setString(7, user.getSetadd());
				ps.setInt(8, user.getUid());
				int rs= ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
			
		
		return false;
	}

}
