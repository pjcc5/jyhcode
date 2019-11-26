package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Details;
import chao.dao.PjcDetailsDao;
import dao.impl.DetailsDaoImpl;

public class PjcDetailsDaoImpl extends DetailsDaoImpl implements PjcDetailsDao {

	@Override
	public List<Details> getfifdetailorderydot(Connection conn) throws Exception{
		List<Details> list = new ArrayList<Details>();
		String sql = "select * FROM details ORDER BY  detailsdot desc LIMIT 0,50";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Details de =new Details();
			de.setDetailsid(rs.getInt("detailsid"));
			de.setDetailsstock(rs.getInt("detailsstock"));
			de.setDetailsprice(rs.getDouble("detailsprice"));
			de.setDetailsdrawing(rs.getString("detailsdrawing"));
			de.setDetailsdot(rs.getInt("detailsdot"));
			de.setDetailssale(rs.getInt("detailssale"));
			de.setColor(rs.getString("color"));
			de.setSize(rs.getString("size"));
			de.setPai(rs.getString("pai"));
			de.setTest4(rs.getString("test4"));
			de.setTest5(rs.getString("test5"));
			de.setTest6(rs.getString("test6"));
			list.add(de);
			
		}
		
		return list;
	}

}
