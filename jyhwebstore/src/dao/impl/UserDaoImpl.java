package dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pojo.Acount;
import pojo.Commodity;
import pojo.Compic;
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
	Compic compic=new Compic();
	compic.setComid("1");
	compic.setPicurl1("456");
System.out.println(dao.getDetailsById("1", conn));;

}
}
