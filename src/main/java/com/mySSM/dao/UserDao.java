package com.mySSM.dao;

import org.apache.ibatis.annotations.Param;

import com.mySSM.model.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    int selectByNamePwd(@Param("username") String username,@Param("password") String password);
}