package com.yuk.controller;

import com.google.gson.Gson;
import com.yuk.bean.ApplyShow;
import com.yuk.service.ApplyShowService;
import com.yuk.service.Impl.ApplyShowServiceImpl;
import com.yuk.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/2 9:02
 */
public class ApplyShowServlet extends BaseServlet {
    private ApplyShowService ass=new ApplyShowServiceImpl();
    protected void getAllApplyShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userId = req.getSession().getAttribute("userId");
        if (userId!=null){
            List<ApplyShow> all = ass.getAll((int)userId);
            Gson gson = new Gson();
            String s = gson.toJson(all);
            resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+all.size()+"," +"\"data\":"+s+"}");
        }else {
//            resp.sendRedirect(req.getContextPath()+"/pages/user/index.jsp");
//            req.getRequestDispatcher("pages/user/index.jsp").forward(req,resp);
            System.out.println("无数据");
        }


    }
}
