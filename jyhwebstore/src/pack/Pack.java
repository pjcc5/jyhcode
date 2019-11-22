package pack;

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
				
					url="https://search.yhd.com/c0-0-1005412/#page="+i;
					Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(3000).post();
					
					Elements goods = doc.select("div[class=mod_search_pro]");
					//循环向下查找
					for (Element element : goods) {
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						Element e1 = element.select("div[class=itemBox]").get(0);
						//获取商品名称
						Element e2 = e1.select(".proName").get(0);
						if(e2.select(".mainTitle").size()!=0)
						{
							Element e3 = e2.select(".mainTitle").get(0);
							String goodsdetailurl ="https://"+ e3.attr("href").substring(2);
							System.out.println("详情:"+goodsdetailurl);
							String goodsname = e3.attr("title");
							
							System.out.println(goodsname);
							//获取商品品牌
							String goodsbrand = getgoodsbrand(goodsname);
							System.out.println("品牌:"+goodsbrand);
							//获取商品价格
							Element e4 =  e1.select(".proPrice").get(0).select(".num").get(0);
							String price = e4.attr("yhdprice");
							System.out.println("价格:"+price);
							//获取商品图片
							Elements imgs = e1.select("div[class=proImg]").get(0).select("a[class=img]").get(0).select("img");
//							System.out.println("总共照片数:"+imgs.size());
							Element img = imgs.get(0);
							String  imgurl="";
							if("".equals(img.attr("src")))
							{	
								imgurl = img.attr("original").substring(2);
								
							}else{
								imgurl = img.attr("src").substring(2);
							}
							count++;
							System.out.println("地址:"+imgurl);
							
							//获取商品颜色
							//进入详情页
							Document detaildoc = Jsoup.connect(goodsdetailurl).ignoreContentType(true).post();
							Element colorfather = detaildoc.select("#choose-attr-1").get(0);
							String color = colorfather.select(".dd").select(".selected").attr("title");
							
							System.out.println(color);
							
						}
						
					}
					System.out.println("count:"+count);
				}
				
				 
				
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public String getgoodsbrand(String goodsname)
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
