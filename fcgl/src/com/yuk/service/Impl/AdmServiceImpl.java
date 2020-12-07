package com.yuk.service.Impl;

import com.yuk.bean.*;
import com.yuk.dao.*;
import com.yuk.dao.impl.*;
import com.yuk.service.AdmService;
import com.yuk.utils.JDBCutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 10:03
 */
public class AdmServiceImpl implements AdmService {
    private Connection con;

    {
        try {
            con = JDBCutils.getConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private AdmDAO admDAO=new AdmDAOImpl();
    private HouseDAO houseDAO=new HouseDAOImpl();
    private ApplyDAO applyDAO=new ApplyDAOImpl();
    private RegionDAO regionDAO=new RegionDAOImpl();
    private UserDAO userDAO=new UserDAOImpl();
    @Override
    public Adm findAdm() {
        Adm adm = admDAO.queryAdm(con);
        return adm;
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.delUserById(con,id);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userDAO.queryAllUser(con);
        return users;
    }

    @Override
    public List<HouseInfo> getAllHouse() {
        List<HouseInfo> houseInfos = houseDAO.queryAllHouse(con);
        return houseInfos;
    }

    @Override
    public void addAHouse(HouseInfo houseInfo) {
        houseDAO.addAHouseInfo(con,houseInfo);
    }

    @Override
    public List<Region> getRegionInfo() {
        List<Region> regions = regionDAO.queryAllRegion(con);
        return regions;
    }

    @Override
    public void handleApply(int id,int status) {
        applyDAO.HandleApply(con,id,status);
    }

    @Override
    public List<Apply> getAllApply() {
        List<Apply> applies = applyDAO.queryAllA(con);
        return applies;
    }

    @Override
    public void delHouseById(int id) {
        houseDAO.deleteHouseInfoById(con, id);
    }

}
