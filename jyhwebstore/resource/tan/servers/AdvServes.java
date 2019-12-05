package tan.servers;

import java.sql.Connection;
import java.util.List;

import chao.dao.PjcDetailsDao;
import chao.dao.impl.PjcDetailsDaoImpl;
import db.DbHelp;
import dto.IndexGoodsDto;

public class AdvServes {
//	getfifdetailorderydot
	public List<IndexGoodsDto> getDetaildot(){
		Connection conn=DbHelp.getConnection();
		PjcDetailsDao dao=new PjcDetailsDaoImpl();
		List<IndexGoodsDto> list;
		
			try {
				list = dao.getfifdetailorderydot(1, conn);
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbHelp.closeConnection(conn);
			}
			
		return null;
	}

}
