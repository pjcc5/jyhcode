package chao.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chao.dao.SearchGoodsDao;
import chao.dao.impl.SearchGoodsDaoImpl;
import db.DbHelp;
import dto.IndexGoodsDto;

public class SearchGoodsService {
	
	public static List<IndexGoodsDto> getSearch(String content,int page){
		List<IndexGoodsDto> list =new ArrayList<IndexGoodsDto>();
		Connection conn = DbHelp.getConnection();
		SearchGoodsDao sgd =new SearchGoodsDaoImpl();
		try {
			//通过dao层查询到数据
			System.out.println("Service"+content);
			list = sgd.getTwentySearch(content, page, conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return list;
		
	}
	
	public static int  getMaxpage(String content){
		int maxpage = 1;
		Connection conn = DbHelp.getConnection();
		SearchGoodsDao sgd =new SearchGoodsDaoImpl();
		try {
			//获得最大页数
			 maxpage = sgd.getMaxPage(content, conn);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
		return maxpage;
		
		
	}
}
