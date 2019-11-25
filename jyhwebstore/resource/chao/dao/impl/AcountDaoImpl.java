package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.jstl.sql.Result;

import pojo.Acount;
import chao.dao.AcountDao;

public class AcountDaoImpl implements AcountDao{

	@Override
	public List<Acount> getAllAcount(Connection conn)  {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		
		List<Acount> list=new ArrayList<>();
		try {
			if(!conn.isClosed()){
				String sql="select * from acount";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Acount acount=new Acount();
				acount.setAid(rs.getString("aid"));
				acount.setAname(rs.getString("aname"));
				acount.setApass(rs.getString("apass"));
				acount.setAphone(rs.getString("aphone"));
				acount.setAmail(rs.getString("amail"));
				acount.setIsadm(rs.getInt("isadm"));
				acount.setAddr(rs.getString("addr"));
				list.add(acount);
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Acount getAcountById(String aid, Connection conn) {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		Acount acount=new Acount();
		try {
			if(!conn.isClosed()){
				String sql="select * from acount where aid=?";
			
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				acount.setAid(rs.getString("aid"));
				acount.setAname(rs.getString("aname"));
				acount.setApass(rs.getString("apass"));
				acount.setAphone(rs.getString("aphone"));
				acount.setAmail(rs.getString("amail"));
				acount.setIsadm(rs.getInt("isadm"));
				acount.setAddr(rs.getString("addr"));
			}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acount;
	}

	@Override
	public boolean insertAcount(Acount acount, Connection conn) {
		if(conn==null){
			return false;
		}
		
		try {
			if(!conn.isClosed()){
				UUID.randomUUID().toString();
				String sql="insert into  acount values(?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, acount.getAid());
				ps.setString(2,acount.getAname() );
				ps.setString(3, acount.getApass());
				ps.setInt(4, acount.getIsadm());
				ps.setString(5, acount.getAphone());
				ps.setString(6, acount.getAmail());
				ps.setString(7, acount.getAddr());
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteAcountByid(String aid, Connection conn) {
		String sql="delete from acount where aid=?";
		if(conn==null){
			return false;
		}
		try {
			if(!conn.isClosed()){
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, aid);
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modifyAcount(Acount acount, Connection conn) {
		if(conn==null){
			return false;
		}
		try {
			String sql="update acount set aname=?,apass=?,isadm=?,aphone=?,amail=?,addr=? where aid=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, acount.getAname());
			ps.setString(2, acount.getApass());
			ps.setInt(3, acount.getIsadm());
			ps.setString(4, acount.getAphone());
			ps.setString(5, acount.getAmail());
			ps.setString(6,acount.getAddr());
			ps.setString(7, acount.getAid());
			int i=	ps.executeUpdate();
			if(i>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
