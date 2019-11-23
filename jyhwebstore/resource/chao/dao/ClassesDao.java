package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Classes;

public interface ClassesDao {

	public List<Classes> getAllClasses();//获得所有的
	public Classes getClassesById(String aid,Connection conn);//通过aid获得一个账户
	public boolean insertClasses(Classes classes,Connection conn);//插入账户号的方法
	public boolean deleteClassesByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyClasses(Classes classes,Connection conn);//修改账号的方法
	
	
}
