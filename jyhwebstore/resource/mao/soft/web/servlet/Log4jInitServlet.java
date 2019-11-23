package mao.soft.web.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Log4jInitServlet() {
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

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("......正在初始化配置文件......");
		String log4jLocation = config.getInitParameter("log4jInitLocation");
		ServletContext sc = config.getServletContext();
		System.out.println("我的sc:------"+sc);
		if (log4jLocation == null) {
			System.out.println("....配置初始化的配置文件....");
			BasicConfigurator.configure();
		}else
		{
			System.out.println("我的log4jLocation:-------"+log4jLocation);
			String webAppPath = sc.getRealPath("/");
			System.out.println("我的webAppPath:--------"+webAppPath);
			String log4jProp = webAppPath+log4jLocation;
			System.out.println("我的log4jPropPath:-------"+log4jProp);
			File file = new File(log4jProp);
			if (file.exists()) {
				System.out.println("使用:-------"+log4jProp+"初始化配信息文件");
				PropertyConfigurator.configure(log4jProp);
			}
			else {
				System.out.println("配置文件没有找到");
				BasicConfigurator.configure();
			}
		}
	}

}
