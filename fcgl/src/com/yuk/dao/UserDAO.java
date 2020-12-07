package com.yuk.dao;

import com.yuk.bean.User;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 14:05
 */
public interface UserDAO {
    User queryUserByNameAndPw(Connection con,String username,String password);

    int addAUser(Connection con,User user);

    User queryUserByName(Connection con,String username);

    int upUserPhoto(Connection con, String path,int id);

    String queryPortrait(Connection con,int id);

    List<User> queryAllUser(Connection con);

    void delUserById(Connection con,int id);
}
