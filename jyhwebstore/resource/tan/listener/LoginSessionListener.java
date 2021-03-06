package tan.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import pojo.Acount;



public class LoginSessionListener implements HttpSessionAttributeListener{

	


	
		Map<String, HttpSession> map = new HashMap<String, HttpSession>();

		public void attributeAdded(HttpSessionBindingEvent event) {
			
			System.out.println("进入单态登录过滤器");
			String name = event.getName();
			
			


			if (name.equals("acount")) {

				Acount personInfo = (Acount) event.getValue();

				if (map.get(personInfo.getAname()) != null) {

					
					HttpSession session = map.get(personInfo.getAname());
					Acount oldPersonInfo = (Acount) session.getAttribute("acount");
					System.out.println("帐号" + oldPersonInfo.getAname() + "在" + oldPersonInfo.getAddr() + "已经登录，该登录将被迫下线。");
					session.removeAttribute("acount");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
				}

				
				map.put(personInfo.getAname(), event.getSession());
				System.out.println("帐号" + personInfo.getAname() + "在" + personInfo.getAddr() + "登录。");
				System.out.println(map.size());
			}
			
		}

		public void attributeRemoved(HttpSessionBindingEvent event) {

			String name = event.getName();

		
			if (name.equals("acount")) {
				
				Acount personInfo = (Acount) event.getValue();
				map.remove(personInfo.getAname());
				System.out.println("帐号" + personInfo.getAname() + "注销。");
			}
		}

		public void attributeReplaced(HttpSessionBindingEvent event) {

			String name = event.getName();

			
			if (name.equals("acount")) {

				
				Acount oldPersonInfo = (Acount) event.getValue();
				map.remove(oldPersonInfo.getAname());

			
				Acount personInfo = (Acount) event.getSession().getAttribute("acount");

			
				if (map.get(personInfo.getAname()) != null) {
					
					HttpSession session = map.get(personInfo.getAname());
					session.removeAttribute("acount");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");

				}
				map.put(personInfo.getAname(), event.getSession());
			}

		}


}
