package mao.soft.web.servlet.service;

import java.sql.Connection;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import db.DbHelp;
import pojo.User;

public class ModifyInformationUser {
	public boolean modifyInformation(User user)throws Exception
	{
		Connection conn = DbHelp.getConnection();
		UserDao udao = new UserDaoImpl();
		boolean flag = udao.modifyUser(user, conn);
		return flag;
		
	}
}
