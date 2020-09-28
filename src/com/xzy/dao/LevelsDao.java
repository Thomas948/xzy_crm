package com.xzy.dao;

import com.xzy.entity.Levels;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LevelsDao {

    void addLevel(Connection cn, String sql, Object... args) throws SQLException;

    List<Levels> getLevelsList(Connection cn, String sql, Class<Levels> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Levels getLevelsByLevelId(Connection cn, String sql, Class<Levels> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
