package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Address;
import dao.AddressDao;

public class AddressDaoImpl implements AddressDao{

	@Override
	public boolean insertAddress(Address address, Connection conn)
			throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}
		else {
			String sql = "insert into address(aid,isdefault,province,town,county,addressdetail,recivephone,recivename,test3) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address.getAid());
			ps.setInt(2, address.getIsdefault());
			ps.setString(3, address.getProvince());
			ps.setString(4, address.getTown());
			ps.setString(5, address.getCounty());
			ps.setString(6, address.getAddressdetail());
			ps.setString(7, address.getRecivename());
			ps.setString(8, address.getRecivephone());
			ps.setString(9, address.getTest3());
			
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteAddress(String aid, Connection conn) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}else
		{
			String sql = "delete from address where aid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<Address> getAddressByAid(String aid, Connection conn)
			throws Exception {
		List<Address> list  = new ArrayList<Address>();
		if(conn.isClosed()||conn==null)
		{
			return null;
		}
		
			String sql = "select * from address where aid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Address address = new Address();
				address.setAddressid(rs.getInt("addressid"));
				address.setAid(rs.getString("aid"));
				address.setIsdefault(rs.getInt("isdefault"));
				address.setProvince(rs.getString("province"));
				address.setTown(rs.getString("town"));
				address.setCounty(rs.getString("county"));
				address.setAddressdetail(rs.getString("addressdetail"));
				address.setRecivephone(rs.getString("recivephone"));
				address.setRecivename(rs.getString("recivename"));
				address.setTest3(rs.getString("test3"));
				list.add(address);
			}
			return list;
	}

	@Override
	public boolean modifyAdd(Address address, Connection conn) throws Exception {
		if(conn.isClosed()||conn==null)
		{
			return false;
		}
		else {
			String sql = "update address set isdefault=?,province=?, town=?,county=?,addressdetail=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, address.getIsdefault());
			ps.setString(2, address.getProvince());
			ps.setString(3, address.getTown());
			ps.setString(4, address.getCounty());
			ps.setString(5, address.getAddressdetail());
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		return false;
	}

}
