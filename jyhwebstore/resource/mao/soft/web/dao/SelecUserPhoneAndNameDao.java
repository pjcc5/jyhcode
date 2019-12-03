package mao.soft.web.dao;

import java.sql.Connection;

import pojo.User;
import dao.UserDao;

public interface SelecUserPhoneAndNameDao extends UserDao{
	User selectUserNameAndPhone(String uname,String uphone,Connection conn)throws Exception;
	User selectUserName(String uname,Connection conn)throws Exception;
	User selectUserPhone(String uphone,Connection conn)throws Exception;
}
