package chao.dao;

import java.sql.Connection;
import java.util.List;

import pojo.Details;
import dao.DetailsDao;

public interface PjcDetailsDao extends DetailsDao {
	public List<Details> getfifdetailorderydot(Connection conn) throws Exception;
}
