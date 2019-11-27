package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjcDetailsDaoImpl;
import db.DbHelp2;
import dto.IndexGoodsDto;

public class LoadMoreGoodsService {
	
	public static  List<IndexGoodsDto> getmore(int page)
	{	
		//将来要返回的结果集合
		Connection conn =DbHelp2.getConnection();
		List<IndexGoodsDto> dtos =new ArrayList<IndexGoodsDto>();
		
		PjcDetailsDao pdd = new PjcDetailsDaoImpl();
		try {
			List<IndexGoodsDto> details = pdd.getfifdetailorderydot(page, conn);
			for (IndexGoodsDto details2 : details) {
				//将商品图片大小改变
				details2.setCompic(details2.getCompic().replace("50x50", "220x220"));
				
			}
			dtos =details;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
}
