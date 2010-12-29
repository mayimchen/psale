package com.sheng.dao;

import com.sheng.po.Addwuliao;

public interface InsertwuliaoDAO {
	public boolean addwuliao(Addwuliao aw);//添加物料,包含两个操作
	
	public int updatewuliao(Addwuliao aw);//更新物料
	
	public int findpid(String id);//查找指定的ID
}
