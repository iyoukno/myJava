package com.yuk.service;

import com.yuk.bean.User;

import java.io.InputStream;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 11:51
 */
public interface UserService {
    //1.登录
    User login(String username,String password);

    //2.注册
    int register(User user);

    //3.判断用户是否存在
    boolean existsUser(String username);

    //4/上传头像
    int upPhoto(String path,int id);

    //5 查找头像
    String getPhoto(int id);
}
