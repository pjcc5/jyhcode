package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjcDetailsDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tan.dto.ProductInformation;
import tan.servers.ProductDetail;
import db.DbHelp;
import dto.IndexGoodsDto;

public class AdvServlet extends HttpServlet {

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
		System.out.println("进人ADVservlet");
		 PrintWriter out= response.getWriter();
			String msg = request.getParameter("msg");
			System.out.println("msg="+msg);
			Connection conn=DbHelp.getConnection();
			PjcDetailsDao dao=new PjcDetailsDaoImpl();
			List<IndexGoodsDto> list;
			try {
				list = dao.getfifdetailorderydot(1, conn);
				DbHelp.closeConnection(conn);
				
				JSONArray object = JSONArray.fromObject(list);
				
				 System.out.println("进入productservlet"+object);
				 out.print(object.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
