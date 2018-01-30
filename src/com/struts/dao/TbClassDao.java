package com.struts.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.struts.entity.TbClass;
import com.struts.entity.Users;

/**
 * 处理班级相关数据库操作的类
 * @author Administrator
 *
 */
public class TbClassDao {

	//查询所有班级的方法
	public List getClassList(){
		Connection conn=BaseDao.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();//构建一个语句执行对象
			rs=st.executeQuery("select * from tbclass");//查询
			List list=new ArrayList();
			while(rs.next()){
				TbClass c=new TbClass();
				c.setCno(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCsubno(rs.getInt(3));
				list.add(c);
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



