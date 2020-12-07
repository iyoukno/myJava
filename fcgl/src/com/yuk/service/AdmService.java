package com.yuk.service;

import com.sun.deploy.security.BadCertificateDialog;
import com.yuk.bean.*;

import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:57
 */
public interface AdmService {

    //1.查找adm
    Adm findAdm();

    //2.删除用户（慎用）
    void deleteUserById(int id);
    //3.查找所有user
    List<User> getAllUser();
    //4.查询所有房屋信息
    List<HouseInfo> getAllHouse();

    //5.新增房屋信息
    void addAHouse(HouseInfo houseInfo);

    //6.查找所有区域
    List<Region> getRegionInfo();

    //7.申请的审批
    void handleApply(int id,int status);

    //8.查询所有的apply
    List<Apply> getAllApply();

    void delHouseById(int id);

}
