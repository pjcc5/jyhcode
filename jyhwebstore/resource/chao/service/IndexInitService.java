package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjcDetailsDaoImpl;
import db.DbHelp;
import dto.IndexGoodsDto;

public class IndexInitService {
	public 	List<IndexGoodsDto> getIndexProducts(){
		List<IndexGoodsDto> list = new ArrayList<IndexGoodsDto>();
		try {
			//拿到连接
			Connection conn = DbHelp.getConnection();
			try {
				PjcDetailsDao pdd = new PjcDetailsDaoImpl();
				list = pdd.getfifdetailorderydot(1,conn);
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
