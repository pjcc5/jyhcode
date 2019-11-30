package mao.soft.web.dao;

import java.sql.Connection;

import pojo.Acount;
import dao.AcountDao;

public interface SelectAidByNameDao extends AcountDao{
	Acount selectAidByName(String aname , Connection conn)throws Exception;
}
