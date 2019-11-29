package dao;

import java.sql.Connection;
import java.util.List;

import pojo.User;


public interface UserDao {
	public List<User> getAllUser(Connection conn)throws Exception;//获得所有的用户
	public User getUserById(String aid,Connection conn)throws Exception;//通过uid获得一个用户
	public boolean insertUser(User user,Connection conn)throws Exception;//插入用户的方法
	public boolean deleteUserByid(String aid,Connection conn)throws Exception;//删除用户的方法
	public boolean modifyUser(User user,Connection conn)throws Exception;//修改用户的方法
	
}
