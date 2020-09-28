package com.xzy.service.impl;

import com.xzy.dao.IndustryDao;
import com.xzy.dao.impl.IndustryDaoImpl;
import com.xzy.entity.Industry;
import com.xzy.entity.Levels;
import com.xzy.service.IndustryService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IndustryServiceImpl implements IndustryService {

    private IndustryDao industryDao = new IndustryDaoImpl();

    @Override
    public List<Industry> getIndustryList() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT industry_id as industryId,industry_name as industryName FROM industry";
            List<Industry> industryList = industryDao.getIndustryList(cn, sql, Industry.class);
            cn.commit();
            return industryList;
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
    public Industry getIndustryByIndustryId(Integer industryId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT industry_id as industryId,industry_name as industryName FROM industry WHERE industry_id = ?";
            industryDao.getIndustryByIndustryId(cn,sql,Industry.class,industryId);
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
        return null;
    }
}
