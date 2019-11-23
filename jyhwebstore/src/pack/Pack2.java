package pack;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Pack2 {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();//存放商品id
		ArrayList<String> array2 = new ArrayList<String>();//存放价格
		
		for (int j = 1; j < 10; j++) {
			String url ="https://search.yhd.com/c0-0-1005412/mbname-b/a-s1-v4-p"+j+"-price-d0-f0b-m1-rt0-pid-mid0-color-size-k/";
			try {
				
				System.out.println(url);
				Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
				Elements goods = doc.select("div[class=mod_search_pro]");
				for (Element element : goods) {
					array.add("https://item.yhd.com/"+element.select("div").attr("comproid")+".html");
					String price = element.select("div[class=itemBox]").get(0).select(".proPrice").get(0).select(".num").get(0).attr("yhdprice");
					array2.add(price);
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		soup(array,array2, 0);	
		
//		//拼接商品详情页面
//		System.out.println(array.size());//315
//		for (String string : array) {
//			String goodsdetailurl = "https://item.yhd.com/"+string+".html";
//			try {
//				Document doc = Jsoup.connect(goodsdetailurl).ignoreContentType(true).get();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
	}
	public static void soup(ArrayList<String> arr,ArrayList<String> arr2,int index)
	{
		for (int i = index; i < arr.size(); i++) {
			String url = arr.get(i);
			try {
				Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
				//获取商品名称
				
				String productname =  doc.select("#productMainName").get(0).html();
				
				//获取商品价格
				Element productprice = doc.select(".tab_price").get(0);
				
				//获取商品颜色
				String productcolor = doc.select(".item").select(".selected").attr("title");
				//获取商品品牌
				String productbrand = getgoodsbrand(productname);
				//获取商品小图以及图片
//				String product = 
				System.out.println("商品名:"+productname);
				System.out.println("商品品牌:"+productbrand);
				System.out.println("商品价格:"+arr2.get(i));
				System.out.println("商品颜色:"+productcolor);
				
				
				
				
			} catch (IOException e) {
				soup(arr,arr2, i+1);
			}			
			
		}
	}
	
	public static String getgoodsbrand(String goodsname)
	{	
		String brandname =null;
		int index = goodsname.indexOf("】");
		if(index == -1)
		{
			//说明这个字符串没有】
			//取得第一个空格所在的索引
			int blankindex = goodsname.indexOf(" ");
			brandname = goodsname.substring(0,blankindex);
			
		}else{
			//有】
			goodsname = goodsname.substring(index+1);
			int blankindex = goodsname.indexOf(" ");
			brandname = goodsname.substring(0,blankindex);
			
		}
		return brandname;
	}
	
}