package com.sheng.dao;

import java.sql.Timestamp;
import java.util.List;

import com.sheng.po.Outwuliao;

public interface LookpersonDAO {
	//查看指定人员，指定日期内的销量
	public List<Outwuliao> getpersonout(String userid,Timestamp startdate,Timestamp enddate);
}
