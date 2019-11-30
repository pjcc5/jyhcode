package tan.servers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import db.DbHelp2;
import tan.dao.CartDao;
import tan.dao.impl.CartDaoImpl;
import tan.dto.Cart;

public class CartServers {
	public List<Cart> selecCart(String aid,Connection conn){
	
		CartDao dao=new CartDaoImpl();
		List<Cart> list=null;
		try {
			list=dao.SelectCart(aid, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean UpdateCart(List<Cart> list,Connection conn,String aid){
		CartDaoImpl impl=new CartDaoImpl();
		boolean flag=false;
		try {
			flag=impl.UpdateCart(list, conn,aid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	

}
