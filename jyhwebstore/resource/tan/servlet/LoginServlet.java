package tan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.soft.web.encryption.Encryption;
import net.sf.json.JSONObject;
import pojo.Acount;
import service.loginService;

import tan.dao.loginDao;
import tan.dao.impl.loginDaoImpl;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入登录servlet");
		String msg = request.getParameter("msg");
		System.out.println(msg);
		JSONObject object = JSONObject.fromObject(msg);
		 PrintWriter out= response.getWriter();
		String uname=object.getString("uname");
		String upass=object.getString("upass");
		//将密码加密传到service层
		Encryption key = new Encryption();
		try {
			upass=key.getKey(upass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//================
		Connection conn=db.DbHelp.getConnection();
		loginService loginservice=new loginService();
		Acount acount=loginservice.login(uname, upass, conn);
		JSONObject returnObject=null;
		if(acount!=null){
	acount.setAddr(request.getRemoteAddr());
	request.getSession().setAttribute("acount", acount);
	returnObject =  JSONObject.fromObject(acount);
	}
		out.print(returnObject);
	}
      
}
