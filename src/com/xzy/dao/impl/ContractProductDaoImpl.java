package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.ContractProductDao;
import com.xzy.entity.ContractProductMapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ContractProductDaoImpl extends BaseDao<ContractProductMapping> implements ContractProductDao {
    @Override
    public void addContractProductMapping(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public void deleteContractProductMapping(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<ContractProductMapping> getContractProductList(Connection cn, String sql, Class<ContractProductMapping> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return getList(cn, sql, clazz, args);
    }
}
