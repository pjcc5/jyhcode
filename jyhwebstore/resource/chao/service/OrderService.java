package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import chao.dao.OrderFormDao;
import chao.dao.impl.OrderFormDaoImpl;
import dao.OrderMiddleDao;
import dao.impl.OrderMiddleDaoImpl;
import db.DbHelp;
import dto.OrderDto;
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
}
