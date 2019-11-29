package tan.servers;

import java.sql.Connection;

import tan.dao.ExDetailDao;
import tan.dao.impl.ExDetailsByComidImpl;
import tan.dto.ProductInformation;

public class ProductDetail {
	
public ProductInformation getProduct(String comid,Connection conn){
	ProductInformation pro=null;
	ExDetailDao dao=new ExDetailsByComidImpl();
	try {
		pro=dao.getDetailsByComid(comid, conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pro;
}


}
