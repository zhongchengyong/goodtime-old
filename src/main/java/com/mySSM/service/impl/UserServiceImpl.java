package com.mySSM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mySSM.dao.ScoreMapper;
import com.mySSM.dao.UserDao;
import com.mySSM.model.Score;
import com.mySSM.model.User;
import com.mySSM.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public boolean loginSuccess(String userName, String password) {
		int count=userDao.selectByNamePwd(userName, password);
		if (count==0) return false;
		return true;
	}
	
	@Override
	public User getUserById(String userId) {
		User user=userDao.selectByPrimaryKey(Integer.parseInt(userId));
		return user;
	}

	@Override
	public Score getScoreById(Integer Id) {
		return scoreMapper.getScoreById(Id);
	}

	@Override
	//@Transactional
	public int updateByPrimaryKeySelective(User record) {
		   return userDao.updateByPrimaryKeySelective(record);
	}
	
}
