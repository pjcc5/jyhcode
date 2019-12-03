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
		String shopid = UUID.randomUUID().toString();
		AddressDao dao=new AddressDaoImpl();
	Connection conn=	DbHelp2.getConnection();
	Address address=new Address();
	address.setAddressid("2");
	address.setAid(UUID.randomUUID().toString());
	address.setIsdefault(1);
	address.setRecivephone("18890573466");
		System.out.println(dao.modifyAdd(address, conn));;
	}
	

}
