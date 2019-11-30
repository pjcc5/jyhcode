package mao.soft.web.dao;

import java.sql.Connection;

import dao.UserDao;
import pojo.User;

public interface SelectUserByAidDao extends UserDao {
	User selectUserByAid(String aid ,Connection conn)throws Exception;
}
