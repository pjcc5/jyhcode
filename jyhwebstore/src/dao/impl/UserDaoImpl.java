package dao.impl;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
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
import pojo.Order;
import pojo.Shopmiddle;
import pojo.Shopping;
import pojo.Size;
import pojo.User;
import util.DateFromat;
import chao.dao.AcountDao;
import chao.dao.ClassesDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.HotDao;
import chao.dao.OrderDao;
import chao.dao.ShopmiddleDao;
import chao.dao.ShoppingDao;
import chao.dao.SizeDao;
import chao.dao.UserDao;
import chao.dao.impl.AcountDaoImpl;
import chao.dao.impl.ClassesDaoImpl;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import chao.dao.impl.HotDaoImpl;
import chao.dao.impl.OrderDaoImpl;
import chao.dao.impl.ShopmiddleDaoImpl;
import chao.dao.impl.ShoppingDaoImpl;
import chao.dao.impl.SizeDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class UserDaoImpl {
private void mian() {
	// TODO Auto-generated method stub

}
public static void main(String[] args) {
	Connection conn= DbHelp2.getConnection();
//   UserDao user=new chao.dao.impl.UserDaoImpl();
//   User user1=new User();
//   user1.setBirth(new Date());
//   user1.setMail("1");
//   user1.setPic("1");
//   user1.setSetadd("1");
//   user1.setSex("1");
//   user1.setUid(2);
//   user1.setUname("1");
//   user1.setUphone("1");
   
//   System.out.println(user.getAllUser(conn));
//   System.out.println(user.getUserById(2, conn));
//   System.out.println(user.deleteUserByid(2, conn));
//   System.out.println(user.insertUser(user1, conn));
//	System.out.println(user.modifyUser(user1, conn));
	
	
//	Shopping shop=new Shopping();
//	ShoppingDao shopping=new ShoppingDaoImpl();
//	shop.setComid("1");
//	shop.setCount(2);
//	shop.setDate(new Date());
//	shop.setShopid(1);
//	shop.setTest1("1");
//	shop.setTest3("1");
//	shop.setTest2("1");
//	shop.setTest4("2");
//	System.out.println(shopping.getAllAcount(conn));
//	System.out.println(shopping.getShopingById(2, conn));
//	System.out.println(shopping.insertShoping(shop, conn));
//	System.out.println(shopping.modifyShoping(shop, conn));
//    System.out.println(shopping.deleteShopingtByid(2, conn));

//Shopmiddle shop=new Shopmiddle();
//ShopmiddleDao dao=new ShopmiddleDaoImpl();
//System.out.println(dao.getAllShopmiddle(conn));
//System.out.println(dao.getSById("12", conn));
//shop.setAis("12");
//shop.setShopid(6);
//System.out.println(dao.insertShopmiddle(shop, conn));
//System.out.println(dao.modifyShopmiddle(shop, conn));
//System.out.println(dao.deleteShopmiddleByid("12", conn));


//Order order=new Order();
//order.setAid(5);
//order.setComid("2");
//order.setComname("3");
//order.setOrderadd("4");
//order.setOrdercompany("5");
//order.setOrderdate(new Date());
//order.setOrderid("8");
//order.setOrdername("9");
//order.setOrderpay(10);
//order.setOrderphone("11");
//order.setOrderprice(12.0);
//order.setOrderreturn(13);
//order.setOrderstatement(14);
//order.setTest1("15");
//order.setTest2("16");
//order.setTest3("17");
//order.setTest4("18");
//OrderDao dao=new OrderDaoImpl();
//System.out.println(dao.getAllOrder(conn));
//
//System.out.println(dao.deleteOrderByid(2, conn));
//System.out.println(dao.modifyOrder(order, conn));
//System.out.println(dao.insertOrder(order, conn));
//Timestamp t=new Timestamp(new Date().getTime());
//Date date=t;
//DateFromat df=new DateFromat();
//
//System.out.println(df.DateFormat(t));


//DetailsDao dao=new DetailsDaoImpl();
//System.out.println(dao.getAllDetails(conn));
	
	
	
SizeDao dao=new SizeDaoImpl();
//System.out.println(dao.getAllSize(conn));
//System.out.println(dao.getSizeById(1, conn));
//System.out.println(dao.deleteSizetByid(1, conn));
Size size=new Size();
size.setComid("4");
size.setSize1("11");
size.setSize2("22");
size.setSize3("33");
size.setSize4("44");
size.setSize5("55");
System.out.println(dao.modifySize(size, conn));
	

	
	
}
}
