package mao.soft.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.soft.web.dateuti.CommodityUtil;
import mao.soft.web.service.SelectMaxPageSize;

public class ComiAdmiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915293016120767708L;

	public ComiAdmiServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectMaxPageSize max = new SelectMaxPageSize();
		//每次只显示五条数据
		int pageSize = 5;
		System.out.println("pageSize:==="+pageSize);
			//根据五条数据来分页，显示最大的页码数量
			int maxPageNu = max.maxPage(pageSize);
			//存最大的页码数量
			request.setAttribute("maxPageNo", maxPageNu);
			//给页码赋初始值
			int pageNo=1;
			//如果页码比1小了，就强制为1
			if(pageNo<2)
			{
				pageNo=1;
			}
			String no = request.getParameter("pageNo");
			if(no==null||"0".equals(no))
			{
				no="1";
			}
			//如果页码比最大的大，强制为最大
			pageNo = Integer.parseInt(no);
			if(pageNo>maxPageNu)
			{
				pageNo=maxPageNu;
			}
			//存当前的页码
			request.setAttribute("pageNo", pageNo);
			List<CommodityUtil> list = max.allCommodity(pageNo, pageSize);
			//存当前的集合
			request.setAttribute("list", list);
			//转发到页面
			request.getRequestDispatcher("/store/html/operation/design.jsp").forward(request, response);
	}

	public void init() throws ServletException {
	}

}
