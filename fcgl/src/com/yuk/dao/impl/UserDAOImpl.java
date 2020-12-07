package com.yuk.dao.impl;

import com.yuk.bean.User;
import com.yuk.dao.BaseDAO;
import com.yuk.dao.UserDAO;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 14:09
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User queryUserByNameAndPw(Connection con, String username, String password) {
        String sql="select id,username,password,age,gender,photo_path photoPath,phone from t_user where username=? and password=?";
        User instance = getInstance(con, sql, username, password);
        return instance;
    }

    @Override
    public int addAUser(Connection con, User user) {
        String sql="insert into t_user(username,password,age,gender,photo_path,phone) value(?,?,?,?,?,?)";
        update(con,sql,user.getName(),user.getPassword(),user.getAge(),user.getGender(),user.getPhotoPath(),user.getPhone());
        return 1;
    }

    @Override
    public User queryUserByName(Connection con, String username) {
        String sql="select id,username,password,age,gender,photo_path photoPath,phone from t_user where username=?";
        User instance = getInstance(con, sql, username);
        return instance;
    }

    @Override
    public int upUserPhoto(Connection con, String path ,int id) {
        String sql="update t_user set photo_path=? where id=?";
        update(con,sql,path,id);
        return 1;
    }

    @Override
    public String queryPortrait(Connection con, int id) {
        String sql="select photo_path photoPath from t_user where id=?";
        User instance = getInstance(con, sql, id);
        String  photoPath = instance.getPhotoPath();
        return photoPath;
    }

    @Override
    public List<User> queryAllUser(Connection con) {
        String sql="select id,username,password,age,gender,photo_path photoPath,phone from t_user";
        List<User> instances = getInstances(con, sql);
        return instances;
    }

    @Override
    public void delUserById(Connection con,int id) {
        String sql="delete from t_user where id= ?";
        update(con,sql,id);
    }
}
