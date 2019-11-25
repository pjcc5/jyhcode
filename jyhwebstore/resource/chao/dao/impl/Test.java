package chao.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
//<<<<<<< HEAD
//=======
import java.util.ArrayList;
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.stylesheets.DocumentStyle;


import chao.dao.AcountDao;
//=======
import chao.dao.ClassesDao;
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.HotDao;
import chao.dao.ShoppingDao;
import db.DbHelp2;
//<<<<<<< HEAD
import pojo.Acount;
//=======
import pojo.Classes;
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import pojo.Order;
import pojo.Hot;
import pojo.Shopping;
public class Test {

	public static void main(String[] args) {
		//测试商品插入OK
//		Commodity comm =new Commodity();
//		String comid =UUID.randomUUID().toString();//设置统一商品id
//		comm.setComid(comid);
//		comm.setComname("爱疯1");
//		comm.setCompic("sss");
//		comm.setComdetails("aaa");
//		comm.setComprice(1998.00d);
//		comm.setComclass(10);
//		Connection conn = DbHelp2.getConnection();
//		CommodityDao cd =new CommodityDaoImpl();
//		System.out.println(cd.insertCommodity(comm, conn));
		//测试商品详情OK
//		Details dt = new Details();
//		String detailsid =UUID.randomUUID().toString();
//		dt.setDetailsid(detailsid);
//		dt.setDetailsstock(200);
//		dt.setDetailsprice(1998.00d);
//		dt.setDetailsdrawing("图片");
//		dt.setDetailsdot(0);
//		dt.setDetailssale(0);
//		DetailsDao dd =new DetailsDaoImpl();
//		
//		System.out.println(dd.insertDetails(dt, conn));

		//测试连接表的插入OK
//		Compic com =new Compic();
//		String comid =UUID.randomUUID().toString();
//		com.setComid(comid);
//		com.setPicurl1("照片1");
//		com.setPicurl2("照片2");
//		com.setPicurl3("照片3");
//		com.setPicurl4("照片4");
//		com.setPicurl5("照片5");
//		CompicDao cd =new CompicDaoImpl();
//		System.out.println(cd.insertCompic(com, conn));
		
		
//		String url = "https://item.yhd.com/57268990549.html";
//		try {
//			
//			Document doc = Jsoup.connect(url).ignoreContentType(true).get();
//			Elements  docs = doc.select("script");
//			for (Element element : docs) {
//				System.out.println(element);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		//测试AcountDao的实现类AcountDaoImpl中的方法
//		AcountDao acountdao = new AcountDaoImpl();
//		Connection conn = DbHelp2.getConnection();
		//测试插入ok
//		Acount acount = new Acount();
//		acount.setAmail("1329016283@qq.com");
//		acount.setAname("老猫");
//		acount.setAid("12");
//		acount.setApass("123456");
//		acount.setAphone("15074909568");
//		acount.setAddr("湖南长沙");
//		acount.setIsadm(2);
//		acountdao.insertAcount(acount,conn);
		//测试查询ok
//		List<Acount>list =  acountdao.getAllAcount(conn);
//		System.out.println(list);
		//测试修改ok
//		Acount acount = new Acount();
//		acount.setAid("12");
//		acount.setAmail("1329016283@qq.com");
//		acount.setAname("猫大大");
//		acount.setApass("123456");
//		acount.setAphone("15074909568");
//		acount.setAddr("湖南长沙");
//		acount.setIsadm(5);
//		boolean flag = acountdao.modifyAcount(acount, conn);
//		System.out.println(flag);
		//测试删除ok
//		boolean f =acountdao.deleteAcountByid("12", conn);
//		System.out.println(f);
		//测试单个的查询12
//		Acount ac =  acountdao.getAcountById("12", conn);
//		System.out.println(ac);
		//测试commoditydao的implement中的方法
//		Connection conn = DbHelp2.getConnection();
//		CommodityDao cd = new CommodityDaoImpl();
		//插入ok
//		Commodity comm = new Commodity();
//		comm.setComname("华为note10plus");
//		comm.setComclass("2");
//		comm.setComdetails(2222);
//		comm.setComid("123");
//		comm.setComprice(59000.2);
//		comm.setCompic("图片");
//	    boolean f=cd.insertCommodity(comm, conn);
//	    System.out.println(f);
		//查询ok
//		List<Commodity>list = cd.getAllCommodity(conn);
//		System.out.println(list);
		//修改ok
//		Commodity comm = new Commodity();
//		comm.setComname("华为note10plus");
//		comm.setCompic("图片");
//		comm.setComdetails(2222);
//		comm.setComprice(59000.2);
//		comm.setComclass("2");
//		comm.setColor("炫酷黑");
//		comm.setPai("华为");
//		comm.setSize("286GB");
//		comm.setComid("123");
//		boolean f = cd.modifyCommodity(comm, conn);
//		System.out.println(f);
		//删除ok
//		boolean f = cd.deleteCommodityByid("123", conn);
//		System.out.println(f);
		//查询单个ok
//		Commodity co = cd.getCommodityById("123", conn);
//		System.out.println(co);
//		
		
//		String url = "https://item.yhd.com/57268990549.html";
//		try {
//			
//			Document doc = Jsoup.connect(url).ignoreContentType(true).get();
//			Elements  docs = doc.select("script");
//			for (Element element : docs) {
//				System.out.println(element);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		
//		Connection conn =DbHelp2.getConnection();
	/*
	 *	测试calsses表OK
	 */
	//测试classes表的前插入方法Ok
//		ClassesDao cd =new ClassesDaoImpl();
//		Classes c = new Classes();
//		connection conn =DbHelp2.getConnection();
//		c.setClassid(1);
//		c.setSize("大");
//		c.setSeason(10);
//		c.setColor("至尊蓝");
//		c.setBrand("苹果");
//		c.setClasses("手机");
//		c.setTest1("测试1");
//		c.setTest2("测试2");
//		c.setTest3("测试3");
//		c.setTest4("测试4");
//		boolean result = cd.insertClasses(c, conn);
//		System.out.println(result);
		//测试classes表的拿到所有方法Ok
//		List<Classes> list = cd.getAllClasses(conn);
//		for (Classes classes : list) {
//			System.out.println(classes);
//		}
		
		//测试classes表的拿到一个方法Ok
//		Classes clas =cd.getClassesById(1, conn);
//		System.out.println(clas);
		
//<<<<<<< HEAD
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
//<<<<<<< HEAD
//=======
//=======
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
		//测试classes表的删除一个方法Ok
//		boolean result =cd.deleteClassesByid(1, conn);
//		System.out.println(result);
		
		//测试classes表的修改一个方法OK
//		Classes c = new Classes();
//		c.setClassid(2);
//		c.setSize("小");
//		c.setSeason(12);
//		c.setColor("至尊红");
//		c.setBrand("华为");
//		c.setClasses("手机");
//		c.setTest1("测试1");
//		c.setTest2("测试2");
//		c.setTest3("测试3");
//		c.setTest4("测试4");
//		boolean result = cd.modifyClasses(c, conn);
//		System.out.println(result);
//<<<<<<< HEAD
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
				//测试hot表
//				HotDao hd = new HotDaoImpl();
//				Connection  conn = DbHelp2.getConnection();
//				Hot hot = new Hot();
//				java.util.Date date = new java.util.Date();
//				
//				hot.setHotcom(1);
//				hot.setHotcomid("123");
//				hot.setHotdatestart(date);
//				hot.setHotdatend(date);
//			boolean f =	hd.insertHot(hot, conn);
//			System.out.println(f);
		
//		java.util.Date date = new java.util.Date();
//		
//		System.out.println(date.getTime());
//		java.util.Date dates = new java.util.Date(1574671301296l);
//		System.out.println(dates.toLocaleString());
//=======
		
		
//		/**
//		 * 测试compic表OK
//		 * 
//		 */
		//测试compic表的插入一条OK
//		Compic c =new Compic();
//		CompicDao cd =new CompicDaoImpl();
//		c.setComid("Id1");
//		c.setPicurl1("url1");
//		c.setPicurl2("url2");
//		c.setPicurl3("url3");
//		c.setPicurl4("url4");
//		c.setPicurl5("url5");
//		boolean result = cd.insertCompic(c, conn);
//		System.out.println(result);
		
		//测试compic表的拿到所有OK
//		List<Compic> list = new ArrayList<Compic>();
//		list = cd.getAllCompic(conn);
//		for (Compic compic : list) {
//			System.out.println(compic);
//		}
		
		//测试compic表的根据主键拿一个OK
//		Compic c1 = cd.getCompicById("Id1", conn);
//		System.out.println(c1);
		
		//测试compic表的修改一条数据OK
//		Compic c1 =new Compic();
//		c1.setComid("Id1");
//		c1.setPicurl1("url2");
//		c1.setPicurl2("url3");
//		c1.setPicurl3("url4");
//		c1.setPicurl4("url5");
//		c1.setPicurl5("url6");
//		boolean result = cd.modifyCompic(c1, conn);
//		System.out.println(result);
		
		
		//测试compic表的删除一条数据OK
//		boolean result = cd.deleteCompicByid("Id1", conn);
//		System.out.println(result);
		
//>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git
		
		/*
		 * 测试order表
		 */
		
		//测试order 的插入一个
//		Order o = new Order();
//		o.setAid(1);
//		o.setComid("comid");
//		o.setComname(comname);
		
		
	}

}
