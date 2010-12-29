package com.sheng.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 权限控制拦截器
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String forward ="";
		ActionContext ctx=arg0.getInvocationContext();
		Map<String,Object> session=ctx.getSession();
		try{
			String username=(String) session.get("username");
			if(username==null&&username.length()==0){
				ctx.put("tip","对不起，您还没有登陆，请登录后再进行操作！");
				forward=Action.LOGIN;
			}else{
				forward=arg0.invoke();
			}
		}catch(Exception e){
			ctx.put("tip","对不起，您还没有登陆，请登录后再进行操作！");
			forward=Action.LOGIN;
		}		
		return forward;
	}
}
