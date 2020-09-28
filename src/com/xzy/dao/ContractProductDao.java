package com.xzy.dao;

import com.xzy.entity.ContractProductMapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ContractProductDao {

    void addContractProductMapping(Connection cn, String sql, Object... args) throws SQLException;

    void deleteContractProductMapping(Connection cn, String sql, Object... args) throws SQLException;

    List<ContractProductMapping> getContractProductList(Connection cn, String sql, Class<ContractProductMapping> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
