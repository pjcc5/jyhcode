package tan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import chao.dao.impl.AcountDaoImpl;
import pojo.Acount;
import tan.dao.loginDao;

public class loginDaoImpl extends AcountDaoImpl implements loginDao{

	

	@Override
	public Acount loginSelect(String name, String pass,Connection conn)throws Exception {
		// TODO Auto-generated method stub
		if(conn==null){
			return null;
		}
		if(!conn.isClosed()){
			String sql="select * from acount where aname=? and apass=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Acount acount=new Acount();
				acount.setAddr(rs.getString("addr"));
				acount.setAid(rs.getString("aid"));
				acount.setAmail(rs.getString("amail"));
				acount.setAname(rs.getString("aname"));
				acount.setApass(rs.getString("apass"));
				acount.setAphone(rs.getString("aphone"));
				acount.setIsadm(rs.getInt("isadm"));
				return acount;
			}
		}
		return null;
	}

}
