package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import db.DbHelp;
import db.DbHelp2;
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
	
	public void changeDefault(String flag,int staue){
		AddressDao dao=new AddressDaoImpl();
		Connection conn=DbHelp.getConnection();
		try {
			Address address=dao.getAddressByAddressid(flag, conn);
		    dao.changeDefault(address.getAddressid(), staue, conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbHelp.closeConnection(conn);
		
	}
	
	public void insertAddress(Address address){
		Connection conn=DbHelp.getConnection();
		AddressDao dao=new AddressDaoImpl();
		try {
			dao.insertAddress(address, conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbHelp.closeConnection(conn);
	}
	
	public void modifyaddr(Address address){
		Connection conn=DbHelp.getConnection();
		AddressDao dao=new AddressDaoImpl();
		try {
			dao.modifyAdd(address, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbHelp.closeConnection(conn);
	}
	
	public void deleteAddress(String addressid){
		Connection conn=DbHelp.getConnection();
		AddressDao dao=new AddressDaoImpl();
		try {
			dao.deleteAddress(addressid, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbHelp.closeConnection(conn);
	}
	
	
}
