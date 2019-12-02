package tan.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import pojo.Details;
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
		CartDao dao=new CartDaoImpl();
		Connection conn=DbHelp2.getConnection();
		List<Cart> list=new ArrayList<>();
		list=dao.SelectCart("1", conn);
		System.out.println(list);
	}
	

}
