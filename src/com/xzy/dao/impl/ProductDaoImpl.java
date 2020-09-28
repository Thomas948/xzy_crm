package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.ProductDao;
import com.xzy.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {
    @Override
    public void addProduct(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public void updateProduct(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public void deleteProduct(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Product> getProductList(Connection cn, String sql, Class<Product> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Product getProductByProductId(Connection cn, String sql, Class<Product> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }

    @Override
    public int getProductCount(Connection cn, String sql) throws SQLException {
        return getCount(cn, sql);
    }
}
