package mao.soft.web.servlet.service;

import java.sql.Connection;
import java.util.UUID;

import pojo.Acount;
import chao.dao.impl.AcountDaoImpl;
import dao.AcountDao;
import db.DbHelp;

public class RegisterService {
	public void register(String registerName,String password,String phone) throws Exception
	{
			Connection conn = DbHelp.getConnection();
			//插入用户
			Acount acount = new Acount();
			String uuid =UUID.randomUUID().toString();
			acount.setAid(uuid);
			acount.setAname(registerName);
			acount.setApass(password);
			acount.setAphone(phone);
			acount.setAddr(null);
			acount.setAmail(null);
			acount.setIsadm(2);
			AcountDao acountDao = new AcountDaoImpl();
			acountDao.insertAcount(acount, conn);
		
	}
//	public static void main(String[] args) throws Exception {
//		RegisterService r= new RegisterService();
//		r.register(null, null, null);
//	}
}
