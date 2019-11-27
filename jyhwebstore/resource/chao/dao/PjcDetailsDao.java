package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Details;
import dao.DetailsDao;

public interface PjcDetailsDao extends DetailsDao {
	public List<Details> getfifdetailorderydot(int page,Connection conn) throws Exception;
}
