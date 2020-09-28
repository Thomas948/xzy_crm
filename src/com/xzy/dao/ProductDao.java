package com.xzy.dao;

import com.xzy.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    void addProduct(Connection cn, String sql, Object... args) throws SQLException;

    void updateProduct(Connection cn, String sql, Object... args) throws SQLException;

    void deleteProduct(Connection cn, String sql, Object... args) throws SQLException;

    List<Product> getProductList(Connection cn, String sql, Class<Product> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Product getProductByProductId(Connection cn, String sql, Class<Product> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    int getProductCount(Connection cn, String sql) throws SQLException;
}
