package com.yuk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/4 11:30
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        Object adm = request.getSession().getAttribute("adm");
        if (adm==null){
            servletRequest.getRequestDispatcher("/static/admlogin.jsp").forward(servletRequest,servletResponse);
            return;
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
