package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Classes;

public interface ClassesDao {

	public List<Classes> getAllClasses(Connection conn)throws Exception;//获得所有的
	public Classes getClassesById(int aid,Connection conn)throws Exception;//通过aid获得一个账户
	public boolean insertClasses(Classes classes,Connection conn)throws Exception;//插入账户号的方法
	public boolean deleteClassesByid(int aid,Connection conn)throws Exception;//删除账号的方法
	public boolean modifyClasses(Classes classes,Connection conn)throws Exception;//修改账号的方法
	
	
}
