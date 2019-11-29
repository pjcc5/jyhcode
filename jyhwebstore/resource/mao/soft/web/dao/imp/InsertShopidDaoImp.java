package mao.soft.web.dao.imp;

import java.sql.Connection;
import java.util.List;

import mao.soft.web.dao.InsertShopIdDao;
import pojo.Shopping;

public class InsertShopidDaoImp implements InsertShopIdDao{

	@Override
	public List<Shopping> getAllAcount(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopping getShopingById(String aid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertShoping(Shopping shoping, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShopingtByid(String aid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyShoping(Shopping shoping, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserShopId(Shopping shop,Connection conn)
			throws Exception {
		if (conn == null || conn.isClosed()) {
			return false;
		}else {
			String sql = "insert into shopping(shopid) values(?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, shop.getShopid());
			int rs=ps.executeUpdate();
			if(rs>0){
				return true;
			}
		}
		return false;
	}

}
