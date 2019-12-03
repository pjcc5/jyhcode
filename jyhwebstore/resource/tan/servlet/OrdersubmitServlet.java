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

import net.sf.json.JSONArray;
import pojo.Acount;
import pojo.Address;
import tan.dao.CartDao;
import tan.dao.impl.CartDaoImpl;
import tan.dto.Cart;
import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import db.DbHelp2;

public class OrdersubmitServlet extends HttpServlet {

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
		
		System.out.println("========进入ordersubmitservlet=============");
		AddressDao dao=new AddressDaoImpl();
		CartDao dao1=new CartDaoImpl();
		Acount acount=(Acount) request.getSession().getAttribute("acount");
		String aid="";
		if(acount!=null){
			aid=acount.getAid();
		}
		Connection conn= DbHelp2.getConnection();
		String msg="";
				request.getParameter("msg");
				
		if(msg!=null){
		try {
			List<Address> address=dao.getAddressByAid("463ce3c5-52c0-40e5-8750-187b7ef5b33a", conn);
			List<Cart> list1=dao1.SelectCart(aid, conn);
			List<Cart> cart=new ArrayList<>();
			for(int i=0;i<list1.size();i++){
				if(list1.get(i).getSelected()==1){
					cart.add(list1.get(i));
				}
			}
			
			List<Object> list=new ArrayList<>();
			list.add(address);
			list.add(cart);
			PrintWriter out=response.getWriter();
			JSONArray arry=JSONArray.fromObject(list);
			out.print(arry.toString());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		

	}

}
