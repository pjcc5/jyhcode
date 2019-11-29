package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chao.dao.SearchGoodsDao;
import db.DbHelp;
import dto.IndexGoodsDto;

public class SearchGoodsDaoImpl extends DetailsDaoImpl implements SearchGoodsDao{
	int maxpage = 0;
	@Override
	public List<IndexGoodsDto> getTwentySearch(String content,int page,Connection conn) throws Exception {
		//取消非法输入
		if(page <= 0)
		{
			page =1;
		}
		List<IndexGoodsDto> list = new ArrayList<IndexGoodsDto>();
		String sql = "select commodity.comid,commodity.comname,detailsid,detailsstock,detailsprice,detailsdrawing,detailsdot,details.pai FROM details INNER JOIN commodity ON details.comid = commodity.comid WHERE commodity.comname LIKE binary ? ORDER BY  detailsdot desc LIMIT ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("daoimpl"+content);
		ps.setString(1, "%"+content+"%");
		ps.setInt(2, (page-1)*20);
		ps.setInt(3, page*20);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			IndexGoodsDto igd =new IndexGoodsDto();
			igd.setComid(rs.getString("comid"));
			igd.setComname(rs.getString("comname"));
			igd.setCompic(rs.getString("detailsdrawing").replace("50x50", "220x220"));
			igd.setComprice(rs.getDouble("detailsprice"));
			igd.setDetailsdot(rs.getInt("detailsdot"));
			igd.setPai(rs.getString("pai"));
			list.add(igd);
		}
		
		
		
		
		
		return list;
	}
	
	//得到最大页数的方法
	public  int getMaxPage(String content,Connection conn) throws Exception{
		
		String sql = "select COUNT(*) AS A FROM details INNER JOIN commodity ON details.comid = commodity.comid WHERE commodity.comname LIKE binary ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+content+"%");
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{	
			int colum = rs.getInt("A");
			
			return colum%20==0?colum/20:(colum/20+1);
			
		}
		return 0;
			
	} 
	
}
