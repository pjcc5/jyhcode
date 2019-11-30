package tan.dao;

import java.sql.Connection;
import java.util.List;

import tan.dto.Cart;
import dao.ShoppingDao;

public interface CartDao extends ShoppingDao{
	public List<Cart> SelectCart(String  aid,Connection conn)throws Exception; 

	public boolean UpdateCart(List<Cart> list,Connection conn,String shopid) throws Exception;
}
