package com.sheng.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckuserexistInterceptor extends AbstractInterceptor {

	/**
	 * 检查员工状态，0代表还在上班，1代表已经不再上班
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		ActionContext ctx=invocation.getInvocationContext();
		Map<String,Object> session=ctx.getSession();
		try{
			int i=(Integer)session.get("existstate");
			if(i==1){
				forward=Action.NONE;
			}else{
				forward=invocation.invoke();
			}
		}catch(Exception e){
			e.printStackTrace();
			forward=Action.NONE;
		}
		
		return forward;
	}

}
