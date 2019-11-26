package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Acount;
import pojo.Classes;
import dao.ClassesDao;
import db.DbHelp2;

public class ClassesDaoImpl implements ClassesDao{
  
	@Override
	public List<Classes> getAllClasses(Connection conn)throws Exception {
		if(conn==null){
			return null;
		}
		
		List<Classes> list=new ArrayList<>();
		
			if(!conn.isClosed()){
				String sql="select * from classes";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Classes classes=new Classes();
			classes.setClassid(rs.getString("classid"));
			classes.setSize(rs.getString("size"));
			classes.setSeason(rs.getInt("season"));
			classes.setColor(rs.getString("color"));
			classes.setBrand(rs.getString("brand"));
			classes.setClasses(rs.getString("classes"));
			classes.setTest1(rs.getString("test1"));
			classes.setTest2(rs.getString("test2"));
			classes.setTest3(rs.getString("test3"));
			classes.setTest4(rs.getString("test4"));
			classes.setTest5(rs.getString("test5"));
			list.add(classes);
			}
				
			}
		
		
		
		return list;
	}
	@Override
	public Classes getClassesById(int aid, Connection conn)throws Exception {
		if(conn==null){
			return null;
		}
		
			if(!conn.isClosed()){
				String sql="select * from classes where classid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			Classes classes=new Classes();
			classes.setClassid(rs.getString("classid"));
			classes.setSize(rs.getString("size"));
			classes.setSeason(rs.getInt("season"));
			classes.setColor(rs.getString("color"));
			classes.setBrand(rs.getString("brand"));
			classes.setClasses(rs.getString("classes"));
			classes.setTest1(rs.getString("test1"));
			classes.setTest2(rs.getString("test2"));
			classes.setTest3(rs.getString("test3"));
			classes.setTest4(rs.getString("test4"));
			classes.setTest5(rs.getString("test5"));
		     return classes;
			}
				
			}
		
		
			return null;
	
		
	
	}

	@Override
	public boolean insertClasses(Classes classes, Connection conn)throws Exception {
		if(conn==null){
			return false;
		}

			if(!conn.isClosed()){
				String sql="insert into classes values(?,?,?,?,?,?,?,?,?,?,?)";
			   PreparedStatement ps=conn.prepareStatement(sql);
			   ps.setString(1, classes.getClassid());
			   ps.setString(2, classes.getSize());
			   ps.setInt(3, classes.getSeason());
			   ps.setString(4, classes.getColor());
			   ps.setString(5, classes.getBrand());
			   ps.setString(6, classes.getClasses());
			   ps.setString(7, classes.getTest1());
			   ps.setString(8, classes.getTest2());
			   ps.setString(9, classes.getTest3());
			   ps.setString(10, classes.getTest4());
			   ps.setString(11, classes.getTest5());
			   int rs=ps.executeUpdate();
			   if(rs>0){
				   return true;
			   }
			}
		
		return false;
	}

	@Override
	public boolean deleteClassesByid(int aid, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
		
			if(!conn.isClosed()){
				String sql="delete from classes where classid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, aid);
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
		
			}
		
		return false;
	}

	@Override
	public boolean modifyClasses(Classes classes, Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return false;
		}
	
			if(!conn.isClosed()){
				String sql="update classes set size=?,season=?,color=?,brand=?,classes=?,test1=?,test2=?,test3=?,test4=?,test5=? where classid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, classes.getSize());
				ps.setInt(2, classes.getSeason());
				ps.setString(3, classes.getColor());
				ps.setString(4, classes.getBrand());
				ps.setString(5, classes.getClasses());
				ps.setString(6, classes.getTest1());
				ps.setString(7, classes.getTest2());
				ps.setString(8, classes.getTest3());
				ps.setString(9, classes.getTest4());
				ps.setString(10, classes.getTest5());
				ps.setString(11, classes.getClassid());
				int rs=ps.executeUpdate();
				if(rs>0){
					return true;
				}
			}
		
		return false;
	}

	

}
