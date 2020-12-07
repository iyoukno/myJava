package com.yuk.service.Impl;

import com.yuk.bean.HouseInfo;
import com.yuk.dao.HouseDAO;
import com.yuk.dao.impl.HouseDAOImpl;
import com.yuk.service.HouseService;
import com.yuk.utils.JDBCutils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 14:52
 */
public class HouseServiceimpl implements HouseService {
    private Connection con;

    {
        try {
        con = JDBCutils.getConnections();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private HouseDAO houseDAO=new HouseDAOImpl();
    @Override
    public List<HouseInfo> getHouseByType( String type,int begin,int count) {
        List<HouseInfo> houseInfos = houseDAO.QueryHouseByType(con, type,begin,count);
        return houseInfos;
    }

    @Override
    public List<HouseInfo> getHouseByPrice(BigDecimal price,int begin,int count) {
        List<HouseInfo> houseInfos = houseDAO.QueryHouseByPrice(con, price,begin,count);
        return houseInfos;
    }

    @Override
    public List<HouseInfo> getAllHouse() {
        List<HouseInfo> houseInfos = houseDAO.queryAllHouse(con);
        return houseInfos;
    }

    @Override
    public void delHouseById(int id) {
        houseDAO.deleteHouseInfoById(con, id);
    }

    @Override
    public List<HouseInfo> getHouseByRegion(String region,int begin,int count) {
        List<HouseInfo> houseInfos = houseDAO.QueryHouseByRegion(con, region,begin,count);
        return houseInfos;
    }

    @Override
    public List<HouseInfo> getAllHouseByPage(int begin, int count) {
        List<HouseInfo> houseInfos = houseDAO.queryHouseByPage(con, begin, count);
        return houseInfos;
    }
}
