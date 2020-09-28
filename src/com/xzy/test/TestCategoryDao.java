package com.xzy.test;

import com.xzy.dao.CategoryDao;
import com.xzy.dao.impl.CategoryDaoImpl;
import com.xzy.entity.Category;
import com.xzy.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestCategoryDao {

    private final CategoryDao CATEGORYDAO = new CategoryDaoImpl();

    @Test
    public void testAddCategory() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "INSERT INTO category (category_name) values (?)";
        CATEGORYDAO.addCategory(cn,sql,"耳机");
    }

    @Test
    public void testGetCategoryByCategoryId() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT category_id as categoryId,category_name as categoryName FROM category WHERE category_id = ?";
        Category category = CATEGORYDAO.getCategoryByCategoryId(cn, sql, Category.class, 10002);
        System.out.println(category);
    }

    @Test
    public void testGetCategories() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT category_id as categoryId,category_name as categoryName FROM category";
        List<Category> categories = CATEGORYDAO.getCategoryList(cn, sql, Category.class);
        System.out.println(categories);
    }
}
