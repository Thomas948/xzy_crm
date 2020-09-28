package com.xzy.test;

import com.xzy.dao.ProductDao;
import com.xzy.dao.impl.ProductDaoImpl;
import com.xzy.entity.Product;
import com.xzy.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestProductDao {

    private final ProductDao PRODUCTDAO = new ProductDaoImpl();

    @Test
    public void testAddProduct() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "INSERT INTO product ( product_name,product_code,product_category_id,price,founder_id,create_time,update_time,flag) VALUES (?,?,?,?,?,?,?,?)";
        PRODUCTDAO.addProduct(cn, sql, "联想小新15", "ekb1415", 10001, 4098.8, 10001, new Date(), new Date(), 0);
    }

    @Test
    public void testUpdateProduct() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "UPDATE product SET product_name=?,product_code=?,product_category_id=?,price=?,founder_id=?,create_time=?,update_time=?,flag=? WHERE product_id=?";
        PRODUCTDAO.updateProduct(cn, sql, "联想小新14", "ekb14151", 10002, 4091.8, 10000, new Date(), new Date(), 1, 10003);
    }

    @Test
    public void testDeleteProduct() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "DELETE FROM product WHERE product_id=?";
        PRODUCTDAO.deleteProduct(cn, sql, 10003);
    }

    @Test
    public void testGetProductList() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product";
        List<Product> products = PRODUCTDAO.getProductList(cn, sql, Product.class);
        for (Product p :
                products) {
            System.out.println(p);
        }
    }

    @Test
    public void testGetProductByProductId() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product WHERE product_id=?";
        Product product = PRODUCTDAO.getProductByProductId(cn, sql, Product.class, 10001);
        System.out.println(product);
    }
}
