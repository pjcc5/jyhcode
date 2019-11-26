package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import chao.dao.PjcCommodityDao;
import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjcDetailsDaoImpl;
import db.DbHelp;
import pojo.Commodity;
import pojo.Details;

public class IndexInitService {
	public 	List<Details> getIndexProducts(){
		List<Details> list = new ArrayList<Details>();
		try {
			//拿到连接
			Connection conn = DbHelp.getConnection();
			try {
				PjcDetailsDao pdd = new PjcDetailsDaoImpl();
				list = pdd.getfifdetailorderydot(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(!conn.isClosed())
				{
					conn.close();
				}
			}
			return list;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
}
