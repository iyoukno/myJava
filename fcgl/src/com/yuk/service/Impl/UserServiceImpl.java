package com.yuk.service.Impl;

import com.yuk.bean.User;
import com.yuk.dao.UserDAO;
import com.yuk.dao.impl.UserDAOImpl;
import com.yuk.service.UserService;
import com.yuk.utils.JDBCutils;
import jdk.nashorn.internal.scripts.JD;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 11:59
 */
public class UserServiceImpl implements UserService {
    private Connection con;

    {
        try {
            con = JDBCutils.getConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private UserDAO userDAO=new UserDAOImpl();
    @Override
    public User login(String username, String password) {
        User user = userDAO.queryUserByNameAndPw(con, username, password);
        return user;
    }

    @Override
    public int register(User user) {
        int i = userDAO.addAUser(con, user);
        return i;
    }

    @Override
    public boolean existsUser(String username) {
        User user = userDAO.queryUserByName(con, username);
        if (user!=null){
            return true;
        }
        return false;
    }

    @Override
    public int upPhoto(String path,int id) {
        userDAO.upUserPhoto(con,path,id);
        return 1;
    }

    @Override
    public String getPhoto(int id) {
        String portraitpath = userDAO.queryPortrait(con, id);
        return portraitpath;
    }


}
