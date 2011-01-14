package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.SaveandBackdata;
import com.sheng.util.DaoconfigReader;

public class SavedataAction extends ActionSupport {

	/**
	 * 对数据库的部分数据进行备份
	 */
	private static final long serialVersionUID = 1L;
	SaveandBackdata saveback=null;
	private int i;
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
		try{
			//1代表返回数据ok
			i=1;
			saveback=(SaveandBackdata) Class.forName(DaoconfigReader.getInstance().getDp().getSaveandbackdao()).newInstance();
			saveback.save();
		}catch(Exception e){
			e.printStackTrace();
			i=0;//0代表出现错误
		}
		return SUCCESS;
	}
	
	

}
