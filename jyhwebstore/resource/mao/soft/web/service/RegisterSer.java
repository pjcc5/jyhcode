package mao.soft.web.service;

import java.sql.Connection;
import java.sql.SQLException;

import pojo.Acount;
import pojo.User;
import dao.AcountDao;
import dao.UserDao;
import dao.impl.AcountDaoImpl;
import dao.impl.UserDaoImpl;
import db.DbHelp;

public class RegisterSer {
	public boolean register(Connection conn,Acount acount,User user)
	{
		 conn = DbHelp.getConnection();
		UserDao ud = new UserDaoImpl();
		AcountDao acd = new AcountDaoImpl();
		boolean f= false;
		boolean f2 = false;
		try {
			conn.setAutoCommit(false);//设置不能自动提交
			f = acd.insertAcount(acount, conn);
			f2 = ud.insertUser(user, conn);
			conn.commit();
//			System.out.println(" RegisterSer===conn========"+conn);
//			System.out.println("RegisterSer====f======="+f);
//			System.out.println(" RegisterSer===f2=========="+f2);
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("数据回滚中。。。。。。。。。");
//				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		if (f&&f2) {
			return true;
		}
		return true;
	}
	
}
