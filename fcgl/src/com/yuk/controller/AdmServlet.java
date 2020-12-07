package com.yuk.controller;

import com.google.gson.Gson;
import com.yuk.bean.Adm;
import com.yuk.bean.Apply;
import com.yuk.bean.HouseInfo;
import com.yuk.bean.User;
import com.yuk.service.AdmService;
import com.yuk.service.Impl.AdmServiceImpl;
import com.yuk.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 10:25
 */
public class AdmServlet extends BaseServlet {
    private AdmService admService=new AdmServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String name = req.getParameter("admname");
        String password=req.getParameter("password");
//        System.out.println("经过了这里"+req.getContextPath());
        Adm adm = admService.findAdm();

        if (name.equals(adm.getName())&&password.equals(adm.getPassword())){
            System.out.println("登陆成功");
            req.getSession().setAttribute("adm",adm);
            req.getRequestDispatcher("/pages/adm/adm.jsp").forward(req,resp);
        }else {
            System.out.println("登录失败");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void userRun(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<User> allUser = admService.getAllUser();
        Gson gson = new Gson();
        String s = gson.toJson(allUser);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+allUser.size()+"," +"\"data\":"+s+"}");
    }

    protected void HouseRun(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<HouseInfo> allHouse = admService.getAllHouse();
        Gson gson = new Gson();
        String s = gson.toJson(allHouse);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+allHouse.size()+"," +"\"data\":"+s+"}");
    }

    protected void ApplyRun(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<Apply> allApply = admService.getAllApply();
        Gson gson = new Gson();
        String s = gson.toJson(allApply);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+allApply.size()+"," +"\"data\":"+s+"}");
    }

    protected void handleApply(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer status = WebUtils.parseInt(req.getParameter("status"), 0);
        admService.handleApply(id,status);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void delHouseById(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        admService.delHouseById(id);
        resp.sendRedirect(req.getHeader("Referer"));
    }


}
