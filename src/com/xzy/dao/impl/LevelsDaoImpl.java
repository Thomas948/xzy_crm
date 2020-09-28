package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.LevelsDao;
import com.xzy.entity.Levels;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LevelsDaoImpl extends BaseDao<Levels> implements LevelsDao {
    @Override
    public void addLevel(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Levels> getLevelsList(Connection cn, String sql, Class<Levels> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Levels getLevelsByLevelId(Connection cn, String sql, Class<Levels> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }
}
