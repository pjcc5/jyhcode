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
			User userByphone =  sedao.selectUserPhone(uphone, conn);
			User userByname = sedao.selectUserName(uname, conn);
			if(userByname==null && userByphone==null)
			{
				boolean flags = getmodifyUserDetails(user,conn);
				return flags;
			}
			else if(userByname!=null && userByphone==null)
			{
				if(userByname.getAid().equalsIgnoreCase(user.getAid()))
				{
					boolean flags = getmodifyUserDetails(user,conn);
					return flags;
				}
				else
				{
					DbHelp.closeConnection(conn);
					return false;
				}
			}else if(userByname==null && userByphone!=null)
			{
				if(userByphone.getAid().equalsIgnoreCase(user.getAid()))
				{
					boolean flags = getmodifyUserDetails(user,conn);
					return flags;
				}
				else
				{
					DbHelp.closeConnection(conn);
					return false;
				}
			}
			else if(userByname!=null && userByphone!=null)
			{
				if( userByname.getAid().equalsIgnoreCase(user.getAid()) && userByphone.getAid().equalsIgnoreCase(user.getAid()))
				{
					boolean flags = getmodifyUserDetails(user,conn);
					return flags;
				}
				else
				{
					DbHelp.closeConnection(conn);
					return false;
				}
			}
			else
			{
				DbHelp.closeConnection(conn);
				return false;
			}
//			User users = sedao.selectUserNameAndPhone(uname, uphone, conn);
//			if(users==null)
//			{
//				boolean flags = modifyUserDetails(user,conn);
//				DbHelp.closeConnection(conn);
//				return flags;
//			}
//			else{
//				System.out.println("我的modifyUphoneAndUnameIsExist："+conn);
//				System.out.println("页面上传的user："+user+"\n"+"通过uname和uphone查询的user："+users);
//				//判断该账号是否改动
//				if(users.getAid().equalsIgnoreCase(user.getAid()))
//				{
//					System.out.println("两个user对象的aids是相等的");
//					boolean flags = modifyUserDetails(user,conn);
//					DbHelp.closeConnection(conn);
//					return flags;
//				}
//				else
//				{
//					DbHelp.closeConnection(conn);
//					return false;
//				}
//			}
	}
	//中间的调用方法
	private boolean getmodifyUserDetails(User user,Connection conn)
	{
		boolean flags = modifyUserDetails(user,conn);
		DbHelp.closeConnection(conn);
		return flags;
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
			System.out.println("modifyUserDetails返回的一个boolean："+flag);
			conn.commit();
			DbHelp.closeConnection(conn);
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
