package chao.dao.impl;

import java.sql.Connection;
import java.util.List;

import pojo.Classes;
import chao.dao.ClassesDao;

public class ClassesDaoImpl implements ClassesDao{

	@Override
	public List<Classes> getAllClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classes getClassesById(String aid, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertClasses(Classes classes, Connection conn) {
		String url ="insert into classes() ";
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
