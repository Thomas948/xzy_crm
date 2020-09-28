package com.xzy.service.impl;

import com.xzy.dao.SourcesDao;
import com.xzy.dao.impl.SourcesDaoImpl;
import com.xzy.entity.Sources;
import com.xzy.service.SourcesService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SourcesServiceImpl implements SourcesService {

    private SourcesDao sourcesDao = new SourcesDaoImpl();

    @Override
    public List<Sources> getSourcesList() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT source_id as sourceId,source_name as sourceName FROM sources";
            List<Sources> sourcesList = sourcesDao.getSourcesList(cn, sql, Sources.class);
            cn.commit();
            return sourcesList;
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
    public Sources getSourcesBySourceId(Integer sourceId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT source_id as sourceId,source_name as sourceName FROM sources WHERE source_id=?";
            Sources source = sourcesDao.getSourcesBySouceId(cn, sql, Sources.class, sourceId);
            cn.commit();
            return source;
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
}
