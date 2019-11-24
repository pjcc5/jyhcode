package chao.dao.impl;

import java.sql.Connection;
import java.util.UUID;

import chao.dao.CommodityDao;
import db.DbHelp2;
import pojo.Commodity;

public class Test {

	public static void main(String[] args) {
		Commodity comm =new Commodity();
		String comid =UUID.randomUUID().toString();//设置统一商品id
		comm.setComid(comid);
		comm.setComname("爱疯1");
		comm.setCompic("sss");
		comm.setComdetails("aaa");
		comm.setComprice(1998.00d);
		comm.setComclass(10);
		Connection conn = DbHelp2.getConnection();
		CommodityDao cd =new CommodityDaoImpl();
		System.out.println(cd.insertCommodity(comm, conn));
		
		

	}

}
