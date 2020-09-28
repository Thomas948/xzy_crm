package com.xzy.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {

    public int update(Connection cn, String sql, Object... args) throws SQLException {
        PreparedStatement ps = setArgumentsValue(cn, sql, args);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public List<T> getList(Connection cn, String sql, Class<T> clazz, Object... args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        PreparedStatement ps = setArgumentsValue(cn, sql, args);
        ResultSet rs = ps.executeQuery();
        List<T> list = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();

        while (rs.next()) {
            T t = setEntityValue(clazz, rs, metaData);
            list.add(t);
        }
        return list;
    }

    public T get(Connection cn, String sql, Class<T> clazz, Object... args) throws NoSuchFieldException, SQLException, IllegalAccessException, InstantiationException {
        PreparedStatement ps = setArgumentsValue(cn, sql, args);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        T t = null;
        if (rs.next()) {
            t = setEntityValue(clazz, rs, metaData);
        }
        return t;
    }

    public int getCount(Connection cn, String sql,Object...args) throws SQLException {
        PreparedStatement ps = setArgumentsValue(cn, sql, args);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    private T setEntityValue(Class<T> clazz, ResultSet rs, ResultSetMetaData metaData) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException {
        T t = clazz.newInstance();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            String columnLabel = metaData.getColumnLabel(i + 1);
            Object columnValue = rs.getObject(columnLabel);
            Field field = clazz.getDeclaredField(columnLabel);
            field.setAccessible(true);
            field.set(t, columnValue);
        }
        return t;
    }

    private PreparedStatement setArgumentsValue(Connection cn, String sql, Object[] args) throws SQLException {
        PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        return ps;
    }
}
