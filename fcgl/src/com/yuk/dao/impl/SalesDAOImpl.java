package com.yuk.dao.impl;

import com.yuk.bean.SalesMan;
import com.yuk.dao.BaseDAO;
import com.yuk.dao.SalesDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 10:35
 */
public class SalesDAOImpl extends BaseDAO<SalesMan> implements SalesDAO {
    @Override
    public List<SalesMan> queryAll(Connection con) {
        String sql="select id,name,gender,tel from t_salesman";
        List<SalesMan> instances = getInstances(con, sql);
        return instances;
    }

    @Override
    public SalesMan queryById(Connection con, int id) {
        String sql="select name,gender,tel from t_salesman where id=?";
        SalesMan instance = getInstance(con, sql, id);
        return instance;
    }
}
