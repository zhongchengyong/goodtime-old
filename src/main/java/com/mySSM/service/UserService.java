package com.mySSM.service;

import com.mySSM.model.Score;
import com.mySSM.model.User;

public interface UserService {
	public boolean loginSuccess(String userName,String password);
	public User getUserById(String userId);
	public Score getScoreById(Integer Id);
	public int updateByPrimaryKeySelective(User record);
}
