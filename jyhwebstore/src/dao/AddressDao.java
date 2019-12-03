package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Address;

public interface AddressDao {
	boolean insertAddress( Address address,Connection conn)throws Exception;//添加地址
	boolean deleteAddress(String aid,Connection conn)throws Exception; //删除收货地址
	public List<Address> getAddressByAid(String aid,Connection conn) throws Exception;//通过Aid查询地址表中的地址
	public Address getAddressByAddressid(String addressid,Connection conn) throws Exception;
	boolean modifyAdd(Address address,Connection conn) throws Exception;
	public boolean changeDefault(String addressid,int staue,Connection conn) throws Exception;
}
