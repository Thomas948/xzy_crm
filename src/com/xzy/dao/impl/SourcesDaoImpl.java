package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.SourcesDao;
import com.xzy.entity.Sources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SourcesDaoImpl extends BaseDao<Sources> implements SourcesDao {
    @Override
    public void addSource(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Sources> getSourcesList(Connection cn, String sql, Class<Sources> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Sources getSourcesBySouceId(Connection cn, String sql, Class<Sources> clazz, Object... arsg) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, arsg);
    }
}
