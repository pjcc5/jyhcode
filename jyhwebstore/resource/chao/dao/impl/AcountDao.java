package chao.dao.impl;

import java.util.List;

import pojo.Acount;

public interface AcountDao {
	
	public List<Acount> getAllAcount();//获得所有的账号
	public Acount getAcountById(String aid);//通过aid获得一个账户
	public boolean insertAcount(Acount acount);//插入账户号的方法
	public boolean deleteAcountByid(String aid);//删除账号的方法
	public boolean modifyAcount(Acount acount);//修改账号的方法
	
}
