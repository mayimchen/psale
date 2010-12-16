package com.sheng.dao;

import java.util.List;

import com.sheng.po.Outwuliao;

public interface DelwuliaoDAO {
	public boolean checkwuliaonameexist(String name);//检查出库时的产品名称是否存在
	
	public int getnum(String name);//查看库存里还有多少库存
	
	public boolean savedel(Outwuliao ow);//保存出库物料
	
	public boolean updatenum(String num,String name);//更新下该产品的库存量
	
	public boolean delwuliao(String name);//当出库完之后，如果库存量为0，那么就删除库存里还有的物料
	
	public List<Outwuliao> findallout();//查看所有出库单
}
