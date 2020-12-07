package com.yuk.controller;

import com.google.gson.Gson;
import com.yuk.bean.Apply;
import com.yuk.service.ApplyService;
import com.yuk.service.Impl.ApplyServiceImpl;
import com.yuk.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 15:52
 */
public class ApplyServlet extends BaseServlet {
    private ApplyService as=new ApplyServiceImpl();

    //查询所有的apply
    protected void getApplyList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Apply> allA = as.getAllA();
        Gson gson = new Gson();
        String s = gson.toJson(allA);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+allA.size()+"," +"\"data\":"+s+"}");
    }

    //生成申请单
    protected void addApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userId1 = req.getSession().getAttribute("userId");
        if (userId1==null){
            req.getRequestDispatcher("pages/user/houselist.jsp").forward(req,resp);
            return;
        }
        String houseId1 = req.getParameter("houseId");

        Integer houseId = WebUtils.parseInt(houseId1, 0);
        int userId=(int) userId1;
        if (as.isApplied(userId,houseId)){
            req.setAttribute("isapplied","hello");
            req.getRequestDispatcher("pages/user/houselist.jsp").forward(req,resp);

        }else {
            int oneApply = as.createOneApply(userId, houseId);
            req.setAttribute("issuc","yes");
            req.getRequestDispatcher("pages/user/houselist.jsp").forward(req,resp);
        }

    }
}
