package com.struts.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.entity.Users;
import com.struts.service.UserService;

/**
 * 处理用户相关请求的Action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport{

	private Users user;

	//处理登录操作
	public String doLogin(){
		//调用服务层方法执行登录操作
		Users u=new UserService().doLogin(user.getUname(), user.getUpwd());
		if(u!=null){
			u.setUpwd("");
			ActionContext.getContext().getSession().put("loginUser", user);
			return "main";
		}else{
			addActionError("用户名和密码错误！");
		}
		return "input";
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}





