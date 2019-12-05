package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import chao.dao.OrderFormDao;
import chao.dao.impl.OrderFormDaoImpl;
import dao.OrderMiddleDao;
import dao.OrderformDao;
import dao.impl.OrderMiddleDaoImpl;
import dao.impl.OrderformDaoImpl;
import db.DbHelp;
import dto.InnerOrderDto;
import dto.OrderDetailDto;
import dto.OrderDto;
import pojo.Commodity;
import pojo.Orderform;
import pojo.Ordermiddle;

public class OrderService {
	public static List<OrderDto> getAllOrderByAid(String aid)
	{
		Connection conn = DbHelp.getConnection();
		System.out.println("进入了orderservice");
		List<Ordermiddle> ordermiddles = new ArrayList<Ordermiddle>();
		List<Orderform> orderforms = new ArrayList<Orderform>();
		List<OrderDto> orderDtos = new ArrayList<OrderDto>();
		OrderMiddleDao omd = new OrderMiddleDaoImpl();
		OrderFormDao ofd = new OrderFormDaoImpl();
		
		try {
			ordermiddles = omd.getOrdermiddleByAid(aid, conn);
			for (Ordermiddle ordermiddle : ordermiddles) {
				System.out.println(ordermiddle);
				//拿到这个用户每一个订单
				//循环拿到每一个订单的商品
				OrderDto orderDto = new OrderDto();
				//设置dto的订单编号
				orderDto.setOrderIndex(ordermiddle.getOrderindex());
				
				orderforms  = ofd.getAllOrderformByOrderid(ordermiddle.getOrderid(), conn);
				System.out.println(orderforms);
				//设置dto的所有订单
				orderDto.setOrderForms(orderforms);
				orderDtos.add(orderDto);
				
			}
			return orderDtos;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		
		return null;
	}
	
	
	
	
	public static  InnerOrderDto getOrderCommodities(String orderid){
		Connection conn = DbHelp.getConnection();
		OrderformDao ofd = new OrderformDaoImpl();
		InnerOrderDto iod = new InnerOrderDto();
		double price =0d;
		try {
			//拿到所有订单中的商品
			List<OrderDetailDto> orderdetaildtos =  ofd.getComidsByOrderId(orderid, conn);
			//拿到订单总价
			for (OrderDetailDto or : orderdetaildtos) {
				price+=or.getComprice();
			}
			iod.setOrderprice(price);
			iod.setOrderdetaildtos(orderdetaildtos);
			
			return iod;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return iod;
		
	} 
	
	
	public static boolean modifyOrderFormState(String orderid, int orderstatement,
			int orderpay){
		Connection conn = DbHelp.getConnection();
		OrderformDao ofd = new OrderformDaoImpl();
		try {
			boolean result = ofd.modifyOrderformState(orderid, orderstatement, orderpay, conn);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		
		return false;
	}
}
