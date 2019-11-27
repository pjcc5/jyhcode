package service;

import java.sql.Connection;

import pojo.Acount;
import tan.dao.loginDao;
import tan.dao.impl.loginDaoImpl;

public class loginService {
	
	public Acount login(String name ,String pass,Connection conn){
		Acount acount=null;
	loginDao logindao=new loginDaoImpl();
	try {
		acount = logindao.loginSelect(name, pass, conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return acount;
	}
	

}
