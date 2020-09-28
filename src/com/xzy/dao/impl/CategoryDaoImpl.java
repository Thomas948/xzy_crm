package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.CategoryDao;
import com.xzy.entity.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {
    @Override
    public void addCategory(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Category> getCategoryList(Connection cn, String sql, Class<Category> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Category getCategoryByCategoryId(Connection cn, String sql, Class<Category> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }
}
