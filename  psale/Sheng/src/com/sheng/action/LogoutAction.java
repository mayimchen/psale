package com.sheng.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * ×¢ÏúµÇÂ¼
	 */
	private static final long serialVersionUID = 1L;
	private int i=0;
	private int j;
	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username")!=null){
			ActionContext.getContext().getSession().remove("username");
			i=1;
		}
		if(ActionContext.getContext().getSession().get("username")==null){
			j=1;
		}
		return SUCCESS;
	}
	
}
