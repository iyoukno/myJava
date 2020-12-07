package com.yuk.service.Impl;

import com.yuk.bean.SalesMan;
import com.yuk.dao.SalesDAO;
import com.yuk.dao.impl.SalesDAOImpl;
import com.yuk.service.SalesService;
import com.yuk.utils.JDBCutils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 10:31
 */
public class SalesManServiceImpl implements SalesService {
    private Connection con;

    {
        try {
            con = JDBCutils.getConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private SalesDAO salesDAO=new SalesDAOImpl();
    @Override
    public SalesMan getOneSalesMan(int id) {
        SalesMan salesMan = salesDAO.queryById(con, id);
        return salesMan;
    }
}
