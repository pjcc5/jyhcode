package tan.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter{
	private String oldEncoding = null;
	private String newEncoding = null;
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("进入字符转码过滤器");
		//强转成HTTP协议
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//转码
		String method = request.getMethod();
		if("POST".equalsIgnoreCase(method)){
			request.setCharacterEncoding(newEncoding);
		}else{
			Map<String,String[]> maps = request.getParameterMap();
			Iterator<String[]> it = maps.values().iterator();
			while(it.hasNext()){
				String[] strs = it.next();
				for (int i = 0; i < strs.length; i++) {
					strs[i] = new String(strs[i].getBytes(oldEncoding),newEncoding);
				}
			}
		}
		response.setCharacterEncoding(newEncoding);
		System.out.println("acount="+request.getSession().getAttribute("acount"));
		//取得是否有时间参数
		request.getSession().removeAttribute("time");
		if(request.getSession().getAttribute("acount")!=null)
		{	
			//如果没有登陆过就不显示上午好
			request.getSession().setAttribute("time", getTimelo());
		}
		//放行
		arg2.doFilter(request, response);
		System.out.println("放行完毕");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		oldEncoding = arg0.getInitParameter("oldEncoding");
		newEncoding = arg0.getInitParameter("newEncoding");
	}
	
	/*
	 * 根据时间判断上午下午中午
	 */
	public String getTimelo(){
		Date date = new Date();
		int hour = date.getHours();
		if(hour>=5 && hour<8)
		{
			return "早上好";
		}else if(hour >=8 && hour < 12)
		{
			return "上午好";
		}else if(hour >= 12 && hour <14)
		{
			return "中午好,要注意午休呦(＾Ｕ＾)ノ~ＹＯ";
		}else if(hour >= 14 && hour <17)
		{
			return "下午好";
		}else if(hour >= 17 && hour < 19)
		{
			return "傍晚好";
		}else if(hour >= 19 && hour < 23)
		{
			return "晚上好";
		}else{
			return "我不想做夜猫子";
		}
	}
	
//	//获取当前时间的方法
//	public String getCurrent(){
//		Date date = new Date();
//		return 
//	}
}
