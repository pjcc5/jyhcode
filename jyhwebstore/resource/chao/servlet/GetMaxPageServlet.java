package chao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chao.service.SearchGoodsService;

public class GetMaxPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetMaxPageServlet() {
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
		//获取最大页数并存入到session中
		String content = request.getParameter("content");
		int maxpage = SearchGoodsService.getMaxpage(content);
		PrintWriter out = response.getWriter();
		out.print(maxpage);
		out.close();
				
	}

	public void init() throws ServletException {
	}

}
