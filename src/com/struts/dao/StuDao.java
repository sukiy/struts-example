package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.struts.entity.TbStu;
import com.struts.utils.DataFormatUtil;

/**
 * 处理学生相关数据库操作的类
 * @author Administrator
 *
 */
public class StuDao {
	
	/**
	 * 根据Id删除一个学生
	 * @param id 学生ID
	 * @return
	 */
	public boolean deleteStuById(int id){
		Connection conn=BaseDao.getConnection();
		PreparedStatement ps=null;
		String sql="delete from tbstu where stuno="+id;
		try {
			ps=conn.prepareStatement(sql);
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, ps, null);
		}
		return false;
	}
	/**
	 * 执行添加学生
	 * @param stu
	 * @return
	 */
	public boolean addStu(TbStu stu){
		Connection conn=BaseDao.getConnection();
		PreparedStatement ps=null;
		String sql="insert into tbstu values(default,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setString(2, stu.getSsex());
			ps.setString(3, stu.getShobby());
			ps.setString(4,DataFormatUtil.formatToString(stu.getSintime()));
			ps.setString(5, stu.getSimage());
			ps.setInt(6, stu.getScno());
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, ps, null);
		}
		return false;
	}
	
	/**
	 * 执行修改学生
	 * @param stu
	 * @return
	 */
	public boolean updateStu(TbStu stu){
		Connection conn=BaseDao.getConnection();
		PreparedStatement ps=null;
		String sql="update tbstu set stuname=?,stusex=?,stuhobby=?,stuintime=?,stuimage=?,stucno=? where stuno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setString(2, stu.getSsex());
			ps.setString(3, stu.getShobby());
			ps.setString(4,DataFormatUtil.formatToString(stu.getSintime()));
			ps.setString(5, stu.getSimage());
			ps.setInt(6, stu.getScno());
			ps.setInt(7, stu.getSno());
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, ps, null);
		}
		return false;
	}
	
	/**
	 * 根据条件查询学生信息
	 * @param sql 要执行的查询操作
	 * @return
	 */
	public List findStuList(String sql){
		Connection conn=BaseDao.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);//执行查询
			List list=new ArrayList();
			while(rs.next()){
				String[] row=new String[9];
				for (int i = 0; i < row.length; i++) {
					row[i]=rs.getString(i+1);
				}
				list.add(row);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, st, rs);
		}
		return null;
	}

	/**
	 * 根据Id查询出学生对象
	 * @param id 学生ID
	 * @return
	 */
	public TbStu getStuById(int id){
		Connection conn=BaseDao.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			String sql="select * from tbStu where stuno="+id;
			rs=st.executeQuery(sql);//执行查询
			if(rs.next()){
				TbStu stu=new TbStu();
				stu.setSno(rs.getInt(1));
				stu.setSname(rs.getString(2));
				stu.setSsex(rs.getString(3));
				stu.setShobby(rs.getString(4));
				stu.setSintime(rs.getDate(5));
				stu.setSimage(rs.getString(6));
				stu.setScno(rs.getInt(7));
				return stu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDb(conn, st, rs);
		}
		return null;
	}
}





