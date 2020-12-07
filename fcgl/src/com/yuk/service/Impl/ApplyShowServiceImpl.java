package com.yuk.service.Impl;

import com.yuk.bean.ApplyShow;
import com.yuk.dao.ShowAppyDAO;
import com.yuk.dao.impl.ShowApplyDAOImpl;
import com.yuk.service.ApplyShowService;
import com.yuk.utils.JDBCutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/2 9:08
 */
public class ApplyShowServiceImpl implements ApplyShowService {
    private Connection con;

    {
        try {
            con = JDBCutils.getConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private ShowAppyDAO sa=new ShowApplyDAOImpl();
    @Override
    public List<ApplyShow> getAll(int id) {
        List<ApplyShow> applyShows = sa.queryAllAS(con, id);
        return applyShows;
    }
}
