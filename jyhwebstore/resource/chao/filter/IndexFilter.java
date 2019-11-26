package chao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IndexFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//进入主页就要去数据库查询热门商品以及前50条数据
		//接下来写Service层的查询50条记录的方法
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}
