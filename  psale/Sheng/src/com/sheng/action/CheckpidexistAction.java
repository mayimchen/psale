package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.InsertwuliaoDAO;
import com.sheng.dao.InsertwuliaoDaoImpl;

public class CheckpidexistAction extends ActionSupport {

	/**
	 * 检查指定的产品编号是否存在
	 */
	InsertwuliaoDAO dao=new InsertwuliaoDaoImpl();
	private static final long serialVersionUID = 1L;
	private String pid;
	private int message;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		message=dao.findpid(pid);
		return SUCCESS;
	}	
}
