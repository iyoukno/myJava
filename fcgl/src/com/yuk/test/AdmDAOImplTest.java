package com.yuk.test;

import com.yuk.bean.Adm;
import com.yuk.dao.impl.AdmDAOImpl;
import com.yuk.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:45
 */
public class AdmDAOImplTest {

    @Test
    public void findAdm() throws SQLException {
        Connection connections = JDBCutils.getConnections();
        AdmDAOImpl admDAO = new AdmDAOImpl();
        Adm adm = admDAO.queryAdm(connections);
        System.out.println(adm);
    }
}