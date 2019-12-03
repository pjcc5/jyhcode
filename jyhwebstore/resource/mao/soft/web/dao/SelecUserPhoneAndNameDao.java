package mao.soft.web.dao;

import java.sql.Connection;

import pojo.User;
import dao.UserDao;

public interface SelecUserPhoneAndNameDao extends UserDao{
	User selectUserNameAndPhone(String uname,String uphone,Connection conn)throws Exception;
}
