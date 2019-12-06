package mao.soft.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import mao.soft.web.service.DeleteCommodity;

public class DeleteCommodityServlet extends HttpServlet {

	public DeleteCommodityServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String comid = request.getParameter("comid");
			System.out.println(comid);
			DeleteCommodity deleteComm = new DeleteCommodity();
			boolean flag = deleteComm.deleteCommodity(comid);
			System.out.println(flag);
			if(flag==true)
			{
				String flags = "{flag:"+"true"+"}";
				JSONObject flg = JSONObject.fromObject(flags);
				PrintWriter out = response.getWriter();
				out.print(flg.toString());
				System.out.println("delete删除成功");
			}
			else{
				String flags = "{flag:"+"false"+"}";
				JSONObject flg = JSONObject.fromObject(flags);
				PrintWriter out = response.getWriter();
				out.print(flg.toString());
				System.out.println("delete删除失败");
			}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
