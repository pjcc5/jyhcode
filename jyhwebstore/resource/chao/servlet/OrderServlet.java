package chao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Orderform;
import chao.service.OrderService;
import dto.InnerOrderDto;
import dto.OrderDto;

public class OrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		System.out.println("进入了orderservlet");
			String action = request.getParameter("action");
			
			PrintWriter out = response.getWriter();
			if(action != null)
			{
				if("getallbyid".equals(action))
				{	
					String aid = request.getParameter("aid");
					List<OrderDto>  list = OrderService.getAllOrderByAid(aid);
					JSONArray ja = JSONArray.fromObject(list);
					out.print(ja.toString());
				}
				
				if("getorderfrombyorderid".equals(action))
				{
					String orderid =  request.getParameter("orderid");
					if(orderid != null)
					{
						InnerOrderDto  iod = OrderService.getOrderCommodities(orderid);
						JSONArray ja = JSONArray.fromObject(iod);
						out.print(ja.toString());
					}
				}
			}
			
		
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
