package com.struts.service;

import java.util.List;

import com.struts.dao.StuDao;
import com.struts.entity.TbStu;
import com.struts.entity.Users;

/**
 * 处理学生相关操作的服务层
 * @author Administrator
 *
 */
public class StuService {
	
	/**
	 * 删除一组学生
	 * @param ids 要删除学生ID
	 * @return
	 */
	public boolean deleteStus(int[] ids){
		if(ids!=null&&ids.length>0){
			StuDao dao=new StuDao();
			for (int i : ids) {
				//一个一个学生删除
				dao.deleteStuById(i);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 根据Id查询出学生对象
	 * @param id
	 * @return
	 */
	public TbStu getStuById(int id){
		return new StuDao().getStuById(id);
	}

	/**
	 * 执行添加学生操作
	 * @param stu
	 * @return
	 */
	public boolean addStu(TbStu stu){
		return new StuDao().addStu(stu);
	}
	
	/**
	 * 执行修改学生操作
	 * @param stu
	 * @return
	 */
	public boolean updateStu(TbStu stu){
		return new StuDao().updateStu(stu);
	}
	
	//查询所有学生信息的方法
	public List findStuList(){
		String sql="SELECT s.*,c.cname,b.subname "
				+ "FROM tbstu s,tbclass c,subjects b "
				+ "WHERE s.stucno=c.cno and c.csubno=b.subno;";
		return new StuDao().findStuList(sql);
	}
	
	//根据学生姓名模糊查询学生信息的方法
	public List findStuList(String name){
		String sql="SELECT s.*,c.cname,b.subname "
				+ "FROM tbstu s,tbclass c,subjects b "
				+ "WHERE s.stucno=c.cno and c.csubno=b.subno "
				+ "and s.stuname like '%"+name+"%'";
		return new StuDao().findStuList(sql);
	}
}

