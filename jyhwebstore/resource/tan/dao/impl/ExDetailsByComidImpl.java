package tan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chao.dao.impl.DetailsDaoImpl;
import dao.DetailsDao;
import pojo.Details;
import tan.dao.ExDetailDao;
import tan.dto.ProductInformation;

public class ExDetailsByComidImpl extends DetailsDaoImpl implements ExDetailDao{

	@Override
	public ProductInformation getDetailsByComid(String comid, Connection conn)
			throws Exception {

                 if(conn==null){
                	 return null;
                 }
                 String sql="select details.comid,details.pai ,"
                 		+ "details.size,details.detailsdot,detailssale,detailsstock,"
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
         			pro.setDetailsstock(rs.getInt("detailsstock"));
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
	public boolean updateSaleByComid(String comid, Connection conn,int num)
			throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		DetailsDao dao=new dao.impl.DetailsDaoImpl();
		
		Details detail=dao.getDetailsFromComid(comid, conn);
		if(detail!=null){
		int count;
		count=detail.getDetailssale();
		count=count+num;
		detail.setDetailssale(count);
		detail.setDetailsstock(detail.getDetailsstock()-num);
		if(dao.modifyDetails(detail, conn)){
			return true;
		}
		}
		 
		return false;
	}


	@Override
	public boolean updatedot(String comid, Connection conn,int dot) throws Exception {
		// TODO Auto-generated method stub
		String sql="update details set detailsdot=? where comid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, dot);
		ps.setString(2, comid);
		int rs=ps.executeUpdate();
		if(rs>0){
			return true;
		}
		return false;
	}

	

}
