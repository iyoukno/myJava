package com.yuk.dao;

import com.yuk.bean.HouseInfo;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;


/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 11:04
 */
public interface HouseDAO {
    //1 找出所有的房源
    List<HouseInfo> queryAllHouse(Connection con);

    //2.根据id来删除数据
    int deleteHouseInfoById(Connection con, int id);

    //3 根据户型查询出某些房源
    List<HouseInfo> QueryHouseByType(Connection con ,String Type,int begin,int count);

    //4 根据价格查询出某些房源
    List<HouseInfo> QueryHouseByPrice(Connection con , BigDecimal price,int begin,int count);
    //5 根据地区来查询某些房源
    List<HouseInfo> QueryHouseByRegion(Connection con ,String region,int begin,int count);

    //6.分页查询
    List<HouseInfo> queryHouseByPage(Connection con,int begin,int count);

    //7.新增一个房产信息
    void addAHouseInfo(Connection con, HouseInfo houseInfo);

}