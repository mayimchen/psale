package com.sheng.dao;

import java.util.List;

import com.sheng.po.Addwuliao;

public interface FindwuliaoDAO {
	public List<Addwuliao> findalladd();//查找库存
	
	public Addwuliao getwuliaobyid(String pid);//查找指定的物料
	
	public List<Addwuliao> findalladdbf();//查看所有入库单
	
	public List<Addwuliao> findaddbfbypage(int pageNo,int pageSize);//查看所有入库单，按照分页查询方式
	
	public List<Integer> gettotalpage(int pageSize);//得到所有入库单页数，所有入库单的页数
	
	public List<Addwuliao> getaddbypage(int pageNo,int pageSize);//得到库存里物料内容，按照分页查询方式
	
	public List<Integer> getaddpage(int pageSize);//得到所有库存单页数,指的是库存量的页数
}
