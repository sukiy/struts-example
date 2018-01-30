package com.struts.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.struts.entity.Users;

/**
 * 处理User相关数据操作的类
 * @author Administrator
 *
 */
public class UserDao {

	//构建一个查询方法，返回Users对象
	public List findUserList(String sql){
		Connection conn=BaseDao.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();//构建一个语句执行对象
			rs=st.executeQuery(sql);//查询
			List list=new ArrayList();
			while(rs.next()){
				Users user=new Users();
				user.setUno(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, st, rs);
		}
		return null;
	}
}





