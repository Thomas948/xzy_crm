package com.xzy.dao;

import com.xzy.entity.Sources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SourcesDao {

    void addSource(Connection cn, String sql, Object... args) throws SQLException;

    List<Sources> getSourcesList(Connection cn, String sql, Class<Sources> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Sources getSourcesBySouceId(Connection cn, String sql, Class<Sources> clazz, Object... arsg) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
