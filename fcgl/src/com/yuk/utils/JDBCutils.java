package com.yuk.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/5 16:19
 */
public class JDBCutils {
    //1.获取连接
    static private DataSource druidDataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<>();
    static {
        try {
            Properties properties = new Properties();
//            InputStream is = new FileInputStream(new File("E:\\ideaimportpro\\javaweb\\bookcity\\src\\druid.properties"));
            properties.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            druidDataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnections() throws SQLException {
        Connection con = conns.get();
        if (con==null){
            con=druidDataSource.getConnection();
            conns.set(con);
            con.setAutoCommit(true);
        }
        return con;
    }

    public static void closeAndCommit(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    public static void RollBackAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }





    //2.断开连接
    public static void close(Connection connection, Statement sql){
        try {
            if (connection!=null){
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (sql!=null){
                sql.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con, Statement ps, ResultSet rs) {
        try {
            if(ps!=null) {
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
