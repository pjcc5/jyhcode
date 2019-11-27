package chao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import chao.dao.PjcCommodityDao;
import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjCommodityDaoImpl;
import chao.dao.impl.PjcDetailsDaoImpl;
import chao.service.LoadMoreGoodsService;
import dto.IndexGoodsDto;

public class LoadGoods extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoadGoods() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//拿到前端传过来的页数
		int page = Integer.parseInt(request.getParameter("page"));
		//定义一个输出流
		PrintWriter out = response.getWriter();
		List<IndexGoodsDto> list = LoadMoreGoodsService.getmore(page);
		JSONArray ja = JSONArray.fromObject(list);
		out.print(ja.toString());
		
		
		
		System.out.println("进入了loadmorgoods");
		
		
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
