package com.struts.dao;

import java.sql.*;

public class BaseDao {

	/**
	 * 加载驱动
	 */
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/studb?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭数据库连接，释放资源
	 * @param conn 数据库连接对象
	 * @param st 数据库语句执行对象
	 * @param rs 结果集对象
	 */
	public static void closeDb(Connection conn,Statement st,ResultSet rs){
		if(rs!=null)try {rs.close();} catch (SQLException e) {
				e.printStackTrace();
			}
		if(st!=null)try {st.close();} catch (SQLException e) {
			e.printStackTrace();
		}
		if(conn!=null)try {conn.close();} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}






