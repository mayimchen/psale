package com.sheng.dao;

import java.util.List;

import com.sheng.po.Outwuliao;

public interface DelwuliaoDAO {
	public boolean checkwuliaonameexist(String pid);//检查出库时的产品名称是否存在
	
	public int getnum(String pid);//查看库存里还有多少库存
	
	public boolean savedel(Outwuliao ow);//保存出库物料
	
	public boolean updatenum(int num,String pid);//更新下该产品的库存量
	
	public boolean delwuliao(String pid);//当出库完之后，如果库存量为0，那么就删除库存里还有的物料
	
	public List<Outwuliao> findallout();//查看所有出库单
	
	public String getpname(String pid);//得到指定ID产品的名字
	
	public double getprice(String pid);//得到指定产品的入库价格
}
