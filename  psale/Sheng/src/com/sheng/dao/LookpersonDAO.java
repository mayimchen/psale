package com.sheng.dao;

import java.sql.Timestamp;
import java.util.List;

import com.sheng.po.Outwuliao;

public interface LookpersonDAO {
	//查看指定人员，指定日期内的销量
	public List<Outwuliao> getpersonout(String userid,Timestamp startdate,Timestamp enddate);
	
	//查看指定人员，指定日期，按页显示
   public List<Outwuliao> getpersonoutbypage(String userid,Timestamp startdate,Timestamp enddate,int pageSize,int pageNo);

   //查看指定人员，指定日期的销售额和总毛利
   public List<Double> getsumms(String userid,Timestamp startdate,Timestamp enddate);
   
   //查看指定人员，指定日期，按页显示的总页数
   public List<Integer> getsumpage(String userid,Timestamp startdate,Timestamp enddate,int pageSize);
}
