package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import db.DbHelp;
import pojo.Address;

public class AddressService {
	public static List<Address> getAddressByAid(String aid){
		Connection conn = DbHelp.getConnection();
		List<Address>  list = new ArrayList<Address>();
		try {
			AddressDao ad = new AddressDaoImpl();
			list = ad.getAddressByAid(aid, conn);
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return list;
	};
}
