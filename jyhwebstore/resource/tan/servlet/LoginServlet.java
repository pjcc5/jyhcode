package tan.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tan.PersonInfo;

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
		
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		if(uname.equals("张三")){
	PersonInfo person=	new PersonInfo();
	person.setAccount(request.getParameter("uname"));
	person.setLoginDate(new Date());
	person.setIp(request.getRemoteAddr());
	System.out.println(request.getSession());
	request.getSession().setAttribute("personInfo", person);
	request.getRequestDispatcher("/store/html/operation/show.jsp").forward(request, response);	

	}else{
		response.sendRedirect("/jyhwebstore/store/html/login.jsp");
	}
	}
      
}
