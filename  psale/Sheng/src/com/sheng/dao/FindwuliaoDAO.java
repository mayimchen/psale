package com.sheng.dao;

import java.util.List;

import com.sheng.po.Addwuliao;

public interface FindwuliaoDAO {
	public List<Addwuliao> findalladd();//查找所有的入库物料
	
	public Addwuliao getwuliaobyid(String pid);//查找指定的物料
}
