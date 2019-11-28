package mao.soft.web.servlet.service;

import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

import mao.soft.web.encryption.Encryption;
import mao.soft.web.service.RegisterSer;
import pojo.Acount;
import pojo.User;
import db.DbHelp;

public class RegisterService {
	public boolean register(String registerName,String password,String phone) throws Exception
	{
		
			Connection conn = DbHelp.getConnection();
			RegisterSer rs = new RegisterSer();
			Acount acount = new Acount();
			Encryption keys = new Encryption();
			password = keys.getKey(password);
			//插入acount
			String uuid =UUID.randomUUID().toString();
			acount.setAid(uuid);
			acount.setAname(registerName);
			acount.setApass(password);
			acount.setAphone(phone);
			acount.setAddr(null);
			acount.setAmail(null);
			acount.setIsadm(2);
			//插入user
			User user = new User();
			user.setMail("");
			user.setPic("");
			user.getBirth();
			user.setSetadd("");
			user.setUname(registerName);
			user.setUphone(phone);
			user.setSex("");
			//调插入方法
			boolean blog = rs.register(conn,acount, user);
			return blog;
	}
//	public static void main(String[] args) throws Exception {
//		RegisterService r= new RegisterService();
//		r.register(null, null, null);
//	}
}
