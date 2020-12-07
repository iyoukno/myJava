package com.yuk.dao;

import com.yuk.bean.SalesMan;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 10:34
 */
public interface SalesDAO  {
    //查全部
    List<SalesMan> queryAll(Connection con);


    //根据id查salesman
    SalesMan queryById(Connection con, int id);

}
