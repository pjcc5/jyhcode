package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import db.DbHelp;
import pojo.Details;
import tan.dao.ExDetailDao;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dto.ProductInformation;
import tan.servers.ProductDetail;

public class ProductServlet extends HttpServlet {

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
		
		 PrintWriter out= response.getWriter();
		String msg = request.getParameter("msg");
		System.out.println("msg="+msg);
		ProductDetail dao=new ProductDetail();
		ProductInformation detail=null;
		Connection conn=DbHelp.getConnection();
		
			detail=dao.getProduct(msg, conn);
			DbHelp.closeConnection(conn);
		JSONObject object = JSONObject.fromObject(detail);
		
		 System.out.println("进入productservlet");
		 out.print(object.toString());
	

	}

}
