package dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pojo.Acount;
import chao.dao.AcountDao;
import chao.dao.impl.AcountDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class UserDaoImpl {
private void mian() {
	// TODO Auto-generated method stub

}
public static void main(String[] args) {
	Connection conn= DbHelp2.getConnection();
	
AcountDao dao=new AcountDaoImpl();
Acount acount=new Acount();
acount.setAid("1");
acount.setIsadm(1);
dao.modifyAcount(acount, conn);
}
}
