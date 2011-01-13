package com.sheng.action;


import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;


public class LookkucunAction extends ActionSupport {

	/**
	 * 查看所有库存
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO findwuliao=null;
	private List<Addwuliao> wuliaolist;
	private int pageSize=10;
	private int pageNo=1;
	private int sumpage;
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Addwuliao> getWuliaolist() {
		return wuliaolist;
	}

	public void setWuliaolist(List<Addwuliao> wuliaolist) {
		this.wuliaolist = wuliaolist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			findwuliao=(FindwuliaoDAO)Class.forName(DaoconfigReader.getInstance().getDp().getFindwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		String forward="";
		wuliaolist=new ArrayList<Addwuliao>();
		List<Integer> totalpage=new ArrayList<Integer>();
		totalpage=findwuliao.getaddpage(pageSize);
		if(totalpage.get(1)>0){
			sumpage=totalpage.get(0)+1;
		}
		if(totalpage.get(1)==0){
			sumpage=totalpage.get(0);
		}
		if(pageNo>totalpage.get(0)&&totalpage.get(1)>0){
			pageNo=totalpage.get(0)+1;
		}
		if(pageNo>totalpage.get(0)&&totalpage.get(1)==0){
			pageNo=totalpage.get(0);
		}
		if(pageNo<=0){
			pageNo=1;
		}
		wuliaolist=findwuliao.getaddbypage(pageNo, pageSize);
		if(wuliaolist!=null&&wuliaolist.size()!=0){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
