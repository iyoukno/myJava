package com.yuk.service;

import com.yuk.bean.Apply;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 16:44
 */
public interface ApplyService {

    //得到所有的apply
    List<Apply> getAllA();

    //新增一个apply
    int createOneApply(int userId,int houseId);

    //判断是否已申请过
    boolean isApplied(int userId,int houseId);

}
