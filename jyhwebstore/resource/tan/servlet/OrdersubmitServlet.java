package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chao.dao.OrderFormDao;
import chao.service.AddressService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Acount;
import pojo.Address;
import pojo.Commodity;
import pojo.Orderform;
import pojo.Ordermiddle;
import sun.jdbc.odbc.OdbcDef;
import tan.dao.CartDao;
import tan.dao.ExDetailDao;
import tan.dao.impl.CartDaoImpl;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dto.Cart;
import tan.servers.CartServers;
import tan.servers.OrdersubmitServes;
import util.StringOrArray;
import dao.AddressDao;
import dao.CommodityDao;
import dao.DetailsDao;
import dao.OrderMiddleDao;
import dao.OrderformDao;
import dao.impl.AddressDaoImpl;
import dao.impl.CommodityDaoImpl;
import dao.impl.OrderMiddleDaoImpl;
import dao.impl.OrderformDaoImpl;
import db.DbHelp;
import db.DbHelp2;
import dto.OrderDetailDto;

public class OrdersubmitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("========进入ordersubmitservlet=============");

		CartServers dao1=new CartServers();
		Acount acount=(Acount) request.getSession().getAttribute("acount");
		PrintWriter out=response.getWriter();
		String aid="";
		if(acount!=null){
			aid=acount.getAid();
		}

		String msg=request.getParameter("msg");
		String uuid1=request.getParameter("uuid");
		String orderid=request.getParameter("orderid");
		if(!"".equals(orderid)){
			OrdersubmitServes orderserves=new OrdersubmitServes();
			List<Object> addranddetail=orderserves.getAddrAnddetai(aid, orderid);
			
			
				List<Address> address=(List<Address>) addranddetail.get(0);
				List<OrderDetailDto> list= (List<OrderDetailDto>) addranddetail.get(1);
				List<Cart> list1=new ArrayList<>();
				for(int i=0;i<list.size();i++){
				OrderDetailDto dto=	list.get(i);
				Cart cart=new Cart();
				cart.setColor(dto.getColor());
				cart.setComid(dto.getComid());
				cart.setComname(dto.getComname());
				cart.setCompic(dto.getCompic());
				cart.setComprice(new Double(dto.getComprice()).intValue() );
				cart.setCount(dto.getComcount());
				cart.setDate(new Date());
				cart.setSelected(1);
				cart.setShopid("");
				cart.setSize(dto.getSize());
				cart.setUuid("");
				list1.add(cart);
				}
				
				List<Object> list3=new ArrayList<>();
				list3.add(address);
				list3.add(list1);
				
				JSONArray arry=JSONArray.fromObject(list3);
				out.print(arry.toString());
			
		}
		
		
		if(msg!=null&&"".equals(orderid)){
		

			List<Address> address=new AddressService().getAddressByAid(aid);
			List<Cart> cart=new ArrayList<>();
			if(msg.equals("")){
			List<Cart> list1=dao1.selecCart(aid);
			
			for(int i=0;i<list1.size();i++){
				if(list1.get(i).getSelected()==1){
					cart.add(list1.get(i));
				}
			}
			}else{
				String number=request.getParameter("num");
				int num=1;
				if(number!=null){
					num=Integer.parseInt(number);
				}
				
			
				Commodity good=new OrdersubmitServes().getCommodityById(msg);
				Cart c=new Cart();
				c.setColor(good.getColor());
				c.setComid(msg);
				c.setComname(good.getComname());
				c.setCompic(good.getCompic());
				c.setComprice(new Double(good.getComprice()).intValue());
				c.setCount(num);
				c.setDate(new Date());
				c.setSelected(1);
				c.setSize(good.getSize());
				c.setUuid("");
				cart.add(c);
				
			}
			
			List<Object> list=new ArrayList<>();
			list.add(address);
			list.add(cart);
			
			JSONArray arry=JSONArray.fromObject(list);
			out.print(arry.toString());
			
			
			

		}
		
		
		
		
		
		if(uuid1!=null&&!uuid1.equals("")){
			
              
			String[] uuid=StringOrArray.getArray(uuid1);
			
		 List<Cart> list = dao1.selecCart(aid);
		 for(int i=0;i<uuid.length;i++){
			 for(int j=0;j<list.size();j++){
			 if(uuid[i].equals(list.get(j).getUuid())){
				 String comid=list.get(j).getComid();
				 int num=list.get(j).getCount();

				 new OrdersubmitServes().updateSaleByComid(comid, num);
				 list.remove(j);
			 }
			 }
		 }
		 dao1.UpdateCart(list,  aid);
		}
		
		String orderform=request.getParameter("orderform");
		
             if(orderform!=null){
            	 JSONObject object=JSONObject.fromObject(orderform);
            	 String name=object.getString("name");
            	 String call=object.getString("call");
            	 String address=object.getString("address");
            	 String ordernumber=object.getString("ordernum");
            	 double total=object.getDouble("price");
            	  JSONArray object1= JSONArray.fromObject( object.get("goods"));
            	  
            	  Ordermiddle middle=new Ordermiddle();
        		  middle.setAid(aid);
        		  middle.setOrderid(ordernumber);

        		  new OrdersubmitServes().insertOrdermiddle(middle);
            	  for(int i=0;i<object1.size();i++){
            		  JSONObject json= (JSONObject) object1.get(i);
            		  double price=json.getDouble("comprice");
            		  int count=json.getInt("count");
            		  String size=json.getString("size");
            		  String color=json.getString("color");
            		  String comname=json.getString("comname");
            		  String comid=json.getString("comid");
            		  
            		  Orderform form=new Orderform();
            		  form.setAid(aid);
            		  form.setComcount(count);
            		  form.setComid(comid);
            		  form.setComname(comname);
            		  form.setOrderadd(address);
            		  form.setOrderdate(new Date());
            		  form.setOrderid(ordernumber);
            		  form.setOrderpay(1);
            		  form.setOrderphone(call);
            		  form.setOrderstatement(3);
            		  form.setOrderprice(price);
            		  form.setOrdername(name);

            		  new OrdersubmitServes().insertOrderform(form);
            		  
            	  }
            	
                   
                 
      
             }

	}

}
