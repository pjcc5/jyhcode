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
			String sql = "insert into address values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address.getAddressid());
			ps.setString(2, address.getAid());
			ps.setInt(3, address.getIsdefault());
			ps.setString(4, address.getProvince());
			ps.setString(5, address.getTown());
			ps.setString(6, address.getCounty());
			ps.setString(7, address.getAddressdetail());
			ps.setString(8, address.getRecivename());
			ps.setString(9, address.getRecivephone());
			ps.setString(10, address.getTest3());
			ps.setString(11, address.getProval());
			ps.setString(12, address.getTownval());
			ps.setString(13, address.getCountyval());
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
			String sql = "delete from address where addressid=?";
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
				address.setAddressid(rs.getString("addressid"));
				address.setAid(rs.getString("aid"));
				address.setIsdefault(rs.getInt("isdefault"));
				address.setProvince(rs.getString("province"));
				address.setTown(rs.getString("town"));
				address.setCounty(rs.getString("county"));
				address.setAddressdetail(rs.getString("addressdetail"));
				address.setRecivephone(rs.getString("recivephone"));
				address.setRecivename(rs.getString("recivename"));
				address.setTest3(rs.getString("test3"));
				address.setProval(rs.getString("proval"));
				address.setTownval(rs.getString("townval"));
				address.setCountyval(rs.getString("countyval"));
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
			String sql = "update address set province=?, town=?,county=?,addressdetail=?,recivename=?,recivephone=?,test3=?,proval=?,townval=?,countyval=? where addressid=?";
			PreparedStatement ps =conn.prepareStatement(sql);
		
			ps.setString(1, address.getProvince());
			ps.setString(2, address.getTown());
			ps.setString(3, address.getCounty());
			ps.setString(4, address.getAddressdetail());
			ps.setString(5,address.getRecivename());
			ps.setString(6, address.getRecivephone());
			ps.setString(7, address.getTest3());
			ps.setString(8, address.getProval());
			ps.setString(9, address.getTownval());
			ps.setString(10, address.getCountyval());
			ps.setString(11, address.getAddressid());
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Address getAddressByAddressid(String addressid, Connection conn)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		if(conn.isClosed()||conn==null)
		{
			return null;
		}
		
			String sql = "select * from address where addressid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, addressid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Address address = new Address();
				address.setAddressid(rs.getString("addressid"));
				address.setAid(rs.getString("aid"));
				address.setIsdefault(rs.getInt("isdefault"));
				address.setProvince(rs.getString("province"));
				address.setTown(rs.getString("town"));
				address.setCounty(rs.getString("county"));
				address.setAddressdetail(rs.getString("addressdetail"));
				address.setRecivephone(rs.getString("recivephone"));
				address.setRecivename(rs.getString("recivename"));
				address.setTest3(rs.getString("test3"));
				address.setProval(rs.getString("proval"));
				address.setTownval(rs.getString("townval"));
				address.setCountyval(rs.getString("countyval"));
				return address;
			}
		
		return null;
	}
	
	public boolean changeDefault(String addressid,int staue,Connection conn) throws Exception{
		
		if(conn.isClosed()||conn==null)
		{
			return false;
		}
		String sql="update address set isdefault=? where addressid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, staue);
		ps.setString(2, addressid);
	int rs=	ps.executeUpdate();
	if(rs>0){
		return true;
	}
	return false;
		
		
	}

}
