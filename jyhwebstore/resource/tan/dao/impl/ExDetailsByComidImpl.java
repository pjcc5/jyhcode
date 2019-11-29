package tan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Details;
import tan.dao.ExDetailDao;
import tan.dto.ProductInformation;

public class ExDetailsByComidImpl implements ExDetailDao{

	@Override
	public ProductInformation getDetailsByComid(String comid, Connection conn)
			throws Exception {

                 if(conn==null){
                	 return null;
                 }
                 String sql="select details.comid,details.pai ,"
                 		+ "details.size,details.detailsdot,detailssale,"
                 		+ "commodity.comprice,commodity.comname,compic.*,size.*,"
                 		+ "color.* from compic INNER JOIN details INNER JOIN commodity INNER JOIN color "
                 		+ "INNER JOIN  size ON "
                 		+ "compic.comid = details.comid AND "
                 		+ "compic.comid = commodity.comid "
                        +"AND compic.comid=color.comid AND compic.comid=size.comid WHERE details.comid=?";
                        
                 PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1, comid);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next()){
                	 List<String> color=new ArrayList<>();
                	 List<String> pic=new ArrayList<>();
                	 List<String> size=new ArrayList<>();
                	 ProductInformation pro=new ProductInformation();
         			pro.setComid(rs.getString("comid"));
         			pro.setComname(rs.getString("comname"));
         			pro.setComprice(rs.getInt("comprice"));
         			pro.setDetailsdot(rs.getInt("detailsdot"));
         			pro.setDetailssale(rs.getInt("detailssale"));
         			pro.setPai(rs.getString("pai"));
         			
         			String str=null;
         			
         			for(int i=1;i<=5;i++){
         				str=rs.getString("color"+i);
         				if(str!=null&&str.length()!=0){
         					System.out.println("color="+str);
         					color.add(str);
         				}
         			}
         			
         			for(int i=1;i<=5;i++){
         				str=rs.getString("picurl"+i);
         				if(str!=null&&str.length()!=0){
         					System.out.println("picur="+str);
         					pic.add(str);
         				}
         			}
         			
         			for(int i=1;i<=5;i++){
         				str=rs.getString("size"+i);
         				if(str!=null&&str.length()!=0){
         					System.out.println("size="+str);
         					size.add(str);
         				}
         			}
         			
         			pro.setColor(color);
         			pro.setPicurl(pic);
         			pro.setSize(size);
         			
         			return pro;
                 }
                 
		return null;
	}

	@Override
	public List<Details> getAllDetails(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Details getDetailsById(int detailsid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(Details details, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDetailsByid(int aid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyDetails(Details details, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
