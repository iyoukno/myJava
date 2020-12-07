package com.yuk.dao.impl;

import com.yuk.bean.Adm;
import com.yuk.dao.AdmDAO;
import com.yuk.dao.BaseDAO;

import java.sql.Connection;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:37
 */
public class AdmDAOImpl extends BaseDAO<Adm> implements AdmDAO {
    @Override
    public Adm queryAdm(Connection con) {
        String sql="select * from t_adm";
        Adm instance = getInstance(con, sql);
        return instance;
    }
}
