package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chao.dao.PjcDetailsDao;
import dao.impl.DetailsDaoImpl;
import dto.IndexGoodsDto;

public class PjcDetailsDaoImpl extends DetailsDaoImpl implements PjcDetailsDao {
	//查询50条dto组合给首页
	@Override
	public List<IndexGoodsDto> getfifdetailorderydot(int page,Connection conn) throws Exception{
		List<IndexGoodsDto> list = new ArrayList<IndexGoodsDto>();
		String sql = "select commodity.comid,commodity.comname,detailsid,detailsstock,detailsprice,detailsdrawing,detailsdot,details.pai FROM details INNER JOIN commodity ON details.comid = commodity.comid ORDER BY  detailsdot desc LIMIT ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (page-1)*50);
		ps.setInt(2, page*50);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			IndexGoodsDto igd =new IndexGoodsDto();
			igd.setComid(rs.getString("comid"));
			igd.setComname(rs.getString("comname"));
			igd.setCompic(rs.getString("detailsdrawing"));
			igd.setComprice(rs.getDouble("detailsprice"));
			igd.setDetailsdot(rs.getInt("detailsdot"));
			igd.setPai(rs.getString("pai"));
			list.add(igd);
		}
		
		return list;
	}

}
