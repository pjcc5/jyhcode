package mao.soft.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import db.DbHelp;
import mao.soft.web.dao.MaoRegisterDao;
import mao.soft.web.dao.imp.MaoRegisterDaoImp;
import mao.soft.web.servlet.service.RegisterService;

public class Register extends HttpServlet {

	public Register() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aname = request.getParameter("rname");
		String aphone = request.getParameter("rphone");
		String apassword = request.getParameter("rpass");
		String clintCode = request.getParameter("valdation");
		String serverCode = request.getSession().getAttribute("code").toString();
		
		Connection conn = DbHelp.getConnection();
		MaoRegisterDao registerD = new MaoRegisterDaoImp();
		boolean f = true;
		try {
			System.out.println(f);
			f =registerD.selectPhoneIsExist(aphone, conn);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		RegisterService register = new RegisterService();
		System.out.println();
		if(f==true||!clintCode.equalsIgnoreCase(serverCode))
		{
			//返回一个false
			String flag = "{flag:"+"false"+"}";
			JSONObject fl = JSONObject.fromObject(flag);
			PrintWriter out = response.getWriter();
			out.print(fl.toString());
		}
		else {
//			返回一个true
			String flag = "{flag:"+"true"+"}";
			JSONObject flg = JSONObject.fromObject(flag);
			PrintWriter out = response.getWriter();
			out.print(flg.toString());
			RegisterService rs = new RegisterService();
			try {
				rs.register(aname, apassword, aphone);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void init() throws ServletException {

	}

}
