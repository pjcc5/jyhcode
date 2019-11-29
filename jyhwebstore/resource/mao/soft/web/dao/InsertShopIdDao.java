package mao.soft.web.dao;

import java.sql.Connection;

import pojo.Shopping;
import dao.ShoppingDao;

public interface InsertShopIdDao extends ShoppingDao{
	boolean inserShopId(Shopping shop,Connection conn)throws Exception;
}
