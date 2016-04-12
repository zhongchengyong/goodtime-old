package com.mySSM.dao;

import com.mySSM.model.Score;

public interface ScoreMapper {
    int insert(Score record);

    int insertSelective(Score record);
    
    Score getScoreById(int id);
}