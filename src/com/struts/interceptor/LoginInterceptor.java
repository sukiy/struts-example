package com.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 构建一个是否登录的拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//获取会话
		ActionContext ctx=arg0.getInvocationContext();
		Map session=ctx.getSession();
		if(session.get("loginUser")==null){
			ctx.put("errorMessage", "请先登录");
			return "login";
		}
		return arg0.invoke();
	}

}
