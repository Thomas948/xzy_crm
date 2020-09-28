package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.ContractDao;
import com.xzy.entity.Contract;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContractDaoImpl extends BaseDao<Contract> implements ContractDao {
    @Override
    public int addContract(Connection cn, String sql, Object... args) throws SQLException {
        return update(cn, sql, args);
    }

    @Override
    public void deleteContract(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Contract> getContractList(Connection cn, String sql, Class<Contract> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public int getContractCount(Connection cn, String sql) throws SQLException {
        return getCount(cn, sql);
    }

    @Override
    public Contract getContractByContractId(Connection cn, String sql, Class<Contract> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }

    @Override
    public void updateContractFlag(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }
}
