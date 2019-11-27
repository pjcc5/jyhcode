package chao.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import pojo.Commodity;
import pojo.Details;
import chao.dao.PjcCommodityDao;
import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjCommodityDaoImpl;
import chao.dao.impl.PjcDetailsDaoImpl;
import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import db.DbHelp2;
import dto.IndexGoodsDto;

public class LoadMoreGoodsService {
	
	public static  List<IndexGoodsDto> getmore(int page)
	{	
		//将来要返回的结果集合
		Connection conn =DbHelp2.getConnection();
		List<IndexGoodsDto> dtos =new ArrayList<IndexGoodsDto>();
		PjcCommodityDao pcd =new PjCommodityDaoImpl();
		CommodityDao cmd =new CommodityDaoImpl();
		PjcDetailsDao pdd = new PjcDetailsDaoImpl();
		try {
			List<Details> details = pdd.getfifdetailorderydot(page, conn);
			for (Details details2 : details) {
				Commodity comm = cmd.getCommodityById(details2.getComid(),conn);
				IndexGoodsDto igd =new IndexGoodsDto();
				//将商品图片大小改变
				comm.setCompic(comm.getCompic().replace("50x50", "220x220"));
				igd.setComid(comm.getComid());
				igd.setComname(comm.getComname());
				igd.setCompic(comm.getCompic());
				igd.setDetailsdot(details2.getDetailsdot());
				igd.setComprice(comm.getComprice());
				igd.setPai(comm.getPai());
				dtos.add(igd);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
}
