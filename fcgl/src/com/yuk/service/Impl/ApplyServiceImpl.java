package com.yuk.service.Impl;

import com.yuk.bean.Apply;
import com.yuk.dao.ApplyDAO;
import com.yuk.dao.impl.ApplyDAOImpl;
import com.yuk.service.ApplyService;
import com.yuk.utils.JDBCutils;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 16:49
 */
public class ApplyServiceImpl implements ApplyService {
    private Connection con;

    {
        try {
            con = JDBCutils.getConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private ApplyDAO applyDAO=new ApplyDAOImpl();
    @Override
    public List<Apply> getAllA() {
        List<Apply> applies = applyDAO.queryAllA(con);
        return applies;

    }

    @Override
    public int createOneApply( int userId, int houseId) {
        int i = applyDAO.addApply(con, userId, houseId);
        return i;
    }

    @Override
    public boolean isApplied(int userId, int houseId) {
        boolean applied = applyDAO.isApplied(con, userId, houseId);
        return applied;
    }
}
