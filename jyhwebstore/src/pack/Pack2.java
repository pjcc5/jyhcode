package pack;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Pack2 {
	static final Logger log =Logger.getLogger(Pack2.class);
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();//存放商品id
		ArrayList<String> array2 = new ArrayList<String>();//存放价格
		
		for (int j = 1; j < 50; j++) {
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
				ArrayList<String> goodsimgs = new ArrayList<String>();
				Elements el1 = doc.select(".mbox").select("b");
				
//				System.out.println("https://img10.360buyimg.com/n1/s50x50_"+el1.get(0).select("img").attr("original_src"));
//				System.out.println(el1.size());
				for (int j = 0; j < el1.size(); j++) {
					goodsimgs.add("https://img10.360buyimg.com/n1/s50x50_"+el1.get(j).select("img").attr("original_src"));
					
				}
				
				for (String s  : goodsimgs) {
					System.out.println(s);
				}
//				
				log.debug("商品名:"+productname);
				log.debug("商品品牌:"+productbrand);
				log.debug("商品价格:"+arr2.get(i));
				log.debug("商品颜色:"+productcolor);
				
				
				
				
				
//				System.out.println("商品名:"+productname);
//				System.out.println("商品品牌:"+productbrand);
//				System.out.println("商品价格:"+arr2.get(i));
//				System.out.println("商品颜色:"+productcolor);
//				
				
				
				
			} catch (IOException e) {
				log.error(e.getStackTrace().toString());
				soup(arr,arr2, i+1);
			}			
			
		}
	}
	
	public static String getgoodsbrand(String goodsname)
	{	
		String brandname =null;
		String goodsname1= goodsname;
		//找到第一个空格所在索引
		int firstblank = goodsname1.indexOf(" ");
		//判断前面部分有没有】
		if(goodsname1.indexOf("】") ==-1)
		{
			//没有,就直接截取0-indexof
			brandname =goodsname1.substring(0,firstblank); 
		}else{
			//前面有,就找到第一个空格和第二个空格之间的内容
			//得到出去第一个空格后的字符串
			String nofirstblank = goodsname1.substring(firstblank+1);
			
			int secondblank =nofirstblank.indexOf(" ");
			brandname = nofirstblank.substring(0,secondblank);
		}
		
		
//		int index = goodsname.indexOf("】");
//		if(index == -1)
//		{
//			//说明这个字符串没有】
//			//取得第一个空格所在的索引
//			int blankindex = goodsname.indexOf(" ");
//			brandname = goodsname1.substring(0,blankindex);
//			
//		}else{
//			//有】
//			goodsname1 = goodsname1.substring(index+1);
//			int blankindex = goodsname1.indexOf(" ");
//			if(blankindex == -1)
//			{
//				brandname="";
//			}else{
//				
//				brandname = goodsname.substring(0,blankindex);
//			}
//			
//		}
		return brandname;
	}
	
}
