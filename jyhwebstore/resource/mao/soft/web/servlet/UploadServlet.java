package mao.soft.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.soft.web.service.ModifyUserDetails;
import net.sf.json.JSONObject;
import pojo.Acount;
import pojo.User;

public class UploadServlet extends HttpServlet {

	public UploadServlet() {
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
		//拿到键取得值
		String uname = request.getParameter("nickname");
		String ubirth = request.getParameter("userbirth");
		String usex = request.getParameter("usersex");
		String uphone = request.getParameter("userphone");
		String umail = request.getParameter("usermail");
		String uadd = request.getParameter("useraddress");
//		String aid = request.getAttribute("acount").toString();
		Acount acount = (Acount)request.getSession().getAttribute("acount");
		try {
			//将值传入user对象
			User user = new User();
			user.setUname(uname);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(ubirth);
			user.setBirth(date);
			user.setSex(usex);
			user.setUphone(uphone);
			user.setPic("");
			user.setAid(acount.getAid());
			user.setMail(umail);
			user.setSetadd(uadd);
			//调用service层的插入方法
			ModifyUserDetails userDe = new ModifyUserDetails();
			boolean flag = userDe.modifyUphoneAndUnameIsExist(user);
			if(flag==true)
			{
				String flags = "{flag:"+"true"+"}";
				JSONObject flg = JSONObject.fromObject(flags);
				PrintWriter out = response.getWriter();
				out.print(flg.toString());
				System.out.println("Upload修改成功");
			}
			else
			{
				String fl = "{error:"+"false"+"}";
				JSONObject fls = JSONObject.fromObject(fl);
				PrintWriter out = response.getWriter();
				out.print(fls.toString());
				System.out.println("Upload修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//			ModifyInformationUser insert = new ModifyInformationUser();
//			try {
//				boolean flag = insert.modifyInformation(user);
//				System.out.println(flag);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		Aid_Select selectAid = new Aid_Select();
//		try {
//			 aid = selectAid.selectAidByName(aid);
//			 User_information uinform = new User_information();
//			 if(aid!=null)
//			 {
//				 User user =  uinform.selectUserByAid(aid);
//				 if(user!=null)
//				 {
////					 String flag = "{flag:"+"true"+"}";
//					 JSONObject jsonUser = JSONObject.fromObject(user);
//					 System.out.println("我的jsonUser："+jsonUser);
//					 PrintWriter pt = response.getWriter();
//					 pt.print(jsonUser);
//				 }
//				 else
//				 {
//					 System.out.println("系统错误！");
////					 String flag = "{flag:"+"false"+"}";
//				 }
//			 }else
//			 {
//				 System.out.println("系统错误！");
////				 String flag = "{flag:"+"false"+"}";
//			 }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		SmartUpload upload = new SmartUpload();
//		//初始化文件
//		upload.initialize(this.getServletConfig(), request, response);
//		//上传文件
//		try {
//			upload.upload();
//		} catch (SmartUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
