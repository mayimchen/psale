package com.sheng.dao;

public interface CheckuserexistDAO {	
	public boolean getuser(String userid,String passwd);//检查用户名和密码是否匹配
	public boolean checkuseridexist(String userid);//检查指定的userid是否存在
}
