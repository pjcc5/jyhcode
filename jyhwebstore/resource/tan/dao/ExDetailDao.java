package tan.dao;

import java.sql.Connection;
import java.util.List;

import dao.DetailsDao;
import pojo.Details;
import tan.dto.Cart;
import tan.dto.ProductInformation;

public interface ExDetailDao extends DetailsDao{
	public ProductInformation getDetailsByComid(String comid,Connection conn)throws Exception;
	public boolean updateSaleByComid(String comid,Connection conn,int num)throws Exception;
	public boolean updatedot(String comid,Connection conn,int dot)throws Exception;

}
