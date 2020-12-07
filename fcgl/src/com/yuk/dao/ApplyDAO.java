package com.yuk.dao;

import com.yuk.bean.Apply;
import com.yuk.bean.ApplyShow;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 15:57
 */
public interface ApplyDAO {


    //2.查询所有的apply（管理员用的）
    List<Apply> queryAllA(Connection con);

    //3.生成一个apply（用户用的）
    int addApply(Connection con,int userId,int houseId);

    //判断是否申请过
    boolean isApplied(Connection con,int userId,int houseId);

    //4 管理员处理用户的申请(根据申请编号)
    String HandleApply(Connection con,int id,int status);
}
