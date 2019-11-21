package chao.pack;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Pack {
	public void getContent(String url){
		try {
			
				url="https://search.yhd.com/c0-0-1005412/";
				Document doc = Jsoup.connect(url).ignoreContentType(true).get();
				
				Elements goods = doc.select("div[class=mod_search_pro]");
				//循环向下查找
				for (Element element : goods) {
					Element e1 = element.select("div[class=itemBox]").get(0);
					//获取商品名称
					Element e2 = e1.select(".proName").get(0);
					Element e3 = e2.select(".mainTitle").get(0);
					System.out.println(e3.attr("title"));
				}
				
				
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
