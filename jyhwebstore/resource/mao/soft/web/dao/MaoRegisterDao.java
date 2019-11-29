package mao.soft.web.dao;

import java.sql.Connection;

import dao.AcountDao;
import dao.UserDao;

public interface MaoRegisterDao extends AcountDao{
	//根据手机号查询账号是否已经被注册使用
	public boolean selectPhoneIsExist(String phone, String name ,Connection conn) throws Exception;
}
