package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.IndustryDao;
import com.xzy.entity.Industry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IndustryDaoImpl extends BaseDao<Industry> implements IndustryDao {
    @Override
    public void addCIndustry(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Industry> getIndustryList(Connection cn, String sql, Class<Industry> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Industry getIndustryByIndustryId(Connection cn, String sql, Class<Industry> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }
}
