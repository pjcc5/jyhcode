package chao.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.stylesheets.DocumentStyle;

import chao.dao.AcountDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import db.DbHelp2;
import pojo.Acount;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;

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
	}

}
