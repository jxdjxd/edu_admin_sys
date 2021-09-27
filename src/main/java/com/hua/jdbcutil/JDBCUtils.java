package com.hua.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * 连接数据库的工具类
 * @author jxd
 * @date 2021.09.26
 */
public class JDBCUtils {
	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * @return 数据源的一个Connection对象
	 * @throws SQLException 抛出sql异常
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 关闭Connection连接
	 * @param conn 要关闭的连接
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
