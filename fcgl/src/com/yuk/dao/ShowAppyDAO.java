package com.yuk.dao;

import com.yuk.bean.ApplyShow;

import java.sql.Connection;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 16:21
 */
public interface ShowAppyDAO {
    //1.根据id查询所有的apply（用户用的）
    List<ApplyShow> queryAllAS(Connection con, int id);
}
