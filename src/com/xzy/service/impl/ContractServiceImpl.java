package com.xzy.service.impl;

import com.xzy.dao.*;
import com.xzy.dao.impl.*;
import com.xzy.dto.ContractProductResult;
import com.xzy.dto.Page;
import com.xzy.dto.ProductResult;
import com.xzy.entity.*;
import com.xzy.service.ContractService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {

    private final ContractDao CONTRACTDAO = new ContractDaoImpl();
    private final EmployeeDao EMPLOYEEDAO = new EmployeeDaoImpl();
    private final CustomerDao CUSTOMERDAO = new CustomerDaoImpl();
    private final ProductDao PRODUCTDAO = new ProductDaoImpl();
    private final ContractProductDao CONTRACTPRODUCTDAO = new ContractProductDaoImpl();

    @Override
    public void addContract(Contract contract) {
        //System.out.println("contract-service： "+contract);
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "INSERT INTO contract(contract_name,customer_id,contract_money,customer_signer,employee_signer_id,employee_responsible_id,employee01_id,employee02_id,flag,start_time,end_time,contract_url)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            int contractId = CONTRACTDAO.addContract(cn, sql, contract.getContractName(), contract.getCustomerId(), contract.getContractMoney(), contract.getCustomerSigner(), contract.getEmployeeSignerId(), contract.getEmployeeResponsibleId(), contract.getEmployee01Id(), contract.getEmployee02Id(), contract.getFlag(), contract.getStartTime(), contract.getEndTime(), contract.getContractUrl());

            List<Map<String, Integer>> productStockList = contract.getProductStockList();
            //向中间表插入产品及产品数量
            sql = "INSERT INTO contract_product(contract_id,product_id,num)VALUES(?,?,?)";
            for (Map<String, Integer> map : productStockList) {
                CONTRACTPRODUCTDAO.addContractProductMapping(cn, sql, contractId, map.get("productId"), map.get("productNum"));
            }
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
    public void deleteContract(Integer contractId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "DELETE FROM contract_product WHERE contract_id=?";
            CONTRACTPRODUCTDAO.deleteContractProductMapping(cn, sql, contractId);
            sql = "DELETE FROM contract WHERE contract_id=?";
            CONTRACTDAO.deleteContract(cn, sql, contractId);
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
    public Page getContractPages(int pageNo, int pageSize, String keyword) {
        int offset = (pageNo - 1) * pageSize;
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT contract_id as contractId,contract_name as contractName,customer_id as customerId,contract_money as contractMoney,customer_signer as customerSigner,employee_signer_id as employeeSignerId,employee_responsible_id as employeeResponsibleId,employee01_id as employee01Id,employee02_id as employee02Id,flag,start_time as startTime,end_time as endTime,contract_url as contractUrl FROM contract WHERE contract_name like '%" + keyword + "%' LIMIT ?,?";
            List<Contract> contractList = CONTRACTDAO.getContractList(cn, sql, Contract.class, offset, pageSize);
            sql = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            String sql2 = "SELECT customer_id as customerId,customer_name as customerName FROM customer WHERE customer_id=?";
            for (Contract contract : contractList) {
                Employee employeeSigner = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployeeSignerId());
                contract.setEmployeeSigner(employeeSigner);
                Employee employeeResponsible = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployeeResponsibleId());
                contract.setEmployeeResponsible(employeeResponsible);
                Employee employee01 = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployee01Id());
                contract.setEmployee01(employee01);
                Employee employee02 = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployee02Id());
                contract.setEmployee02(employee02);
                Customer customer = CUSTOMERDAO.getCustomerByCustomerId(cn, sql2, Customer.class, contract.getCustomerId());
                contract.setCustomer(customer);
            }
            sql = "SELECT COUNT(*) as count FROM contract WHERE contract_name like '%" + keyword + "%'";
            int count = CONTRACTDAO.getContractCount(cn, sql);
            int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            page.setPageCount(pageCount);
            page.setHasPre(pageNo > 1);
            page.setHasNext(pageNo < pageCount);
            page.setObj(contractList);
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
        } finally {
            JdbcUtils.close();
        }
        return page;
    }

    @Override
    public ContractProductResult getContractByContractId(Integer contractId) {

        ContractProductResult contractProductResult = new ContractProductResult();

        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT contract_id as contractId,contract_name as contractName,customer_id as customerId,contract_money as contractMoney,customer_signer as customerSigner,employee_signer_id as employeeSignerId,employee_responsible_id as employeeResponsibleId,employee01_id as employee01Id,employee02_id as employee02Id,flag,start_time as startTime,end_time as endTime,contract_url as contractUrl FROM contract WHERE contract_id=?";
            Contract contract = CONTRACTDAO.getContractByContractId(cn, sql, Contract.class, contractId);
            sql = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            Employee employeeResponsible = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployeeResponsibleId());
            contract.setEmployeeResponsible(employeeResponsible);
            Employee employee01 = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployee01Id());
            contract.setEmployee01(employee01);
            Employee employee02 = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, contract.getEmployee02Id());
            contract.setEmployee02(employee02);
            sql = "SELECT contract_product_id as contractProductId,contract_id as contractId,product_id as productId,num FROM contract_product WHERE contract_id=?";
            List<ContractProductMapping> contractProductList = CONTRACTPRODUCTDAO.getContractProductList(cn, sql, ContractProductMapping.class, contractId);
            sql = "SELECT product_id as productId,product_name as productName,product_code as productCode,product_category_id as productCategoryId,price,founder_id as founderId,create_time as createTime,update_time as updateTime,flag FROM product WHERE product_id=?";

            List<Product> ps = new ArrayList<>();
            List<ProductResult> prs = new ArrayList<>();
            for (ContractProductMapping cpm : contractProductList) {
                Product product = PRODUCTDAO.getProductByProductId(cn, sql, Product.class, cpm.getProductId());
                if (product != null) {
                    ps.add(product);
                    ProductResult pr = new ProductResult();
                    pr.setProductCode(product.getProductCode());
                    pr.setProductName(product.getProductName());
                    pr.setNum(cpm.getNum());
                    pr.setPrice(product.getPrice());
                    double total = cpm.getNum() * product.getPrice();
                    pr.setTotal(total);
                    prs.add(pr);
                }
            }
            contract.setProductList(ps);
            contractProductResult.setContract(contract);
            contractProductResult.setProductResults(prs);
            cn.commit();
            return contractProductResult;
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
    public List<Contract> getContractListByEmployeeId(Integer employeeId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT contract_id as contractId,contract_name as contractName,customer_id as customerId,contract_money as contractMoney,customer_signer as customerSigner,employee_signer_id as employeeSignerId,employee_responsible_id as employeeResponsibleId,employee01_id as employee01Id,employee02_id as employee02Id,flag,start_time as startTime,end_time as endTime,contract_url as contractUrl FROM contract WHERE employee01_id=? or employee02_id=?";
            List<Contract> contractList = CONTRACTDAO.getContractList(cn, sql, Contract.class, employeeId, employeeId);
            cn.commit();
            return contractList;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
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
    public void updateContractFlag(Integer flag, Integer employeeId, Integer contractId, Integer status) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "";
            if (status == 1) {
                sql = "UPDATE contract SET flag=? WHERE employee01_id=? AND contract_id=?";
            } else if (status == 2) {
                sql = "UPDATE contract SET flag=? WHERE employee02_id=? AND contract_id=?";
            }
            CONTRACTDAO.updateContractFlag(cn, sql, flag, employeeId, contractId);
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
    public double getContractMoney(Date startTime, Date endTime) {
        Connection cn = null;
        double amount = 0.0;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT contract_money as contractMoney FROM contract WHERE start_time BETWEEN ? AND ? ";
            List<Contract> contractList = CONTRACTDAO.getContractList(cn, sql, Contract.class, startTime, endTime);
            for (Contract contract : contractList) {
                amount += contract.getContractMoney();
            }
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
        } finally {
            JdbcUtils.close();
        }
        return amount;
    }
}
