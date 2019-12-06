package mao.soft.web.servlet.service;

import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

import mao.soft.web.encryption.Encryption;
import mao.soft.web.service.RegisterSer;
import pojo.Acount;
import pojo.AddTab;
import pojo.Shopmiddle;
import pojo.Shopping;
import pojo.User;
import dao.AddTabDao;
import dao.ShopmiddleDao;
import dao.ShoppingDao;
import dao.impl.AddTabDaoImp;
import dao.impl.ShopmiddleDaoImpl;
import dao.impl.ShoppingDaoImpl;
import db.DbHelp;

public class RegisterService {
	public boolean register(String registerName,String password,String phone) throws Exception
	{
		
			Connection conn = DbHelp.getConnection();
			conn.setAutoCommit(false);
			RegisterSer rs = new RegisterSer();
			Encryption keys = new Encryption();
			password = keys.getKey(password);
			//插入acount
			String uuid =UUID.randomUUID().toString();
			Acount acount = new Acount();
			acount.setAid(uuid);
			acount.setAname(registerName);
			acount.setApass(password);
			acount.setAphone(phone);
			acount.setAddr(null);
			acount.setAmail(null);
			acount.setIsadm(2);
			//插入user
			User user = new User();
			user.setMail("");
			user.setPic("");
			user.getBirth();
			user.setSetadd("");
			user.setUname(registerName);
			user.setUphone(phone);
			user.setSex("");
			user.setAid(uuid);
			//购物车的id
			String shopid = UUID.randomUUID().toString();
			Shopping shop = new Shopping();
			shop.setShopid(shopid);
			shop.setColor("");
			shop.setComname("");
			shop.setDate("");
			shop.setSize("");
			shop.setCount("");
			shop.setCompic("");
			shop.setComprice("");
			shop.setUuid("");
			shop.setComid("");
			ShoppingDao shopdao = new ShoppingDaoImpl();
			shopdao.insertShoping(shop, conn);
			//购物车中间表
			Shopmiddle shopmiddle = new Shopmiddle();
			shopmiddle.setAid(uuid);
			shopmiddle.setShopid(shopid);
			ShopmiddleDao shopmdao = new ShopmiddleDaoImpl();
			shopmdao.insertShopmiddle(shopmiddle, conn);
			//给地址表一个用户的id用来关联
			AddTab addtab = new AddTab();
			addtab.setAid(uuid);
			addtab.setAdd1("");
			AddTabDao adddao = new AddTabDaoImp();
			adddao.insertAdd(conn, addtab);
			//调插入方法
			boolean blog = rs.register(conn,acount, user);
			conn.commit();
			DbHelp.closeConnection(conn);
			return blog;
	}
}
