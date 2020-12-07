package com.yuk.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/24 15:26
 */
public abstract class BaseDAO<T> {
    private Class<T> clazz=null;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType=(ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz=(Class<T>)actualTypeArguments[0];
    }
    //1.针对不同表的增删改操作
    public void update(Connection con, String sql, Object ...arg) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(con,sql,arg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    //2.查询一个用户
    public T getInstance(Connection con,String sql,Object ...arg) {
        QueryRunner queryRunner = new QueryRunner();
        BeanHandler<T> userBeanHandler = new BeanHandler<T>(clazz);
        T yuk = null;
        try {
            yuk = queryRunner.query(con, sql, userBeanHandler,arg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return yuk;
    }

    //3.查询多个用户
    public List<T> getInstances(Connection con , String sql, Object ...arg) {
        QueryRunner queryRunner = new QueryRunner();
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(clazz);
        List<T> list = null;
        try {
            list = queryRunner.query(con, sql, beanListHandler, arg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    //查询特殊值
    public <E> E getValue(Connection con,String sql,Object ...arg) {
        QueryRunner queryRunner = new QueryRunner();
        ScalarHandler scalarHandler = new ScalarHandler();
        E query = null;
        try {
            query = (E)queryRunner.query(con, sql, scalarHandler,arg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        System.out.println(query);
        return query;
    }
}
