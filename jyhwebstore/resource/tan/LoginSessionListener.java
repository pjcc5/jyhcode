package tan;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;



public class LoginSessionListener implements HttpSessionAttributeListener{

	


	
		Map<String, HttpSession> map = new HashMap<String, HttpSession>();

		public void attributeAdded(HttpSessionBindingEvent event) {
			
			
			System.out.println("add");
			String name = event.getName();
			
			


			if (name.equals("personInfo")) {

				PersonInfo personInfo = (PersonInfo) event.getValue();

				if (map.get(personInfo.getAccount()) != null) {

					
					HttpSession session = map.get(personInfo.getAccount());
					PersonInfo oldPersonInfo = (PersonInfo) session.getAttribute("personInfo");
					System.out.println("帐号" + oldPersonInfo.getAccount() + "在" + oldPersonInfo.getIp() + "已经登录，该登录将被迫下线。");
					session.removeAttribute("personInfo");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
				}

				
				map.put(personInfo.getAccount(), event.getSession());
				System.out.println("帐号" + personInfo.getAccount() + "在" + personInfo.getIp() + "登录。");
				System.out.println(map.size());
			}
			
		}

		public void attributeRemoved(HttpSessionBindingEvent event) {

			String name = event.getName();

			// ע��
			if (name.equals("personInfo")) {
				
				PersonInfo personInfo = (PersonInfo) event.getValue();
				map.remove(personInfo.getAccount());
				System.out.println("帐号" + personInfo.getAccount() + "注销。");
				
			}
		}

		public void attributeReplaced(HttpSessionBindingEvent event) {

			String name = event.getName();

			
			if (name.equals("personInfo")) {

				
				PersonInfo oldPersonInfo = (PersonInfo) event.getValue();
				map.remove(oldPersonInfo.getAccount());

			
				PersonInfo personInfo = (PersonInfo) event.getSession().getAttribute("personInfo");

			
				if (map.get(personInfo.getAccount()) != null) {
					
					HttpSession session = map.get(personInfo.getAccount());
					session.removeAttribute("personInfo");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");

				}
				map.put(personInfo.getAccount(), event.getSession());
			}

		}


}
