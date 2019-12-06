package chao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Acount;
import pojo.Address;
import chao.service.AddressService;
import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import db.DbHelp2;

public class AddressServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddressServlet() {
		super();
	}

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
		Acount acount=(Acount) request.getSession().getAttribute("acount");
		String aid="";
		if(acount!=null){
			aid = acount.getAid();
		}
		String action = request.getParameter("action");
		if(action.equals("query")){
		PrintWriter out = response.getWriter();
		 List<Address> list = AddressService.getAddressByAid(aid);
		 if(list!=null){
		 JSONArray ja = JSONArray.fromObject(list);
		 System.out.println(ja);
		 out.print(ja.toString());}else{
			 out.print(false);
		 }
		 
		
		}
		
		if(action.equals("update")){
			
			
		String data=request.getParameter("msg");
		JSONObject object=JSONObject.fromObject(data);
	
		System.out.println(data);
			String oldflag=object.getString("oldflag");
			AddressService addr= new AddressService();
		if(!oldflag.equals("")){
		addr.changeDefault(oldflag, 0);
	}
		String newflag=object.getString("newflag");
		if(newflag!=null||!"".equals(newflag)){
		addr.changeDefault(newflag, 1);}

		}
		
		if(action.equals("insert")){
			String data=request.getParameter("msg");
			JSONObject object=JSONObject.fromObject(data);
			
			Address address=new Address();
			address.setAddressid(UUID.randomUUID().toString());
			address.setAid(aid);
			address.setAddressdetail(object.getString("detailaddr"));
			address.setCounty(object.getString("countryhtml"));
			address.setCountyval(object.getString("countryval"));
			address.setIsdefault(0);
			address.setProval(object.getString("proval"));
			address.setProvince(object.getString("provhtml"));
			address.setRecivename(object.getString("username"));
			address.setRecivephone(object.getString("call"));
			address.setTown(object.getString("cityhtml"));
			address.setTownval(object.getString("cityval"));
			
//		
			AddressService addr= new AddressService();
			addr.insertAddress(address);
			
			PrintWriter out = response.getWriter();
			out.print(address.getAddressid());
			
		}
		
		
		if(action.equals("updateaddr")){
			System.out.println("updateaddr");
			
			String data=	request.getParameter("msg");
			JSONObject object=JSONObject.fromObject(data);
			System.out.println(object);
			Address address=new Address();
			address.setAddressid(object.getString("flag"));
			
			address.setAddressdetail(object.getString("detailaddr"));
			address.setCounty(object.getString("countryhtml"));
			address.setCountyval(object.getString("countryval"));
			address.setProval(object.getString("proval"));
			address.setProvince(object.getString("provhtml"));
			address.setRecivename(object.getString("username"));
			address.setRecivephone(object.getString("call"));
			address.setTown(object.getString("cityhtml"));
			address.setTownval(object.getString("cityval"));
			

			AddressService addr=new AddressService();
			addr.modifyaddr(address);
			
		}
		
		if(action.equals("delete")){

			AddressDao dao=new AddressDaoImpl();
			String data=	request.getParameter("msg");
			JSONObject object=JSONObject.fromObject(data);
			String addressid=object.getString("flag");

	
			AddressService addr=new AddressService();
			addr.deleteAddress(addressid);
		}
	}

	public void init() throws ServletException {
	}

}
