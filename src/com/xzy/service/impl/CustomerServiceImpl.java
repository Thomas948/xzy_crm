package com.xzy.service.impl;

import com.xzy.dao.*;
import com.xzy.dao.impl.*;
import com.xzy.dto.Page;
import com.xzy.entity.*;
import com.xzy.service.CustomerService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao CUSTOMERDAO = new CustomerDaoImpl();
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private final SourcesDao sourcesDao = new SourcesDaoImpl();
    private final IndustryDao industryDao = new IndustryDaoImpl();
    private final LevelsDao levelsDao = new LevelsDaoImpl();

    @Override
    public void addCustomer(Customer customer) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "INSERT INTO customer ( customer_name,phone,status,person_liable_id,founder_id,source_id,industry_id,level_id,create_time,update_time,next_contact_time,flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            CUSTOMERDAO.addCustomer(cn, sql, customer.getCustomerName(), customer.getPhone(), customer.getStatus(), customer.getPersonLiableId(), customer.getFounderId(), customer.getSourceId(), customer.getIndustryId(), customer.getLevelId(), customer.getCreateTime(), customer.getUpdateTime(), customer.getNextContactTime(), customer.getFlag());
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
    public void deleteCustomer(Integer customerId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "DELETE FROM customer WHERE customer_id=?";
            CUSTOMERDAO.deleteCustomer(cn, sql, customerId);
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
    public void updateCustomer(Customer customer) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "UPDATE customer SET customer_name=?,phone=?,status=?,person_liable_id=?,founder_id=?,source_id=?,industry_id=?,level_id=?,create_time=?,update_time=?,next_contact_time=? WHERE customer_id=?";
            CUSTOMERDAO.updateCustomer(cn, sql, customer.getCustomerName(), customer.getPhone(), customer.getStatus(), customer.getPersonLiableId(), customer.getFounderId(), customer.getSourceId(), customer.getIndustryId(), customer.getLevelId(), customer.getCreateTime(), customer.getUpdateTime(), customer.getNextContactTime(), customer.getCustomerId());
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
    public Page getCustomerPages(int pageNo, int pageSize, int flag, String keyword) {
        int offset = (pageNo - 1) * pageSize;
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT customer_id as customerId,customer_name as customerName,phone,status,person_liable_id as personLiableId,founder_id as founderId,source_id as sourceId,industry_id as industryId,level_id as levelId,create_time as createTime,update_time as updateTime,next_contact_time as nextContactTime FROM customer WHERE flag=? and customer_name like '%"+keyword+"%' LIMIT ?,?";
            List<Customer> customerList = CUSTOMERDAO.getCustomerList(cn, sql, Customer.class, flag, offset, pageSize);
            String sql1 = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            String sql2 = "SELECT source_id as sourceId,source_name as sourceName FROM sources WHERE source_id=?";
            String sql3 = "SELECT industry_id as industryId,industry_name as industryName FROM industry WHERE industry_id=?";
            String sql4 = "SELECT level_id as levelId,level_name as levelName FROM levels WHERE level_id=?";
            for (Customer customer : customerList) {
                Employee personLiable = employeeDao.getEmployeeByEmployeeId(cn, sql1, Employee.class, customer.getPersonLiableId());
                Employee founder = employeeDao.getEmployeeByEmployeeId(cn, sql1, Employee.class, customer.getFounderId());
                Sources source = sourcesDao.getSourcesBySouceId(cn, sql2, Sources.class, customer.getSourceId());
                Industry industry = industryDao.getIndustryByIndustryId(cn, sql3, Industry.class, customer.getIndustryId());
                Levels level = levelsDao.getLevelsByLevelId(cn, sql4, Levels.class, customer.getLevelId());
                customer.setPersonLiable(personLiable);
                customer.setFounder(founder);
                customer.setSource(source);
                customer.setIndustry(industry);
                customer.setLevel(level);
            }
            sql = "SELECT COUNT(*) as count FROM customer WHERE customer_name like '%"+keyword+"%' and flag=" + flag;
            int count = CUSTOMERDAO.getCustomerCount(cn, sql);
            cn.commit();
            int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            page.setPageCount(pageCount);
            page.setHasPre(pageNo > 1);
            page.setHasNext(pageNo < pageCount);
            page.setObj(customerList);
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
    public Customer getCustomerByCustomerId(Integer customerId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT customer_id as customerId,customer_name as customerName,phone,status,person_liable_id as personLiableId,founder_id as founderId,source_id as sourceId,industry_id as industryId,level_id as levelId,create_time as createTime,update_time as updateTime,next_contact_time as nextContactTime FROM customer WHERE customer_id=?";
            Customer customer = CUSTOMERDAO.getCustomerByCustomerId(cn, sql, Customer.class, customerId);
            cn.commit();
            return customer;
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
    public List<Customer> getCustomerList(int flag) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT customer_id as customerId,customer_name as customerName,phone,status,person_liable_id as personLiableId,founder_id as founderId,source_id as sourceId,industry_id as industryId,level_id as levelId,create_time as createTime,update_time as updateTime,next_contact_time as nextContactTime FROM customer WHERE flag=?";
            List<Customer> customerList = CUSTOMERDAO.getCustomerList(cn, sql, Customer.class, flag);
            String sql1 = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            String sql2 = "SELECT source_id as sourceId,source_name as sourceName FROM sources WHERE source_id=?";
            String sql3 = "SELECT industry_id as industryId,industry_name as industryName FROM industry WHERE industry_id=?";
            String sql4 = "SELECT level_id as levelId,level_name as levelName FROM levels WHERE level_id=?";
            for (Customer customer : customerList) {
                Employee personLiable = employeeDao.getEmployeeByEmployeeId(cn, sql1, Employee.class, customer.getPersonLiableId());
                Employee founder = employeeDao.getEmployeeByEmployeeId(cn, sql1, Employee.class, customer.getFounderId());
                Sources source = sourcesDao.getSourcesBySouceId(cn, sql2, Sources.class, customer.getSourceId());
                Industry industry = industryDao.getIndustryByIndustryId(cn, sql3, Industry.class, customer.getIndustryId());
                Levels level = levelsDao.getLevelsByLevelId(cn, sql4, Levels.class, customer.getLevelId());
                customer.setPersonLiable(personLiable);
                customer.setFounder(founder);
                customer.setSource(source);
                customer.setIndustry(industry);
                customer.setLevel(level);
            }
            cn.commit();
            return customerList;
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
    public int getCustomerCount(Date start, Date end) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT COUNT(*) as count FROM customer WHERE create_time BETWEEN ? AND ?";
            int count = CUSTOMERDAO.getCustomerCount(cn, sql, start, end);
            cn.commit();
            return count;
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
        return 0;
    }


}
