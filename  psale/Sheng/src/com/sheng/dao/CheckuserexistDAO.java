package com.sheng.dao;

import java.util.List;

public interface CheckuserexistDAO {	
	public boolean getuser(String userid,String passwd);//检查用户名和密码是否匹配
	
	public boolean checkuseridexist(String userid);//检查指定的userid是否存在
	
	public int getmanagement(String userid);//得到指定人员的权限
	
	public int getexiststate(String userid);//得到指定人员的存在状态
	
	public List<Integer> getmanageexiststate(String userid);//得到指定人员的存在状态以及权限
}
