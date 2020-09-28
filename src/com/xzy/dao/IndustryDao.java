package com.xzy.dao;

import com.xzy.entity.Industry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IndustryDao {

    void addCIndustry(Connection cn, String sql, Object... args) throws SQLException;

    List<Industry> getIndustryList(Connection cn, String sql, Class<Industry> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Industry getIndustryByIndustryId(Connection cn, String sql, Class<Industry> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
