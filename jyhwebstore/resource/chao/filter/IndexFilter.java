package chao.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Details;
import chao.service.IndexInitService;

public class IndexFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//进入主页就要去数据库查询热门商品以及前50条数据
		//接下来写Service层的查询50条记录的方法
		IndexInitService iis =new IndexInitService();
		List<Details> details =  iis.getIndexProducts();
		for (Details details2 : details) {
			details2.setDetailsdrawing(details2.getDetailsdrawing().replace("50x50", "220x220"));
		}
		//将查到的数据存入到session中
		HttpSession session =  request.getSession();
		session.setAttribute("goods", details);
		
		//放行
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}
