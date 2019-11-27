package tan.dao;

import java.sql.Connection;

import dao.AcountDao;
import pojo.Acount;


public interface loginDao extends AcountDao{
	public Acount loginSelect(String name,String pass,Connection conn)throws Exception;

}
