package com.xzy.service.impl;

import com.xzy.dao.CategoryDao;
import com.xzy.dao.impl.CategoryDaoImpl;
import com.xzy.entity.Category;
import com.xzy.service.CategoryService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> getCategories() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT category_id as categoryId,category_name as categoryName FROM category";
            List<Category> categoryList = categoryDao.getCategoryList(cn, sql, Category.class);
            cn.commit();
            return categoryList;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public Category getCategoryByCategoryId(Integer categoryId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT category_id as categoryId,category_name as categoryName FROM category WHERE category_id = ?";
            Category category = categoryDao.getCategoryByCategoryId(cn, sql, Category.class, categoryId);
            cn.commit();
            return category;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close();
        }
        return null;
    }
}
