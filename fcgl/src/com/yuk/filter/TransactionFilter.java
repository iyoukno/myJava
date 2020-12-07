package com.yuk.filter;

import com.yuk.utils.JDBCutils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/4 17:25
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("dawdaw");
//            JDBCutils.closeAndCommit();
        } catch (Exception e) {
            JDBCutils.RollBackAndClose();
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
