package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Details;

public interface DetailsDao {

	public List<Details> getAllDetails();//获得所有的
	public Details getDetailsById(String detailsid,Connection conn);//通过detailsid获得一个账户
	public boolean insertDetails(Details details,Connection conn);//插入账户号的方法
	public boolean deleteDetailsByid(String aid,Connection conn);//删除账号的方法
	public boolean modifyDetails(Details details,Connection conn);//修改账号的方法
	
	
}
