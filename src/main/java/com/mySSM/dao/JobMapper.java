package com.mySSM.dao;

import com.mySSM.model.Job;

public interface JobMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}