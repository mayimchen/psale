package com.sheng.action;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.dao.CheckuserexistDaoImpl;
import com.sheng.dao.DelwuliaoDAO;
import com.sheng.dao.DelwuliaoDaoImpl;
import com.sheng.po.Outwuliao;

public class DelwuliaoAction extends ActionSupport {

	/**
	 * 出库action，出库单子
	 */
	CheckuserexistDAO cdao = new CheckuserexistDaoImpl();
	DelwuliaoDAO ddao = new DelwuliaoDaoImpl();
	Logger logger=Logger.getLogger(DelwuliaoAction.class);
	private static final long serialVersionUID = 1L;
	private String pid;
	private String outname;
	private int outnum;
	private double outprice;
	private String outuserid;
	private String outdate;
	private double maori;
	private double sumsales;
	private double summaori;
	private String purchaser;
	private int a;// 库存量
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getOutname() {
		return outname;
	}

	public void setOutname(String outname) {
		this.outname = outname;
	}

	public int getOutnum() {
		return outnum;
	}

	public void setOutnum(int outnum) {
		this.outnum = outnum;
	}

	public double getOutprice() {
		return outprice;
	}

	public void setOutprice(double outprice) {
		this.outprice = outprice;
	}

	public String getOutuserid() {
		return outuserid;
	}

	public void setOutuserid(String outuserid) {
		this.outuserid = outuserid;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public double getMaori() {
		return maori;
	}

	public void setMaori(double maori) {
		this.maori = maori;
	}

	public double getSumsales() {
		return sumsales;
	}

	public void setSumsales(double sumsales) {
		this.sumsales = sumsales;
	}

	public double getSummaori() {
		return summaori;
	}

	public void setSummaori(double summaori) {
		this.summaori = summaori;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	// 数据库表还未加，等待加好就ok了，主要往数据表里添加条记录
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		outdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());	
	PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
		Outwuliao ow = new Outwuliao();
		//maori=new BigDecimal("+outprice+").subtract(new BigDecimal("+ddao.getprice(pid)+")).doubleValue();
		maori=outprice-ddao.getprice(pid);
		//double c=2.0;
		//double d=1.1;
		//System.out.println("(c-d):"+(c-d));
		//System.out.println("毛利为:"+maori);
		ow.setPid(pid);
		ow.setMaori(maori);//毛利需要再计算一下，
		ow.setPurchaser(purchaser);
		ow.setSummaori(maori);//总毛利
		ow.setSumsales(outprice);//总销售额
		ow.setOutdate(outdate);
		ow.setOutname(outname);
		ow.setOutnum(outnum);
		ow.setOutprice(outprice);
		ow.setOutuserid(outuserid);
		String forward = "";
		boolean s = outname.length()!= 0 
				 && outuserid.length()!= 0
				&& outdate.length()!= 0;
		if (s && checkname() && checknum()) {
			// 先往出库单里写一条记录
			if (ddao.savedel(ow)) {
				forward = "success";
			} else {
				forward = "input";
			}
			// 再从入库单里更新一下数据
			int i = a - outnum;
			if (i == 0) {
				if (ddao.delwuliao(pid)) {
					forward = "success";
				} else {
					forward = "input";
				}
			} else {
				int num =i;
				if (ddao.updatenum(num, pid)) {
					forward = "success";
				} else {
					forward = "input";
				}
			}
		} else {
			forward = "input";
		}
		if(forward.equals("success")){
			logger.info(ActionContext.getContext().getSession().get("username")+"成功删除了物料"+pid+",数量为:"+outnum+"买主为:"+purchaser+"售价为:"+outprice);
		}
		else{
			logger.info(ActionContext.getContext().getSession().get("username")+"未能成功出库");
		}
		return forward;
	}

	/*
	 * 检查是否存在这样的产品ID *
	 */
	public boolean checkname() {
		boolean flag = false;
		if (ddao.checkwuliaonameexist(pid)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/*
	 * 检查已存在的产品名的数量和输入的数量值之间是否符合逻辑 *
	 */
	public boolean checknum() {
		boolean flag = false;
		boolean g = checkname();
		boolean h = checkuserid();
		if (g && h) {
			a = ddao.getnum(pid);// 数据库里的库存量
			if (a < outnum) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * 检查userid是否存在,存在标志为true,不存在标志为false; *
	 */
	public boolean checkuserid() {
		boolean flag = false;
		if (cdao.checkuseridexist(getOutuserid())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
