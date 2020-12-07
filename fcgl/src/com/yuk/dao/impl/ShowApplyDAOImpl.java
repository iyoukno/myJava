package com.yuk.dao.impl;

import com.yuk.bean.ApplyShow;
import com.yuk.dao.BaseDAO;
import com.yuk.dao.ShowAppyDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 16:21
 */
public class ShowApplyDAOImpl extends BaseDAO<ApplyShow> implements ShowAppyDAO {
    @Override
    public List<ApplyShow> queryAllAS(Connection con,int id) {
        String sql="SELECT ta.Id ,tu.username userName,th.title houseName,ta.date,ta.status FROM " +
                "((t_apply ta LEFT JOIN t_user tu ON ta.user_id = tu.id) " +
                "LEFT JOIN t_houseinfo th ON ta.house_id = th.id) where tu.id=?";
        List<ApplyShow> instances = getInstances(con, sql,id);
        return instances;
    }
}
