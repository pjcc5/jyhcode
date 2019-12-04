package tan.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pojo.Address;
import pojo.Details;
import pojo.Shopping;
import dao.AddressDao;
import dao.ShoppingDao;
import dao.impl.AddressDaoImpl;
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
		ExDetailDao dao=new ExDetailsByComidImpl();
		Connection conn=DbHelp2.getConnection();
		dao.updateSaleByComid("0412f87d-1642-41a1-805b-e6dce58e1555", conn, 4);
	}
	

}
