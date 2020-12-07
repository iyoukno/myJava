package com.yuk.test;

import com.yuk.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/24 15:31
 */
public class JDBCConTest {
    @Test
    public void test1() throws SQLException {
        Connection connections = JDBCutils.getConnections();
        System.out.println(connections);
    }
}
