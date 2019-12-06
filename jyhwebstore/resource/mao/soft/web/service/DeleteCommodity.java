package mao.soft.web.service;

import java.sql.Connection;

import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import db.DbHelp;

public class DeleteCommodity {
	public boolean deleteCommodity(String comid)
	{
		Connection conn = DbHelp.getConnection();
		CommodityDao commdao = new CommodityDaoImpl();
		boolean flag=false;
		try {
			flag = commdao.deleteCommodityByid(comid, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return flag;
	}
}
