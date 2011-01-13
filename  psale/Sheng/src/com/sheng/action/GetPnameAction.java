package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.DelwuliaoDAO;

import com.sheng.util.DaoconfigReader;

public class GetPnameAction extends ActionSupport {

	/**
	 * 得到指定ID产品的名字
	 */
	DelwuliaoDAO ddao=null;
	private static final long serialVersionUID = 1L;
	private String pid;
	private String message;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
		ddao=(DelwuliaoDAO) Class.forName(DaoconfigReader.getInstance().getDp().getDelwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		message=ddao.getpname(pid);
		return SUCCESS;
	}
}
