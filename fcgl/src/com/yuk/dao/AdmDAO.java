package com.yuk.dao;

import com.yuk.bean.Adm;

import java.sql.Connection;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:35
 */
public interface AdmDAO {
    //1.从数据库中查找adm数据
    Adm queryAdm(Connection con);
}
