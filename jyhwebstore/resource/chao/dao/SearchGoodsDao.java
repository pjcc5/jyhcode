package chao.dao;

import java.sql.Connection;
import java.util.List;

import dao.DetailsDao;
import dto.IndexGoodsDto;

public interface SearchGoodsDao extends DetailsDao {
	public List<IndexGoodsDto> getTwentySearch(String content,int page,Connection conn) throws Exception;
	public int getMaxPage(String content,Connection conn) throws Exception;
}
