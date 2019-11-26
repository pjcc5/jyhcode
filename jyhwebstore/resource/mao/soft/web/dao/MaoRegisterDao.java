package mao.soft.web.dao;

import java.sql.Connection;

import chao.dao.AcountDao;

public interface MaoRegisterDao extends AcountDao{
	//根据手机号查询账号是否已经被注册使用
	public boolean selectPhoneIsExist(String phone,Connection conn) throws Exception;
}
