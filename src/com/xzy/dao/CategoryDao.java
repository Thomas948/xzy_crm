package com.xzy.dao;

import com.xzy.entity.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    void addCategory(Connection cn, String sql, Object... args) throws SQLException;

    List<Category> getCategoryList(Connection cn, String sql, Class<Category> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Category getCategoryByCategoryId(Connection cn, String sql, Class<Category> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
