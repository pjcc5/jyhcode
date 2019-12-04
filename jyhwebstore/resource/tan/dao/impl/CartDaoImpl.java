package tan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.taglibs.standard.tag.el.fmt.FormatDateTag;

import dao.impl.ShoppingDaoImpl;
import db.DbHelp;
import db.DbHelp2;
import pojo.Shopping;
import tan.dao.CartDao;
import tan.dto.Cart;
import util.DateFromat;
import util.StringOrArray;

public class CartDaoImpl extends ShoppingDaoImpl implements CartDao{

	@Override
	public List<Cart> SelectCart(String  aid,Connection conn) throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		List<Cart> list=new ArrayList<>();
		String count[]=null;
		String compic[]=null;
		String comprice[]=null;
		String size[]=null;
		String color[]=null;
		String comname[]=null;
		String shopid=null;
		Cart cart=null;
		String[] date=null;
		String[] uuid=null;
		String[] selected=null;
		String[] comid=null;
		String sql="select * FROM shopmiddle INNER JOIN shopping ON shopmiddle.shopid=shopping.shopid  WHERE shopmiddle.aid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, aid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			count= StringOrArray.getArray( rs.getString("count"));
            compic=StringOrArray.getArray(rs.getString("compic"));
            comprice=StringOrArray.getArray(rs.getString("comprice"));
            size=StringOrArray.getArray(rs.getString("size"));
            color=StringOrArray.getArray(rs.getString("color"));
            comname=StringOrArray.getArray(rs.getString("comname"));
            uuid=StringOrArray.getArray(rs.getString("uuid"));
             date=StringOrArray.getArray(rs.getString("datees"));
           shopid= rs.getString("shopid");
           selected=StringOrArray.getArray(rs.getString("selected"));
           comid=StringOrArray.getArray(rs.getString("comid"));
  
		}
		
		
		if(comname!=null){
		for(int i=0;i<comname.length;i++){
//			System.out.println("dateformat="+DateFromat.StringFormattoDate((date[i])));
			cart=new Cart();
			cart.setShopid(shopid);
			cart.setUuid(uuid[i]);
			cart.setComname(comname[i]);
			cart.setCompic(compic[i]);
			cart.setComprice(Integer.parseInt(comprice[i]));
			cart.setCount(Integer.parseInt(count[i]));
			if(date==null){cart.setDate(new Date());}else{
			cart.setDate(DateFromat.StringFormattoDate((date[i])));}
			cart.setUuid(uuid[i]);
			cart.setColor(color[i]);
			cart.setSize(size[i]);
			cart.setSelected(Integer.parseInt(selected[i]));
			cart.setComid(comid[i]);
			list.add(cart);
			
		}	
		
		}
		
		
		System.out.println("shopid="+shopid);
		return list;
		
	}
	
public String selectShopid(String aid,Connection conn)throws Exception{
	if(conn.isClosed()){
		return null;
	}
	String sql="select * from shopmiddle where aid=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setString(1, aid);
	ResultSet rs=ps.executeQuery();
	String shopid=null;
	if(rs.next()){
		shopid=rs.getString("shopid");
	}
      
	return shopid;
}
	
	
	
	public boolean UpdateCart(List<Cart> list,Connection conn,String aid) throws Exception{
		System.out.println(list);
		if(conn==null){
			return false;
		}
		StringBuffer compic=new StringBuffer();
		StringBuffer count=new StringBuffer();
		StringBuffer date=new StringBuffer();
		StringBuffer comprice=new StringBuffer();
		StringBuffer size=new StringBuffer();
		StringBuffer color=new StringBuffer();
		StringBuffer comname=new StringBuffer();
		StringBuffer uuid=new StringBuffer();
		StringBuffer selected=new StringBuffer();
		StringBuffer comid=new StringBuffer();
		for(int j=0;j<list.size();j++){
			count.append(Integer.toString(list.get(j).getCount()));
			compic.append(list.get(j).getCompic());
			date.append(DateFromat.DateFormatToString(list.get(j).getDate()));
			comprice.append(Integer.toString(list.get(j).getComprice()));
			size.append(list.get(j).getSize());
			color.append(list.get(j).getColor());
			comname.append(list.get(j).getComname());
			uuid.append(list.get(j).getUuid());
			selected.append(list.get(j).getSelected());
			comid.append(list.get(j).getComid());
			if(j<list.size()-1){
			count.append(",");
			compic.append(",");
			date.append(",");
			comprice.append(",");
			size.append(",");
			color.append(",");
			comname.append(",");
			uuid.append(",");
			selected.append(",");
			comid.append(",");
			}
		}
		String shopid=null;
	
		shopid=new CartDaoImpl().selectShopid(aid, conn);
		String sql="update shopping set compic=?,count=?,datees=?,comprice=?,size=?,color=?,comname=?,uuid=?,selected=?,comid=? where shopid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, compic.toString());
		ps.setString(2, count.toString());
		ps.setString(3, date.toString());
		ps.setString(4, comprice.toString());
		ps.setString(5, size.toString());
		ps.setString(6, color.toString());
		ps.setString(7, comname.toString());
		ps.setString(8, uuid.toString());
		ps.setString(9, selected.toString());
		ps.setString(10, comid.toString());
		ps.setString(11, shopid);
		int rs=ps.executeUpdate();
		
		if(rs>0){
			return true;
		}
		
		return false;
	}

	

}
