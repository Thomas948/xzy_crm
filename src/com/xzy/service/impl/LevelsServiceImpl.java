package com.xzy.service.impl;

import com.xzy.dao.LevelsDao;
import com.xzy.dao.impl.LevelsDaoImpl;
import com.xzy.entity.Category;
import com.xzy.entity.Levels;
import com.xzy.service.LevelsService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LevelsServiceImpl implements LevelsService {

    private LevelsDao levelsDao = new LevelsDaoImpl();

    @Override
    public List<Levels> getLevelsList() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT level_id as levelId,level_name as levelName FROM levels";
            List<Levels> levelsList = levelsDao.getLevelsList(cn, sql, Levels.class);
            cn.commit();
            return levelsList;
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
    public Levels getLevelsByLevelId(Integer levelId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT level_id as levelId,level_name as levelName FROM levels WHERE level_id = ?";
            Levels level = levelsDao.getLevelsByLevelId(cn, sql, Levels.class, levelId);
            cn.commit();
            return level;
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
