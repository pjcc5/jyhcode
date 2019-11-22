package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbHelp {
	private static Properties prop = new Properties();
	static{
		try {
			prop.load(DbHelp.class.getResourceAsStream("/db/prop/db.properties"));
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("......DB层异常......");
		}
	}
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			System.out.println("......连接成功......");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("......连接异常......");
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn)
	{
		try {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
				System.out.println("......数据库关闭成功！......");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("......关闭异常......");
		}
	}
	public static void main(String[] args) {
		System.out.println(DbHelp.getConnection());
	}
}
