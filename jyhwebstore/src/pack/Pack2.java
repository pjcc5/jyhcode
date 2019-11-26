package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.FetchProfile.Item;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import chao.dao.ClassesDao;
import chao.dao.ColorDao;
import chao.dao.CommodityDao;
import chao.dao.CompicDao;
import chao.dao.DetailsDao;
import chao.dao.SizeDao;
import chao.dao.impl.ClassesDaoImpl;
import chao.dao.impl.ColorDaoImpl;
import chao.dao.impl.CommodityDaoImpl;
import chao.dao.impl.CompicDaoImpl;
import chao.dao.impl.DetailsDaoImpl;
import chao.dao.impl.SizeDaoImpl;
import pojo.Classes;
import pojo.Color;
import pojo.Commodity;
import pojo.Compic;
import pojo.Details;
import pojo.Size;
import db.DbHelp2;

public class Pack2 {
	
	static final Logger log =Logger.getLogger(Pack2.class);
	public static void main(String[] args) {
		Connection conn = DbHelp2.getConnection();
		ArrayList<String> array = new ArrayList<String>();//存放商品id
		ArrayList<String> array2 = new ArrayList<String>();//存放价格
		
		for (int j = 1; j < 100; j++) {
			
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
				String productcolor = doc.select("#choose-attr-1").select(".item").select(".selected").attr("title");
				//获得商品的尺寸
				String productsize = doc.select("#choose-attr-2").select(".item").select(".selected").attr("title");
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
				//扒取商品5个颜色
				List<String> colors =new ArrayList<String>();
				List<String> tempcolor =new ArrayList<String>();
				Elements items = doc.select("#choose-attr-1").select(".dd").select(".item");
				colors.add(0, productcolor);
				for (Element element : items) {
					tempcolor.add(element.attr("data-value"));
				}
				for (int j = 0; j < tempcolor.size(); j++) {
					if(productcolor.trim().equals(tempcolor.get(j)))
					{
						tempcolor.remove(j);
					}
				}
				//拿到了除了自己颜色的所有颜色
				if(tempcolor.size() >= 5 )
				{
					for (int j = 1; j < 5; j++) {
						colors.add(tempcolor.get(j));
					}
				}else{
					for (int j = 1; j < tempcolor.size(); j++) {
						colors.add(tempcolor.get(j));
					}
					for (int j =tempcolor.size(); j <5; j++) {
						colors.add("");
					}
				}
				
				//扒取商品尺寸
				List<String> sizes =new ArrayList<String>();
				List<String> tempsizes =new ArrayList<String>();
				Elements items2 = doc.select("#choose-attr-2").select(".dd").select(".item");
				sizes.add(0, productsize);
				for (Element element : items2) {
					tempsizes.add(element.attr("data-value"));
				}
				for (int j = 0; j < tempsizes.size(); j++) {
					if(productsize.trim().equals(tempsizes.get(j)))
					{
						tempsizes.remove(j);
					}
				}
				//拿到了除了自己颜色的所有颜色
				if(tempsizes.size() >= 5 )
				{
					for (int j = 1; j < 5; j++) {
						sizes.add(tempsizes.get(j));
					}
				}else{
					for (int j = 1; j < tempsizes.size(); j++) {
						sizes.add(tempsizes.get(j));
					}
					for (int j =tempsizes.size(); j <5; j++) {
						sizes.add("");
					}
				}
				System.out.println(sizes);
				
				
//				log.debug("商品名:"+productname);
//				log.debug("商品品牌:"+productbrand);
//				log.debug("商品价格:"+arr2.get(i));
//				log.debug("商品颜色:"+productcolor);
				
				//插入商品表
				Commodity comm = new Commodity();
				String comid =UUID.randomUUID().toString();//设置统一商品id
				comm.setComid(comid);
				comm.setComname(productname);
				comm.setCompic(finalgoodsimgs.get(0));
				comm.setComdetails(i);
				comm.setComprice(Double.parseDouble(arr2.get(i)));
				comm.setComclass("手机");
				comm.setColor(productcolor);
				comm.setSize(productsize);
				comm.setPai(productbrand);
				
//				
//				
				//插入商品详情表
				Details dt =new Details();
				dt.setDetailsid(i);
				dt.setDetailsstock(200);//库存
				dt.setDetailsprice(Double.parseDouble(arr2.get(i)));//单价
				dt.setDetailsdrawing(finalgoodsimgs.get(0));//详细图
				dt.setDetailsdot(0);//点赞数
				dt.setDetailssale(0);//已经卖出了多少件
				dt.setColor(productcolor);
				dt.setSize(productsize);
				dt.setPai(productbrand);
				
				
				//插入图片连接表
				Compic com = new Compic();
				com.setComid(comid);
				com.setPicurl1(finalgoodsimgs.get(0));
				com.setPicurl2(finalgoodsimgs.get(1));
				com.setPicurl3(finalgoodsimgs.get(2));
				com.setPicurl4(finalgoodsimgs.get(3));
				com.setPicurl5(finalgoodsimgs.get(4));
				
				//插入大小表
				Size size = new Size();
				size.setComid(comid);
				size.setSize1(sizes.get(0));
				size.setSize2(sizes.get(1));
				size.setSize3(sizes.get(2));
				size.setSize4(sizes.get(3));
				size.setSize5(sizes.get(4));
				
				//插入颜色表
				Color color =new Color();
				color.setComid(comid);
				color.setColor1(colors.get(0));
				color.setColor2(colors.get(1));
				color.setColor3(colors.get(2));
				color.setColor4(colors.get(3));
				color.setColor5(colors.get(4));
				
				//插入商品分类表
				Classes classes = new Classes();
				classes.setClassid(comid);
				classes.setSize(productsize);
				classes.setSeason(12);
				classes.setColor(productcolor);
				classes.setBrand(productbrand);
				classes.setClasses("手机");
				classes.setTest1("");
				classes.setTest2("");
				classes.setTest3("");
				classes.setTest4("");
				classes.setTest5("");
				
				
				
				
				CommodityDao commdao =new CommodityDaoImpl();
				DetailsDao dd =new DetailsDaoImpl();
				CompicDao cd =new CompicDaoImpl();
				SizeDao sd =new SizeDaoImpl();
				ColorDao colordao = new ColorDaoImpl();
				ClassesDao classesdao =new ClassesDaoImpl();
				
				Connection conn = DbHelp2.getConnection();
				
				
				
				try {
					commdao.insertCommodity(comm, conn);
					dd.insertDetails(dt, conn);
					cd.insertCompic(com, conn);
					colordao.insertColor(color, conn);
					sd.insertSize(size, conn);
					classesdao.insertClasses(classes, conn);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
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
		if(firstblank != -1)
		{
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
					try {
						
						brandname = nofirstblank.substring(0,firstblank);
					} catch (Exception e) {
						e.printStackTrace(); 
					}finally{
						brandname = goodsname;
					}
				}else{
					
					brandname = nofirstblank.substring(0,secondblank);
				}
			}
		}else{
			brandname = goodsname;
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
