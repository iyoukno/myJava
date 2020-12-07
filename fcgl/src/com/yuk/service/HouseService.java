package com.yuk.service;

import com.yuk.bean.HouseInfo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 14:47
 */
public interface HouseService {
    //1. 查询不同户型的数据
    List<HouseInfo> getHouseByType(String type,int begin,int count);

    //2. 查询0-x价格去加的数据
    List<HouseInfo> getHouseByPrice( BigDecimal price,int begin,int count);

    //3.查询所有房源
    List<HouseInfo> getAllHouse();

    //4.根据id删除房源信息（管理员用）
    void delHouseById(int id);

    //5 查询某个地区的所有房源
    List<HouseInfo> getHouseByRegion(String region,int begin,int count);

    //分页查询所有房源
    List<HouseInfo> getAllHouseByPage(int begin,int count);

    ;
}
