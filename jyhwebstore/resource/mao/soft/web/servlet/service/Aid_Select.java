package mao.soft.web.servlet.service;

import java.sql.Connection;

import pojo.Acount;
import mao.soft.web.dao.SelectAidByNameDao;
import mao.soft.web.dao.imp.SelectAidByNameDaoImp;
import db.DbHelp;


public class Aid_Select {
	public String selectAidByName(String aname)throws Exception
	{
		Connection conn = DbHelp.getConnection();
		SelectAidByNameDao sad = new SelectAidByNameDaoImp();
		Acount acount =  sad.selectAidByName(aname, conn);
		String aid = acount.getAid().toString();
		
		return aid;
		
	}
}
