package tan.dao;

import java.sql.Connection;

import pojo.Details;
import db.DbHelp2;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dao.impl.loginDaoImpl;
import tan.dto.ProductInformation;
import tan.servers.ProductDetail;

public class test {
	public static void main(String[] args) throws Exception {
		ProductDetail detail=new ProductDetail();
		
		Connection conn=DbHelp2.getConnection();
		ProductInformation de= detail.getProduct("675a1f61-c631-4434-a18a-770a43fb0d00", conn);
	      System.out.println(de);
	}

}
