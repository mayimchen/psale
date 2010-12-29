package com.sheng.dao;

import com.sheng.po.User;

public interface InsertUserDAO {
	public void saveuser(User u);//增加新用户
	
	/*
	 * @param User 更新用户
	 * **/
	public int updateuser(User u);//更新用户
}
