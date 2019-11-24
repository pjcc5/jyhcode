package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.User;


public interface UserDao {
	public List<User> getAllUser(Connection conn);//获得所有的用户
	public User getUserById(int uid,Connection conn);//通过uid获得一个用户
	public boolean insertUser(User user,Connection conn);//插入用户的方法
	public boolean deleteUserByid(int uid,Connection conn);//删除用户的方法
	public boolean modifyUser(User user,Connection conn);//修改用户的方法
	
}
