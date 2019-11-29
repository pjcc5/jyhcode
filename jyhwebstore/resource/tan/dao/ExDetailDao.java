package tan.dao;

import java.sql.Connection;

import dao.DetailsDao;
import pojo.Details;
import tan.dto.ProductInformation;

public interface ExDetailDao extends DetailsDao{
	public ProductInformation getDetailsByComid(String comid,Connection conn)throws Exception;

}
