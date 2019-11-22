package pack;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Pack2 {

	public static void main(String[] args) {
		for (int j = 1; j < 10; j++) {
			String url ="https://search.yhd.com/c15249-0-0/mbname-b/a-s1-v4-p"+j+"-price-d0-f0b-m1-rt0-pid-mid0-color-size-k/";
			try {
				System.out.println(url);
				Document doc = Jsoup.connect(url).ignoreContentType(true).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").timeout(30000).get();
				Elements goods = doc.select("div[class=mod_search_pro]");
				for (Element element : goods) {
					System.out.println(element.select("div").attr("comproid"));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	
}
