package dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pojo.Acount;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import chao.dao.AcountDao;
import chao.dao.ClassesDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.impl.AcountDaoImpl;
import chao.dao.impl.ClassesDaoImpl;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class UserDaoImpl {
private void mian() {
	// TODO Auto-generated method stub

}
public static void main(String[] args) {
	Connection conn= DbHelp2.getConnection();
	DetailsDao dao=new DetailsDaoImpl();
	Details details=new Details();
	
	details.setDetailsid("1");
	details.setDetailsdot(2);
	details.setDetailsprice(10.0);
	details.setDetailssale(4);
	details.setDetailsstock(5);
System.out.println(dao.deleteDetailsByid("1", conn));;

}
}
