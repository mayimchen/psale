package com.sheng.dao;

import java.util.List;

import com.sheng.po.User;

public interface ManageUserDAO {
	public List<User> getalluser();//查看所有的用户
	
	public List<User> getalluserbypage(int pageNo,int pageSize);//查看所有用户，并按分页显示
	
	public List<Integer> gettotalpage(int pageSize);//查看总页数
}
