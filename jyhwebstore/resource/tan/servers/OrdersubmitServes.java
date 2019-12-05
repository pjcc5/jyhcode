package tan.servers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Address;
import pojo.Commodity;
import pojo.Orderform;
import pojo.Ordermiddle;
import tan.dao.ExDetailDao;
import tan.dao.impl.ExDetailsByComidImpl;
import dao.AddressDao;
import dao.CommodityDao;
import dao.OrderMiddleDao;
import dao.OrderformDao;
import dao.impl.AddressDaoImpl;
import dao.impl.CommodityDaoImpl;
import dao.impl.OrderMiddleDaoImpl;
import dao.impl.OrderformDaoImpl;
import db.DbHelp;
import dto.OrderDetailDto;

public class OrdersubmitServes {
	public List<Object> getAddrAnddetai(String aid,String orderid){
		Connection conn=DbHelp.getConnection();
		AddressDao dao=new AddressDaoImpl();
		OrderformDao order=new OrderformDaoImpl();
		List<Object> li=new ArrayList<>();
		try {
			conn.setAutoCommit(false);
			List<Address> address=dao.getAddressByAid(aid, conn);
			List<OrderDetailDto> list= order.getComidsByOrderId(orderid, conn);
			conn.commit();
			li.add(address);
			li.add(list);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return li;
	}
	
	public  Commodity getCommodityById(String comid){
		Commodity good=null;
		Connection conn=DbHelp.getConnection();
		CommodityDao d=new CommodityDaoImpl();
		try {
			 good=d.getCommodityById(comid, conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
			
		}
		return good;
		
	}
	
	public void updateSaleByComid(String comid,int num){
		Connection conn=DbHelp.getConnection();
		ExDetailDao dao2=new ExDetailsByComidImpl();
		 try {
				
				System.out.println("更新销量"+dao2.updateSaleByComid(comid, conn, num));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void insertOrdermiddle(Ordermiddle middle){
		Connection conn= DbHelp.getConnection();
		 OrderMiddleDao dao3=new OrderMiddleDaoImpl();
		 try {
 			
				dao3.insertOrdermiddle(middle, conn);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				DbHelp.closeConnection(conn);
			}
		
	}
	
	public void insertOrderform(Orderform form){
		Connection conn=DbHelp.getConnection();
		 OrderformDao dao4=new OrderformDaoImpl();
		  try {
			
			dao4.insertOrderform(form, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		
	}

}
