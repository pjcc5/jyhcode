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
import tan.dao.ExDetailDao;
import tan.dao.impl.CartDaoImpl;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dto.Cart;
import tan.servers.CartServers;
import util.StringOrArray;
import dao.AddressDao;
import dao.DetailsDao;
import dao.impl.AddressDaoImpl;
import db.DbHelp;
import db.DbHelp2;

public class OrdersubmitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("========进入ordersubmitservlet=============");
		AddressDao dao=new AddressDaoImpl();
		CartServers dao1=new CartServers();
		Acount acount=(Acount) request.getSession().getAttribute("acount");
		String aid="";
		if(acount!=null){
			aid=acount.getAid();
		}
		Connection conn= DbHelp2.getConnection();
		String msg=request.getParameter("msg");
		if(msg==null){
		try {
			List<Address> address=dao.getAddressByAid(aid, conn);
			List<Cart> list1=dao1.selecCart(aid, conn);
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
		
		if(msg!=null){
			
			System.out.println(msg);
			String[] uuid=StringOrArray.getArray(msg);
			
		 List<Cart> list = dao1.selecCart(aid, conn);
		 for(int i=0;i<uuid.length;i++){
			 for(int j=0;j<list.size();j++){
			 if(uuid[i].equals(list.get(j).getUuid())){
				 String comid=list.get(j).getComid();
				 int num=list.get(j).getCount();
				 ExDetailDao dao2=new ExDetailsByComidImpl();
				 try {
					 System.out.println("comid="+comid);
					System.out.println("更新销量"+dao2.updateSaleByComid(comid, conn, num));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 list.remove(j);
			 }
			 }
		 }
		 dao1.UpdateCart(list, conn, aid);
		}

		
		DbHelp.closeConnection(conn);
		


	}

}
