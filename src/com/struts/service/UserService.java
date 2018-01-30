package com.struts.service;

import java.util.List;

import com.struts.dao.UserDao;
import com.struts.entity.Users;

/**
 * 处理用户相关操作的服务
 * @author Administrator
 *
 */
public class UserService {

	/**
	 * 处理用户登录的业务类
	 * @param name 用户名
	 * @param pwd 密码
	 * @return
	 */
	public Users doLogin(String name,String pwd){
		String sql="select * from users where uname='"+name+"'";
		//调用Dao层方法执行查询
		List<Users> userList=new UserDao().findUserList(sql);
		for (Users users : userList) {
			if(users.getUname().equals(name)&&users.getUpwd().equals(pwd)){
				return users;
			}
		}
		return null;
	}
	
	//假如有一个查询所有用户的方法
	public List getUserList(){
		return new UserDao().findUserList("select * from Users");
	}
}














