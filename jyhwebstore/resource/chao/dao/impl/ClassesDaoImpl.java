package chao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Acount;
import pojo.Classes;
import chao.dao.ClassesDao;
import db.DbHelp2;

public class ClassesDaoImpl implements ClassesDao{
  
	@Override
	public List<Classes> getAllClasses() {
		Connection conn= DbHelp2.getConnection();
		if(conn==null){
			return null;
		}
		
		List<Classes> list=new ArrayList<>();
		try {
			if(!conn.isClosed()){
				String sql="select * from classes";
				PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Classes classes=new Classes();
			classes.setClassid(rs.getInt("calssid"));
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	@Override
	public Classes getClassesById(String aid, Connection conn) {
		
		System.out.println(11);
			return null;
	
		
	
	}

	@Override
	public boolean insertClasses(Classes classes, Connection conn) {
		
		return false;
	}

	@Override
	public boolean deleteClassesByid(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyClasses(Classes classes, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
