package mao.soft.web.service;

import java.sql.Connection;
import java.util.List;

import mao.soft.web.dao.SelectMaxPageComic;
import mao.soft.web.dao.imp.SelectMaxPageSizeDaoImp;
import mao.soft.web.dateuti.CommodityUtil;
import db.DbHelp;
import db.DbHelp2;

public class SelectMaxPageSize {
	public int maxPage(int page) 
	{
		SelectMaxPageComic max = new SelectMaxPageSizeDaoImp();
		Connection conn = DbHelp.getConnection();
		int maxPageNo=0;
		try {
			maxPageNo = max.selectMaxPageNo(page, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxPageNo;
	}
	
	public List<CommodityUtil> allCommodity(int pageNo,int pageSize)
	{
		Connection conn = DbHelp2.getConnection();
		SelectMaxPageComic max = new SelectMaxPageSizeDaoImp();
		List<CommodityUtil> allCommodity = null;
		try {
			allCommodity = max.selectAllStudent(pageNo, pageSize, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CommodityUtil commodity : allCommodity) {
			System.out.println("我的商品集合："+commodity);
		}
		return allCommodity;
	}
	public static void main(String[] args) {
		SelectMaxPageSize s = new SelectMaxPageSize();
		List<CommodityUtil> allCommodity = s.allCommodity(1, 1);
		for (CommodityUtil commodity : allCommodity) {
			System.out.println("我的商品集合："+commodity);
		}
	}
}
