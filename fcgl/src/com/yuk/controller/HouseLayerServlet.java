package com.yuk.controller;

import com.yuk.bean.SalesMan;
import com.yuk.service.HouseService;
import com.yuk.service.Impl.HouseServiceimpl;
import com.yuk.service.Impl.SalesManServiceImpl;
import com.yuk.service.SalesService;
import com.yuk.utils.WebUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 9:25
 */
public class HouseLayerServlet extends BaseServlet {
    private SalesService salesService=new SalesManServiceImpl();

    protected void HouseDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取房屋id参数
        String houseId = req.getParameter("houseId");
        String img_path = req.getParameter("img_path");
        String salesId = req.getParameter("salesId");



        //根据id查出其销售人姓名，联系电话（保存到requestScope中）
        Integer id = WebUtils.parseInt(salesId, 0);
        SalesMan oneSalesMan = salesService.getOneSalesMan(id);

//        req.setAttribute("salesname",oneSalesMan.getName());
//        req.setAttribute("salestel",oneSalesMan.getTel());
//        req.setAttribute("img_path",img_path);
        req.setAttribute("salesname",oneSalesMan.getName());
        req.setAttribute("salestel",oneSalesMan.getTel());
        req.setAttribute("img_path",img_path);

       req.getRequestDispatcher("/pages/user/houseInfo.jsp").forward(req,resp);
    }
}
