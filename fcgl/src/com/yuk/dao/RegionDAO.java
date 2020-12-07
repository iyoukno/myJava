package com.yuk.dao;

import com.yuk.bean.Region;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/3 14:47
 */
public interface RegionDAO {
    List<Region> queryAllRegion(Connection con);
}
