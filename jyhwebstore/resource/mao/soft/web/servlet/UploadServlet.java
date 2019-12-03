package mao.soft.web.servlet;

import java.io.FileOutputStream;
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
import sun.misc.BASE64Decoder;
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
		String picture = request.getParameter("picture");
		Acount acount = (Acount)request.getSession().getAttribute("acount");
		if(picture!=null)
		{
			//解码图片并上传
			int index = picture.indexOf(",");
			picture = picture.substring(index+1);
			System.out.println("我的图片："+picture);
			String path = this.getServletContext().getRealPath("/")+"upload/";
			System.out.println("我的图片保存路径："+path);
			BASE64Decoder decoder = new BASE64Decoder();
			byte [] b = decoder.decodeBuffer(picture);
			FileOutputStream fos = new FileOutputStream(path+acount.getAid()+".jpg");
			fos.write(b);
			fos.flush();
			fos.close();
			System.out.println("上传完毕！");
		}
		else
		{
			picture="nulls";
		}
		try {
			//将值传入user对象
			User user = new User();
			String pic =acount.getAid()+".jpg";
			user.setUname(uname);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");System.out.println(ubirth);
			Date date = sdf.parse(ubirth);
			System.out.println(date.toLocaleString());
			user.setBirth(date);
			user.setSex(usex);
			user.setUphone(uphone);
			user.setPic(pic);
			user.setAid(acount.getAid());
			user.setMail(umail);
			user.setSetadd(uadd);
			System.out.println("数据库的时间："+ubirth+"==========="+"页面修改的时间："+user.getBirth());
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
		
	public void init() throws ServletException {
		
	}

}
