package dao.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import pojo.Acount;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import pojo.Hot;
import chao.dao.AcountDao;
import chao.dao.ClassesDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.HotDao;
import chao.dao.ShopmiddleDao;
import chao.dao.impl.AcountDaoImpl;
import chao.dao.impl.ClassesDaoImpl;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import chao.dao.impl.HotDaoImpl;
import chao.dao.impl.ShopmiddleDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class UserDaoImpl {
private void mian() {
	// TODO Auto-generated method stub

}
public static void main(String[] args) {
	Connection conn= DbHelp2.getConnection();
	ShopmiddleDao s=new ShopmiddleDaoImpl();
	Hot hot=new Hot();
	hot.setHotcom(2);
	hot.setHotdatestart(new Date());
	hot.setHotdatend(new Date());
	hot.setHotcomid("5");
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time=format.format(date);
	System.out.println(s.getSById("12", conn));


}
}
