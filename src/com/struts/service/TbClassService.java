package com.struts.service;

import java.util.List;

import com.struts.dao.TbClassDao;

/**
 * 处理班级相关业务的服务类
 * @author Administrator
 *
 */
public class TbClassService {

	//查询出所有的班级
	public List findClassList(){
		return new TbClassDao().getClassList();
	}
}






