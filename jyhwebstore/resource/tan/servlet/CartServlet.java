package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Acount;
import net.sf.json.JSONArray;
import tan.dao.CartDao;
import tan.dao.impl.CartDaoImpl;
import tan.dto.Cart;
import tan.servers.CartServers;
import db.DbHelp;
import db.DbHelp2;

public class CartServlet extends HttpServlet {

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
		 String aid=null;
           Acount acount=(Acount) request.getSession().getAttribute("acount");
           PrintWriter out=response.getWriter();
           if(acount!=null){
            aid=acount.getAid();
           
		
		List<Cart> list=null;
		   Connection conn=  DbHelp.getConnection();
			list=new CartServers().selecCart(aid, conn);
			DbHelp.closeConnection(conn);
			JSONArray obj= JSONArray.fromObject(list);
			
			out.print(obj);
           }else{
        	   out.print(false);
           }

	
	}

}
