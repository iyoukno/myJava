package com.yuk.test;

import com.yuk.bean.Adm;
import com.yuk.service.Impl.AdmServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 10:09
 */
public class AdmServiceImplTest {

    @Test
    public void findAdm() {
        AdmServiceImpl admService = new AdmServiceImpl();
        Adm adm = admService.findAdm();
        System.out.println(adm);
    }
}