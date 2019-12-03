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
		if(acount!=null){
		String aid=acount.getAid();}
		String action = request.getParameter("action");
		if(action.equals("query")){
		PrintWriter out = response.getWriter();
		 List<Address> list = AddressService.getAddressByAid("463ce3c5-52c0-40e5-8750-187b7ef5b33a");
		 if(list!=null){
		 JSONArray ja = JSONArray.fromObject(list);
		 System.out.println(ja);
		 out.print(ja.toString());}else{
			 out.print(false);
		 }
		 
		
		}
		
		if(action.equals("update")){
			
		String data=	request.getParameter("msg");
		JSONObject object=JSONObject.fromObject(data);
		Connection conn=DbHelp2.getConnection();
		AddressDao dao=new AddressDaoImpl();
		
		try {
			
			String oldflag=object.getString("oldflag");
			System.out.println(oldflag);
		if(!oldflag.equals("")){
		Address address=dao.getAddressByAddressid(oldflag, conn);
	    dao.changeDefault(address.getAddressid(), 0, conn);
	}
		Address address1=dao.getAddressByAddressid(object.getString("newflag"), conn);
		
		dao.changeDefault(address1.getAddressid(), 1, conn);
		
		
		System.out.println(object);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbHelp2.closeConnection(conn);
		}
		
		if(action.equals("insert")){
			String data=	request.getParameter("msg");
			JSONObject object=JSONObject.fromObject(data);
			
			Address address=new Address();
			address.setAddressid(UUID.randomUUID().toString());
			address.setAid("463ce3c5-52c0-40e5-8750-187b7ef5b33a");
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
			
			Connection conn=DbHelp2.getConnection();
			AddressDao dao=new AddressDaoImpl();
			try {
				dao.insertAddress(address, conn);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			DbHelp2.closeConnection(conn);
			
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
			
			Connection conn=DbHelp2.getConnection();
			AddressDao dao=new AddressDaoImpl();
			try {
				System.out.println(dao.modifyAdd(address, conn));;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbHelp2.closeConnection(conn);
			
		}
		
		if(action.equals("delete")){
			Connection conn=DbHelp2.getConnection();
			AddressDao dao=new AddressDaoImpl();
			String data=	request.getParameter("msg");
			JSONObject object=JSONObject.fromObject(data);
			String addressid=object.getString("flag");
			try {
				dao.deleteAddress(addressid, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbHelp2.closeConnection(conn);
		}
		
		
		 
		
	}

	public void init() throws ServletException {
	}

}
