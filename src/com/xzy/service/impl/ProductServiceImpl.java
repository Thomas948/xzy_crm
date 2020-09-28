package com.xzy.service.impl;

import com.xzy.dao.CategoryDao;
import com.xzy.dao.EmployeeDao;
import com.xzy.dao.ProductDao;
import com.xzy.dao.impl.CategoryDaoImpl;
import com.xzy.dao.impl.EmployeeDaoImpl;
import com.xzy.dao.impl.ProductDaoImpl;
import com.xzy.dto.Page;
import com.xzy.entity.Category;
import com.xzy.entity.Employee;
import com.xzy.entity.Product;
import com.xzy.service.ProductService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao PRODUCTDAO = new ProductDaoImpl();
    private final CategoryDao CATEGORYDAO = new CategoryDaoImpl();
    private final EmployeeDao EMPLOYEEDAO = new EmployeeDaoImpl();

    @Override
    public void addProduct(Product product) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "INSERT INTO product ( product_name,product_code,product_category_id,price,founder_id,create_time,update_time,flag) VALUES (?,?,?,?,?,?,?,?)";
            PRODUCTDAO.addProduct(cn, sql, product.getProductName(), product.getProductCode(), product.getProductCategoryId(), product.getPrice(), product.getFounderId(), product.getCreateTime(), product.getUpdateTime(), product.getFlag());
            cn.commit();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
    }

    @Override
    public void updateProduct(Product product) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "UPDATE product SET product_name=?,product_code=?,product_category_id=?,price=?,founder_id=?,create_time=?,update_time=?,flag=? WHERE product_id=?";
            PRODUCTDAO.updateProduct(cn, sql, product.getProductName(), product.getProductCode(), product.getProductCategoryId(), product.getPrice(), product.getFounderId(), product.getCreateTime(), product.getUpdateTime(), product.getFlag(), product.getProductId());
            cn.commit();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "DELETE FROM product WHERE product_id=?";
            PRODUCTDAO.deleteProduct(cn, sql, productId);
            cn.commit();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
    }

    @Override
    public Page getProductPages(int pageNo, int pageSize, String keyword) {
        int offset = (pageNo - 1) * pageSize;
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product WHERE product_name like '%"+keyword+"%' LIMIT ?,?";
            List<Product> productList = PRODUCTDAO.getProductList(cn, sql, Product.class, offset, pageSize);
            String sql1 = "SELECT category_id as categoryId,category_name as categoryName FROM category WHERE category_id=?";
            String sql2 = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            for (Product product :
                    productList) {
                Category category = CATEGORYDAO.getCategoryByCategoryId(cn, sql1, Category.class, product.getProductCategoryId());
                Employee employee = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql2, Employee.class, product.getFounderId());
                product.setCategory(category);
                product.setFounder(employee);
            }
            sql = "SELECT COUNT(*) as count FROM product WHERE product_name like '%"+keyword+"%'";
            int count = PRODUCTDAO.getProductCount(cn, sql);
            int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            page.setPageCount(pageCount);
            page.setHasPre(pageNo > 1);
            page.setHasNext(pageNo < pageCount);
            page.setObj(productList);
            cn.commit();
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
        return page;
    }

    @Override
    public Product getProductByProductId(Integer productId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product WHERE product_id=?";
            Product product = PRODUCTDAO.getProductByProductId(cn, sql, Product.class, productId);
            cn.commit();
            return product;
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public List<Product> getProductList() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product";
            List<Product> productList = PRODUCTDAO.getProductList(cn, sql, Product.class);
            String sql1 = "SELECT category_id as categoryId,category_name as categoryName FROM category WHERE category_id=?";
            String sql2 = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            for (Product product :
                    productList) {
                Category category = CATEGORYDAO.getCategoryByCategoryId(cn, sql1, Category.class, product.getProductCategoryId());
                Employee employee = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql2, Employee.class, product.getFounderId());
                product.setCategory(category);
                product.setFounder(employee);
            }
            cn.commit();
            return productList;
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
