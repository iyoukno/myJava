package com.yuk.dao.impl;

import com.yuk.bean.Region;
import com.yuk.dao.BaseDAO;
import com.yuk.dao.RegionDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/3 14:48
 */
public class RegionDAOImpl extends BaseDAO<Region> implements RegionDAO {
    @Override
    public List<Region> queryAllRegion(Connection con) {
        String sql="select id,region_name regionName from t_region";
        List<Region> instances = getInstances(con, sql);
        return instances;
    }
}
