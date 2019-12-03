package mao.soft.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.soft.web.dateuti.UserDate;
import mao.soft.web.servlet.service.User_information;
import net.sf.json.JSONObject;
import pojo.Acount;
import pojo.User;

public class ShowUserDetails extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowUserDetails() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Acount acount= (Acount)request.getSession().getAttribute("acount");
		String aid =acount.getAid();
		User_information userinfor = new User_information();
		try {
			User user = userinfor.selectUserByAid(aid);
			Date births = (Date)user.getBirth();
			user.setBirth(births);
			System.out.println("性别："+"".equalsIgnoreCase(user.getSex()));
			if("".equalsIgnoreCase(user.getMail()))
			{
				user.setMail("nulls");
			}
			if("".equalsIgnoreCase(user.getPic()))
			{
				user.setPic("nulls");
			}
			if("".equalsIgnoreCase(user.getSetadd()))
			{
				user.setSetadd("nulls");
			}
			if("".equalsIgnoreCase(user.getSex()))
			{
				user.setSex("nulls");
			}
			
			String pic = user.getPic();
			pic =  request.getContextPath()+"/upload/"+pic;
			request.getSession().setAttribute("pic", pic);
			System.out.println("图片路径show:"+pic);
			//帮助类，重写user中的birth属性，将原来的date属性改为String属性，方便传到前端
			UserDate udate = new UserDate();
			udate.setAid(user.getAid());
			udate.setBirth(user.getBirth().toString());
			udate.setMail(user.getMail());
			udate.setPic(pic);
			udate.setSetadd(user.getSetadd());
			udate.setSex(user.getSex());
			udate.setUname(user.getUname());
			udate.setUphone(user.getUphone());
			JSONObject users = JSONObject.fromObject(udate);
			PrintWriter out = response.getWriter();
			out.print(users.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
