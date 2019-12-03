package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Orderform;
import dao.OrderformDao;

public interface OrderFormDao extends OrderformDao {
	public List<Orderform> getAllOrderformByAid(String aid,Connection conn);
	public List<Orderform> getAllOrderformByOrderid(String orderid,Connection conn);
}
