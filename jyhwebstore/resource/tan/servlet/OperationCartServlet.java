package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Acount;
import db.DbHelp;
import db.DbHelp2;
import tan.dao.CartDao;
import tan.dao.impl.CartDaoImpl;
import tan.dto.Cart;
import tan.servers.CartServers;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OperationCartServlet extends HttpServlet {

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
		System.out.println("进入opreationcartservlet");
		  int index=0;
	      String msg=request.getParameter("msg");
	      String detail=request.getParameter("detail");
	      System.out.println("detail="+detail);
	      System.out.println(msg);
	      
		Connection conn=DbHelp.getConnection();
		String aid=null;
		 Acount acount=(Acount) request.getSession().getAttribute("acount");
        if(acount!=null){
         aid=acount.getAid();
        }
        
        
        System.out.println(aid);
        CartServers dao=new CartServers();
        List<Cart> list=null;
		
			list = dao.selecCart(aid, conn);
			
		
	
		
        
		if(msg!=null){
		JSONObject object = JSONObject.fromObject(msg);
		
		String data=object.getString("data");
		int num=object.getInt("num");
		
		
		System.out.println("uuid="+data);
		
		 try {
			  
			
			for (int i=0;i<list.size();i++) {
		        Cart cart=list.get(i);
				System.out.println("cartuuid="+cart.getUuid());
				if(cart.getUuid().equals(data)){
					index=i;
					System.out.println("index="+i);
					if(num>0){
						
						
						list.get(index).setCount(num);
						System.out.println("num="+list.get(index).getCount());
						CartDaoImpl impl=new CartDaoImpl();
						System.out.println(impl.UpdateCart(list, conn,aid));
						
						
					}else{
	                     System.out.println("num="+num);
						list.remove(index);
						
						System.out.println(dao.UpdateCart(list, conn, aid));
					}
                            break;
				}
			
				
			}
			
			
			
			
//			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}else{
		
		JSONObject object=JSONObject.fromObject(detail);
		int num=object.getInt("num");
		
		String comname=(String) object.get("comname");
		int comprice=object.getInt("comprice");
		String picurl=(String) object.getJSONArray("picurl").get(0);
		String size=null;
		if(object.getJSONArray("size").size()>0){ size=(String) object.getJSONArray("size").get(0);}else{
			 size=" ";
		}
		String color=null;
		if(object.getJSONArray("color").size()>0){
			color=(String) object.getJSONArray("color").get(0);
		}else{
			 color=" ";
		}

	  Cart cart=new Cart();
	  cart.setColor(color);
	  cart.setComname(comname);
	  cart.setComprice(comprice);
	  cart.setCount(num);
	  cart.setDate(new Date());
	 
	  cart.setSize(size);
	  cart.setUuid(UUID.randomUUID().toString());
	  cart.setCompic(picurl);
     list.add(cart);
     CartDaoImpl impl=new CartDaoImpl();
     try {
    	 System.out.println(dao.UpdateCart(list, conn,aid));
    	 DbHelp.closeConnection(conn);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
		
	}
		PrintWriter out=response.getWriter();
		out.print(true);	
		
	}

}
