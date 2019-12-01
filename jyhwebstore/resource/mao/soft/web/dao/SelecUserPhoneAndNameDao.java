package mao.soft.web.dao;

import java.sql.Connection;

import dao.UserDao;

public interface SelecUserPhoneAndNameDao extends UserDao{
	boolean selectUserPhoneAndName(String uphone,String uname,Connection conn)throws Exception;
}
