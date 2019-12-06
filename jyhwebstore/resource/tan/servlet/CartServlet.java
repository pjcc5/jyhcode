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

import chao.service.AddressService;
import pojo.Acount;
import pojo.Address;
import pojo.Orderform;
import net.sf.json.JSONArray;
import tan.dao.CartDao;
import tan.dao.ExDetailDao;
import tan.dao.impl.CartDaoImpl;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dto.Cart;
import tan.dto.ProductInformation;
import tan.servers.CartServers;
import dao.OrderformDao;
import dao.impl.OrderformDaoImpl;
import db.DbHelp;
import db.DbHelp2;
import dto.OrderDetailDto;

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
           }
           String action=request.getParameter("action");
           if(action.equals("init")){
		
		List<Cart> list=null;
		   
			list=new CartServers().selecCart(aid);
		
			JSONArray obj= JSONArray.fromObject(list);
			
			out.print(obj);
           }
           
           
           
           
           
           
           
           
           
           if(action.equals("stock")){
           Connection conn =DbHelp.getConnection();
           try {
        	   conn.setAutoCommit(false);
        	   CartServers dao1=new CartServers();
               List<Cart> list1=dao1.selecCart(aid);
               String name="";
               boolean flag=true;
           	for(int i=0;i<list1.size();i++){
    			if(list1.get(i).getSelected()==1){
    			String comid=list1.get(i).getComid();
    			int num=list1.get(i).getCount();
    			ExDetailDao dao=new ExDetailsByComidImpl();
    			ProductInformation pro=	dao.getDetailsByComid(comid, conn);
    			if(pro.getDetailsstock()<num){
    				System.out.println(pro.getDetailsstock());
    				flag=false;
    				name=name+pro.getComname()+" 库存:"+pro.getDetailsstock()+";";
    			
    			}else{
    				dao.updateSaleByComid(comid, conn, num);
    			}
    			}
    		}
           	conn.rollback();
           	if(flag){
           		out.print("no");
           	}else{
           		out.print(name);
           	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbHelp.closeConnection(conn);
		}
           }
          
           
           
           
           if(action.equals("buyagin")){
        	   String orderid=request.getParameter("orderid");
               Connection conn =DbHelp2.getConnection();
               try {
            	   conn.setAutoCommit(false);
            	   OrderformDao order=new OrderformDaoImpl();
            	 List<OrderDetailDto> list1= order.getComidsByOrderId(orderid, conn);
                   
                   String name="";
                   boolean flag=true;
               	for(int i=0;i<list1.size();i++){
        			
        			String comid=list1.get(i).getComid();
        			int num=list1.get(i).getComcount();
        			ExDetailDao dao=new ExDetailsByComidImpl();
        			ProductInformation pro=	dao.getDetailsByComid(comid, conn);
        			if(pro.getDetailsstock()<num){
        				System.out.println(pro.getDetailsstock());
        				flag=false;
        				name=name+pro.getComname()+" 库存:"+pro.getDetailsstock()+";";
        			
        			}else{
        				dao.updateSaleByComid(comid, conn, num);
        				
        			}
        			conn.rollback();
        		}
               	
               	if(flag){
               		out.print("no");
               	}else{
               		out.print(name);
               	}
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}finally{
    			DbHelp.closeConnection(conn);
    		}
               }
              
	
	}

}
