package chao.dao;

import java.sql.Connection;
import java.util.List;

import dao.DetailsDao;
import dto.IndexGoodsDto;

public interface PjcDetailsDao extends DetailsDao {
	public List<IndexGoodsDto> getfifdetailorderydot(int page,Connection conn) throws Exception;
}
