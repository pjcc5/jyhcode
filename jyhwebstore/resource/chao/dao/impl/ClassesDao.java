package chao.dao.impl;

import java.util.List;

import pojo.Classes;

public interface ClassesDao {

	public List<Classes> getAllClasses();//获得所有的
	public Classes getClassesById(String aid);//通过aid获得一个账户
	public boolean insertClasses(Classes classes);//插入账户号的方法
	public boolean deleteClassesByid(String aid);//删除账号的方法
	public boolean modifyClasses(Classes classes);//修改账号的方法
	
	
}
