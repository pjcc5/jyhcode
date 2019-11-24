package chao.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.User;
import chao.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUser(Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
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
					user.setBirth(rs.getDate("birth"));
					user.setSex(rs.getString("sex"));
					user.setUphone(rs.getString("uphone"));
					user.setMail(rs.getString("mail"));
					user.setSetadd(rs.getString("setadd"));
					list.add(user);
					
				}
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(int uid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		try {
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
					user.setBirth(rs.getDate("birth"));
					user.setSex(rs.getString("sex"));
					user.setUphone(rs.getString("uphone"));
					user.setMail(rs.getString("mail"));
					user.setSetadd(rs.getString("setadd"));
					return user;
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean insertUser(User user, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="insert into user values(?,?,?,?,?,?,?,?) ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, user.getUid());
				ps.setString(2, user.getUname());
				ps.setString(3, user.getPic());
				ps.setDate(4, new Date(user.getBirth().getTime()));
				ps.setString(5, user.getSex());
				ps.setString(6,user.getUphone());
				ps.setString(7, user.getMail());
				ps.setString(8, user.getSetadd());
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
	public boolean deleteUserByid(int uid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			String sql="delete from user where uid=?";
			if(!conn.isClosed()){
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, uid);
			int rs=	ps.executeUpdate();
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
	public boolean modifyUser(User user, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				String sql="update user set uname=?,pic=?,birth=?,sex=?,uphone=?,mail=?,setadd=? where uid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			   ps.setString(1, user.getUname());
				ps.setString(2, user.getPic());
				ps.setDate(3, new Date(user.getBirth().getTime()));
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
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
