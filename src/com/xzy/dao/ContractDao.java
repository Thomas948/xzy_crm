package com.xzy.dao;

import com.xzy.entity.Contract;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ContractDao {

    int addContract(Connection cn, String sql, Object... args) throws SQLException;

    void deleteContract(Connection cn, String sql, Object... args) throws SQLException;

    List<Contract> getContractList(Connection cn, String sql, Class<Contract> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    int getContractCount(Connection cn, String sql) throws SQLException;

    Contract getContractByContractId(Connection cn, String sql, Class<Contract> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    void updateContractFlag(Connection cn, String sql, Object... args) throws SQLException;
}
