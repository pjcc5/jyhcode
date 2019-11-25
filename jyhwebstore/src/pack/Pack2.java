package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import db.DbHelp2;

public class Pack2 {
	
	static final Logger log =Logger.getLogger(Pack2.class);
	public static void main(String[] args) {
		Connection conn = DbHelp2.getConnection();
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
			System.out.println(i);
			String url = arr.get(i);
			try {
				Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
				//获取商品名称
				if(doc.select("#productMainName").size()==0)
				{
					continue;
				}
				String productname =  doc.select("#productMainName").get(0).html();
				
				//获取商品价格
				Element productprice = doc.select(".tab_price").get(0);
				
				//获取商品颜色
				String productcolor = doc.select(".item").select(".selected").attr("title");
				//获取商品品牌
				String productbrand = getgoodsbrand(productname);
				//获取商品小图以及图片
				ArrayList<String> goodsimgs = new ArrayList<String>();
				ArrayList<String> finalgoodsimgs = new ArrayList<String>();
				Elements el1 = doc.select(".mbox").select("b");
				
//				System.out.println("https://img10.360buyimg.com/n1/s50x50_"+el1.get(0).select("img").attr("original_src"));
//				System.out.println(el1.size());
				for (int j = 0; j < el1.size(); j++) {
					goodsimgs.add("https://img10.360buyimg.com/n1/s50x50_"+el1.get(j).select("img").attr("original_src"));
					
				}
				
				if(goodsimgs.size() >= 5)
				{
					for (int j = 0; j < 5; j++) {
						finalgoodsimgs.add(goodsimgs.get(j));
					}
				}else
				{
					for(int j = 0; j <5 ; j++) {
						if(j==5)
						{
							break;
						}
						if(j<=goodsimgs.size()-1)
						{
							finalgoodsimgs.add(goodsimgs.get(j));
						}else{
							finalgoodsimgs.add("");
						}
					}
				}
//				for (String str : finalgoodsimgs) {
//					System.out.println(str);
//				}
//				
				log.debug("商品名:"+productname);
				log.debug("商品品牌:"+productbrand);
				log.debug("商品价格:"+arr2.get(i));
				log.debug("商品颜色:"+productcolor);
				
				//插入商品表
				Commodity comm = new Commodity();
				String comid =UUID.randomUUID().toString();//设置统一商品id
				comm.setComid(comid);
				comm.setComname(productname);
				comm.setCompic(finalgoodsimgs.get(0));
				comm.setComdetails(comid);
				comm.setComprice(Double.parseDouble(arr2.get(i)));
				comm.setComclass("手机");
//				
//				
				//插入商品详情表
				Details dt =new Details();
				dt.setDetailsid(comid);
				dt.setDetailsstock(200);//库存
				dt.setDetailsprice(Double.parseDouble(arr2.get(i)));//单价
				dt.setDetailsdrawing(finalgoodsimgs.get(0));//详细图
				dt.setDetailsdot(0);//点赞数
				dt.setDetailssale(0);//已经卖出了多少件
				
				//插入图片连接表
				Compic com = new Compic();
				com.setComid(comid);
				com.setPicurl1(finalgoodsimgs.get(0));
				com.setPicurl2(finalgoodsimgs.get(1));
				com.setPicurl3(finalgoodsimgs.get(2));
				com.setPicurl4(finalgoodsimgs.get(3));
				com.setPicurl5(finalgoodsimgs.get(4));
				
				
				
				CommodityDao commdao =new CommodityDaoImpl();
				DetailsDao dd =new DetailsDaoImpl();
				CompicDao cd =new CompicDaoImpl();
				
				Connection conn = DbHelp2.getConnection();
				commdao.insertCommodity(comm, conn);
				System.out.println(conn);
				System.out.println(dd.insertDetails(dt, conn));
				System.out.println(cd.insertCompic(com, conn));
				
				try {
					if(!conn.isClosed())
					{
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("插入"+i+"次");
				
				
				
				
				
				
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
			if(secondblank == -1)
			{
				brandname = nofirstblank.substring(0,firstblank);
			}else{
				
				brandname = nofirstblank.substring(0,secondblank);
			}
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
