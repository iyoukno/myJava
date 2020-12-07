package com.yuk.dao.impl;

import com.yuk.bean.Apply;
import com.yuk.bean.ApplyShow;
import com.yuk.dao.ApplyDAO;
import com.yuk.dao.BaseDAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 16:04
 */
public class ApplyDAOImpl extends BaseDAO<Apply> implements ApplyDAO {

    @Override
    public List<Apply> queryAllA(Connection con) {
        String sql="select id,user_id userId,house_id houseId,date,status from t_apply";
        List<Apply> instances = getInstances(con, sql);
        return instances;
    }

    @Override
    public int addApply(Connection con,int userId,int houseId) {
        String sql="insert into t_apply(user_id,house_id,date,status) values(?,?,?,?)";
        Date date = new Date(System.currentTimeMillis());
        update(con,sql,userId,houseId,date,0);
        return 1;
    }

    @Override
    public boolean isApplied(Connection con, int userId, int houseId) {
        String sql="select id,user_id userId,house_id houseId,date,status from t_apply " +
                "where user_id=? and house_id=?";
        Apply instance = getInstance(con, sql, userId, houseId);
        if (instance==null){
            return false;
        }
        return true;
    }

    @Override
    public String HandleApply(Connection con,int id,int status) {
        String sql="update t_apply set status=? where id=?";
        update(con,sql,status,id);
        return "success";
    }
}
