package com.yuk.controller;

import com.google.gson.Gson;
import com.yuk.bean.HouseInfo;
import com.yuk.service.HouseService;
import com.yuk.service.Impl.HouseServiceimpl;
import com.yuk.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 15:12
 */
public class HouseServlet extends BaseServlet {

    private HouseService hs=new HouseServiceimpl();

    /**
     * 根据不同户型来查找
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryStr = req.getParameter("queryStr");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        Integer begin = WebUtils.parseInt(page, 1);
        Integer count = WebUtils.parseInt(limit, 5);

        List<HouseInfo> housesByType = hs.getHouseByType(queryStr,(begin-1)*count,count);
        Gson gson = new Gson();
        String s = gson.toJson(housesByType);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+housesByType.size()+"," +"\"data\":"+s+"}");
    }

    /**
     * 查找全部
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HouseInfo> housesByType = hs.getAllHouse();
        Gson gson = new Gson();
        String s = gson.toJson(housesByType);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+housesByType.size()+"," +"\"data\":"+s+"}");
    }

    /**
     * 根据价格上限来查找
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        Integer begin = WebUtils.parseInt(page, 1);
        Integer count = WebUtils.parseInt(limit, 5);

        String queryStr = req.getParameter("queryStr");
        Integer maxPrice = WebUtils.parseInt(queryStr, Integer.MAX_VALUE);
        List<HouseInfo> housesByType = hs.getHouseByPrice(new BigDecimal(maxPrice),(begin-1)*count,count);
        Gson gson = new Gson();
        String s = gson.toJson(housesByType);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+housesByType.size()+"," +"\"data\":"+s+"}");
    }
    protected void queryByRegion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String queryStr = req.getParameter("queryStr");
        if (queryStr.equals("全部")){
            queryByPage(req,resp);
            return;
        }

        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        Integer begin = WebUtils.parseInt(page, 1);
        Integer count = WebUtils.parseInt(limit, 5);

        List<HouseInfo> housesByType = hs.getHouseByRegion(queryStr,(begin-1)*count,count);
        Gson gson = new Gson();
        String s = gson.toJson(housesByType);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+housesByType.size()+"," +"\"data\":"+s+"}");
    }

    protected void queryByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        Integer begin = WebUtils.parseInt(page, 1);
        Integer count = WebUtils.parseInt(limit, 5);
        List<HouseInfo> allHouse = hs.getAllHouse();
        List<HouseInfo> housesByType = hs.getAllHouseByPage((begin-1)*count,count);
        Gson gson = new Gson();
        String s = gson.toJson(housesByType);
        resp.getWriter().write("{"+"\"code\":"+0+"," +"\"msg\":"+"\"sad\""+"," +"\"count\":"+allHouse.size()+"," +"\"data\":"+s+"}");
    }

}
