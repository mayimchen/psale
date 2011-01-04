package com.sheng.dao;

import java.util.List;

import com.sheng.po.Addwuliao;

public interface FindwuliaoDAO {
	public List<Addwuliao> findalladd();//查找库存
	
	public Addwuliao getwuliaobyid(String pid);//查找指定的物料
	
	public List<Addwuliao> findalladdbf();//查看所有入库单
}
