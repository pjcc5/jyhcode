package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Details;

public interface DetailsDao {

	public List<Details> getAllDetails(Connection conn)throws Exception;//获得所有的详情
	public Details getDetailsById(int detailsid,Connection conn)throws Exception;//通过detailsid获得一条详情
	public boolean insertDetails(Details details,Connection conn)throws Exception;//插入详情的方法
	public boolean deleteDetailsByid(int aid,Connection conn)throws Exception;//删除一条详情的方法
	public boolean modifyDetails(Details details,Connection conn)throws Exception;//修改详情的方法
	
	
}
