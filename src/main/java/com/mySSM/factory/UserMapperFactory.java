package com.mySSM.factory;
import com.mySSM.dao.UserDao;
public class UserMapperFactory {
	public static UserDao getUserMapper(){
		UserDao userMapper = null;
		return userMapper;
	}
}
