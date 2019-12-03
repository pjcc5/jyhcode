package mao.soft.web.servlet.service;

import java.sql.Connection;

import mao.soft.web.dao.SelectUserByAidDao;
import mao.soft.web.dao.imp.SelectUserByAidDaoImpl;
import db.DbHelp;
import pojo.User;

public class User_information {
	public User selectUserByAid(String aid) throws Exception{
		Connection conn = DbHelp.getConnection();
		SelectUserByAidDao selectuser = new SelectUserByAidDaoImpl();
		User user = selectuser.selectUserByAid(aid, conn);
		DbHelp.closeConnection(conn);
		return user;
	}
}
