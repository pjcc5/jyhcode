package tan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Acount;
import service.loginService;
import tan.PersonInfo;
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
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		Connection conn=db.DbHelp2.getConnection();
		loginService loginservice=new loginService();
		Acount acount=loginservice.login(uname, upass, conn);
		if(acount!=null){
			
	PersonInfo person=	new PersonInfo();
	person.setAccount(request.getParameter("uname"));
	person.setLoginDate(new Date());
	person.setIp(request.getRemoteAddr());
	
	request.getSession().setAttribute("acount", acount);
	request.getSession().setAttribute("personInfo", person);
	request.getRequestDispatcher("/store/html/operation/show.jsp").forward(request, response);	

	}else{
		response.sendRedirect("/jyhwebstore/store/html/login.jsp");
	}
	}
      
}
