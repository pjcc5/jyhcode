package test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.xml.soap.Detail;

import chao.dao.DetailsDao;
import chao.dao.HotDao;
import chao.dao.impl.DetailsDaoImpl;
import chao.dao.impl.HotDaoImpl;
import db.DbHelp2;
import pojo.Details;
import pojo.Hot;

public class Test {
	public static void main(String[] args) {
//		Hot hot = new Hot();
//		Connection conn = DbHelp2.getConnection();
//		HotDao hd = new HotDaoImpl();
//		Date d = new Date();
//		hot.setHotdatend(d);
//		hot.setHotdatestart(d);
//		hot.setHotcom(1);
//		hot.setHotcomid("23432");
//		hot.setTest1(null);
//		hot.setTest2(null);
//		hot.setTest3(null);
//		boolean f =hd.modifyHot(hot, conn);
//		System.out.println(f);
		Connection conn = DbHelp2.getConnection();
		Details details = new Details();
		DetailsDao dd = new DetailsDaoImpl();
//		details.setColor("灰白45");
//		details.setDetailsdot(10000);
//		details.setDetailsdrawing("string");
//		details.setDetailsid(2);
//		details.setDetailsprice(2000.23);
//		details.setDetailssale(10000);
//		details.setDetailsstock(10000);
//		details.setPai("华为");
//		details.setSize("128GB");
//		details.setTest4(null);
//		details.setTest5(null);
//		details.setTest6(null);
//		boolean f = dd.insertDetails(details, conn);
//		System.out.println(f);
//		List<Details>list=dd.getAllDetails(conn);
//		System.out.println(list);
//		Details d = dd.getDetailsById(2, conn);
//		System.out.println(d);
//		boolean f = dd.modifyDetails(details, conn);
//		System.out.println(f);
//		dd.deleteDetailsByid(2, conn);
	}
}
