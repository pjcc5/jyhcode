package tan.dao;

import java.sql.Connection;

import pojo.Acount;
import chao.dao.AcountDao;

public interface loginDao extends AcountDao{
	public Acount loginSelect(String name,String pass,Connection conn)throws Exception;

}
