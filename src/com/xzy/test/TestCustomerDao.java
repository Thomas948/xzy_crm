package com.xzy.test;

import com.xzy.dao.CustomerDao;
import com.xzy.dao.impl.CustomerDaoImpl;
import com.xzy.entity.Customer;
import com.xzy.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestCustomerDao {

    private final CustomerDao CUSTOMERDAO = new CustomerDaoImpl();

    @Test
    public void testAddCustomer() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "INSERT INTO customer (customer_name,phone,status,person_liable_id,founder_id,source_id,industry_id,level_id,create_time,update_time,next_contact_time,flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        CUSTOMERDAO.addCustomer(cn,sql,"王德发","13545174101",0,10000,10001,10002,10002,10002,new Date(),new Date(),new Date(),0);
    }

    @Test
    public void testDeleteCustomer() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "DELETE FROM customer WHERE customer_id=?";
        CUSTOMERDAO.deleteCustomer(cn,sql,10003);
    }

    @Test
    public void testUpdateCustomer() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "UPDATE customer SET customer_name=?,phone=?,status=?,person_liable_id=?,founder_id=?,source_id=?,industry_id=?,level_id=?,create_time=?,update_time=?,next_contact_time=?,flag=? WHERE customer_id=?";
        CUSTOMERDAO.updateCustomer(cn,sql,"高不兴","17545170000",1,10001,10000,10001,10001,10001,new Date(),new Date(),new Date(),1,10002);
    }

    @Test
    public void test4() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT customer_id as customerId,customer_name as customerName,phone,status,person_liable_id as personLiableId,founder_id as founderId,source_id as sourceId,industry_id as industryId,level_id as levelId,create_time as createTime,update_time as updateTime,next_contact_time as nextContactTime,flag FROM customer";
        List<Customer> customers = CUSTOMERDAO.getCustomerList(cn, sql, Customer.class);
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
    }

    @Test
    public void test5() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT customer_id as customerId,customer_name as customerName,phone,status,person_liable_id as personLiableId,founder_id as founderId,source_id as sourceId,industry_id as industryId,level_id as levelId,create_time as createTime,update_time as updateTime,next_contact_time as nextContactTime,flag FROM customer WHERE customer_id=?";
        Customer customer = CUSTOMERDAO.getCustomerByCustomerId(cn, sql, Customer.class, 10001);
            System.out.println(customer);
    }
}
