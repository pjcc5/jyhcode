package test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import chao.dao.HotDao;
import chao.dao.impl.HotDaoImpl;
import db.DbHelp2;
import pojo.Hot;

public class Test {
	public static void main(String[] args) {
		Hot hot = new Hot();
		Connection conn = DbHelp2.getConnection();
		HotDao hd = new HotDaoImpl();
		Date d = new Date();
		hot.setHotdatend(d);
		hot.setHotdatestart(d);
		hot.setHotcom(1);
		hot.setHotcomid("23432");
		hot.setTest1(null);
		hot.setTest2(null);
		hot.setTest3(null);
		boolean f =hd.modifyHot(hot, conn);
		System.out.println(f);
	}
}
