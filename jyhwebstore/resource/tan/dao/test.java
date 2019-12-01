package tan.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pojo.Details;
import pojo.Shopping;
import dao.ShoppingDao;
import dao.impl.ShoppingDaoImpl;
import db.DbHelp;
import db.DbHelp2;
import tan.dao.impl.CartDaoImpl;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dao.impl.loginDaoImpl;
import tan.dto.Cart;
import tan.dto.ProductInformation;
import tan.servers.ProductDetail;

public class test {
	public static void main(String[] args) throws Exception {
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
		ShoppingDao shopdao = new ShoppingDaoImpl();
		Connection conn=DbHelp2.getConnection();
		System.out.println(shopdao.insertShoping(shop, conn));
	}
	

}
