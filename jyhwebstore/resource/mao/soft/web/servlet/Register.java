package mao.soft.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.soft.web.dao.MaoRegisterDao;
import mao.soft.web.dao.imp.MaoRegisterDaoImp;
import mao.soft.web.servlet.service.RegisterService;
import net.sf.json.JSONObject;
import db.DbHelp;

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
		//用户输入的验证码
		String clintCode = request.getParameter("valdation");
		//服务器端生成的验证码
		String serverCode = request.getSession().getAttribute("code").toString();
		
		Connection conn = DbHelp.getConnection();
		MaoRegisterDao registerD = new MaoRegisterDaoImp();
		boolean f = true;
		try {
			System.out.println(f);
			//根据手机号查用=用户是否存在
			f =registerD.selectPhoneIsExist(aphone,aname, conn);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(f==true)
		{
			//手机号或者用户名存在返回false
			String flag = "{flag:"+"false"+"}";
			JSONObject fl = JSONObject.fromObject(flag);
			PrintWriter out = response.getWriter();
			out.print(fl.toString());
		}
		else
		{
			if(clintCode.equalsIgnoreCase(serverCode))
			{
				//手机号和验证码都正确，返回true
				RegisterService rs = new RegisterService();
				try {
					boolean flags = rs.register(aname, apassword, aphone);
					if(flags)
					{
						String flag = "{flag:"+"true"+"}";
						JSONObject flg = JSONObject.fromObject(flag);
						PrintWriter out = response.getWriter();
						out.print(flg.toString());
						System.out.println("成功！");
					}
					else
					{
						String fl = "{error:"+"false"+"}";
						JSONObject fls = JSONObject.fromObject(fl);
						PrintWriter out = response.getWriter();
						out.print(fls.toString());
						System.out.println("插入失败------");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				//返回一个not
				String flag = "{valde:"+"false"+"}";
				JSONObject flg = JSONObject.fromObject(flag);
				PrintWriter out = response.getWriter();
				out.print(flg.toString());
			}
		}
	}
	public void init() throws ServletException {

	}

}
