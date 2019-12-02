package mao.soft.web.service;

import java.sql.Connection;
import java.sql.SQLException;

import mao.soft.web.dao.SelecUserPhoneAndNameDao;
import mao.soft.web.dao.imp.SelecUserPhoneAndNameDaoImpl;
import pojo.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import db.DbHelp;

public class ModifyUserDetails {
	//查看修改的手机号和昵称是否存在
	public boolean modifyUphoneAndUnameIsExist(User user)throws Exception
	{
			Connection conn = DbHelp.getConnection();
			String uname = user.getUname();
			String uphone = user.getUphone();
			SelecUserPhoneAndNameDao sedao = new SelecUserPhoneAndNameDaoImpl();
			boolean flag = sedao.selectUserPhoneAndName(uphone, uname, conn);
			System.out.println("我的modifyUphoneAndUnameIsExist："+conn);
			if(flag==false)
			{
				boolean flags = modifyUserDetails(user,conn);
				return flags;
			}
			else
			{
				return false;
			}
	}
	//修改用户信息的方法
	private boolean modifyUserDetails(User user,Connection conn)
	{
		conn = DbHelp.getConnection();
		UserDao udao = new UserDaoImpl();
		boolean flag = false;
		System.out.println("我的modifyUserDetails："+conn);
		try {
			conn.setAutoCommit(false);
			flag = udao.modifyUser(user, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return flag;
	}
}
