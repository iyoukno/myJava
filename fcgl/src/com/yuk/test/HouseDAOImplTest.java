package com.yuk.test;

import com.google.gson.Gson;
import com.yuk.bean.HouseInfo;
import com.yuk.dao.impl.HouseDAOImpl;
import com.yuk.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 11:40
 */
public class HouseDAOImplTest {

    @Test
    public void queryAllHouse() throws SQLException {
        Connection connections = JDBCutils.getConnections();
        HouseDAOImpl houseDAO = new HouseDAOImpl();
        List<HouseInfo> houseInfos = houseDAO.queryAllHouse(connections);
        Gson gson = new Gson();
        String s = gson.toJson(houseInfos);
        System.out.println(s);
//        System.out.println("====================");
//        houseInfos.forEach(System.out::println);
    }

    @Test
    public void QueryHouseByType() throws SQLException {
        Connection connections = JDBCutils.getConnections();
        HouseDAOImpl houseDAO = new HouseDAOImpl();
        List<HouseInfo> houseInfos = houseDAO.QueryHouseByType(connections,"两室",0,5);
        Gson gson = new Gson();
        String s1 = gson.toJson(houseInfos);
        System.out.println(s1);
        System.out.println("====================");
        houseInfos.forEach(System.out::println);
    }

    @Test
    public void QueryHouseByRegion() throws SQLException {
        Connection connections = JDBCutils.getConnections();
        HouseDAOImpl houseDAO = new HouseDAOImpl();
        List<HouseInfo> houseInfos = houseDAO.QueryHouseByRegion(connections,"广陵区",0,5);
        Gson gson = new Gson();
        String s1 = gson.toJson(houseInfos);
        System.out.println(s1);
        System.out.println("====================");
        houseInfos.forEach(System.out::println);
    }
}