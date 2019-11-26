package chao.dao.impl;

import java.sql.Connection;
import java.util.List;

import javax.persistence.criteria.Order;

import pojo.Orderform;
import chao.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Orderform> getAllOrder(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderform getOrderById(int aid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertOrder(Orderform order, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrderByid(int aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyOrder(Orderform order, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
