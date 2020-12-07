package com.yuk.service;

import com.yuk.bean.ApplyShow;

import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/2 9:07
 */
public interface ApplyShowService {
    //1.根据用户id查到的所有申请单
    List<ApplyShow> getAll(int id);
}
