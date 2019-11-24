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
	UserDao dao=new chao.dao.impl.UserDaoImpl();
	User user=new User();
	user.setBirth(new Date());
	user.setUid(1);
	System.out.println(dao.modifyUser(user, conn));


}
}
