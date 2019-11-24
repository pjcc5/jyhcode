package chao.dao.impl;

import java.sql.Connection;
import java.util.UUID;

import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import db.DbHelp2;
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
		Connection conn = DbHelp2.getConnection();
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
		
		
		
		
	}

}
