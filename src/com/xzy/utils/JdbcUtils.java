package com.xzy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> pool = new ThreadLocal<>();

    static {
        Properties p = new Properties();
        InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbinfo.properties");
        try {
            p.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection cn = pool.get();
        if (cn == null) {
            pool.set(dataSource.getConnection());
        }
        return pool.get();
    }

    public static void close() {
        Connection cn = pool.get();
        if (cn != null) {
            try {
                cn.close();
                pool.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }*/
}
