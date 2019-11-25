package dao.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import pojo.Acount;
import pojo.Classes;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import pojo.Hot;
import pojo.Shopmiddle;
import pojo.Shopping;
import pojo.User;
import chao.dao.AcountDao;
import chao.dao.ClassesDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.HotDao;
import chao.dao.ShopmiddleDao;
import chao.dao.ShoppingDao;
import chao.dao.UserDao;
import chao.dao.impl.AcountDaoImpl;
import chao.dao.impl.ClassesDaoImpl;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import chao.dao.impl.HotDaoImpl;
import chao.dao.impl.ShopmiddleDaoImpl;
import chao.dao.impl.ShoppingDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class UserDaoImpl {
private void mian() {
	// TODO Auto-generated method stub

}
public static void main(String[] args) {
	Connection conn= DbHelp2.getConnection();
	Details details=new Details();
	DetailsDao dao=new DetailsDaoImpl();
	details.setColor("2");
	details.setDetailsdot(2);
	details.setDetailsdrawing("2");
	details.setDetailsid(1);
	details.setDetailsprice(20.0);
	details.setDetailssale(2);
	details.setDetailsstock(2);
	details.setPai("2");
	details.setSize("2");
	details.setTest4("2");
	details.setTest5("2");
	details.setTest6("2");
	
	System.out.println(dao.modifyDetails(details, conn));
}
}
