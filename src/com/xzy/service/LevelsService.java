package com.xzy.service;

import com.xzy.entity.Levels;

import java.util.List;

public interface LevelsService {

    List<Levels> getLevelsList();

    Levels getLevelsByLevelId(Integer levelId);
}
