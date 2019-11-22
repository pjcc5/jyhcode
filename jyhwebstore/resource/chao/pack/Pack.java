package chao.pack;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Pack {
	public void getContent(String url){
		try {	int count=0;
				for(int i=1;i<3;i++)
				{
					url="https://search.yhd.com/c0-0-1005412/#page="+i+"&sort=1";
					Document doc = Jsoup.connect(url).ignoreContentType(true).get();
					
					Elements goods = doc.select("div[class=mod_search_pro]");
					//ѭ�����²���
					for (Element element : goods) {
						Element e1 = element.select("div[class=itemBox]").get(0);
						//��ȡ��Ʒ����
						Element e2 = e1.select(".proName").get(0);
						if(e2.select(".mainTitle").size()!=0)
						{
							Element e3 = e2.select(".mainTitle").get(0);
							System.out.println(e3.attr("title"));
							//��ȡ��Ʒ�۸�
							Element e4 =  e1.select(".proPrice").get(0).select(".num").get(0);
							String price = e4.attr("yhdprice");
							System.out.println("�۸�:"+price);
							//��ȡ��ƷͼƬ
							Elements imgs = e1.select("div[class=proImg]").get(0).select("a[class=img]").get(0).select("img");
							System.out.println("�ܹ���Ƭ��:"+imgs.size());
							Element img = imgs.get(0);
							String  imgurl="";
							if("".equals(img.attr("src")))
							{	
								imgurl = img.attr("original").substring(2);
								
							}else{
								imgurl = img.attr("src").substring(2);
							}
							count++;
							System.out.println("��ַ:"+imgurl);
							
						}
						
					}
					System.out.println("count:"+count);
				}
				
				 
				
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
