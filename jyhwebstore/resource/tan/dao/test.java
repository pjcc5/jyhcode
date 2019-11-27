package tan.dao;

import java.sql.Connection;

import tan.dao.impl.loginDaoImpl;

public class test {
	public static void main(String[] args) throws Exception {
		loginDao dao=new loginDaoImpl();
		Connection conn=db.DbHelp2.getConnection();
		System.out.println(dao.loginSelect("1", "1", conn));
	}

}
