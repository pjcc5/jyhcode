package chao.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Commodity;
import chao.service.IndexInitService;
import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import db.DbHelp2;
import dto.IndexGoodsDto;

public class IndexFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//进入主页就要去数据库查询热门商品以及前50条数据
		//接下来写Service层的查询50条记录的方法
		IndexInitService iis =new IndexInitService();
		List<IndexGoodsDto> details =  iis.getIndexProducts();
		@SuppressWarnings("unused")
		List<Commodity> comms =new ArrayList<Commodity>();
		List<IndexGoodsDto> dtos =new ArrayList<IndexGoodsDto>();
		CommodityDao cmd =new CommodityDaoImpl();
		Connection conn =DbHelp2.getConnection(); 
		for (IndexGoodsDto details2 : details) {
			try {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//将查到的数据存入到session中
		HttpSession session =  request.getSession();
		session.setAttribute("igds", dtos);
		
		//放行
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}
