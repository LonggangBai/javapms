package com.javapms.basic.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ExecuteTimeFilter implements Filter {
    protected final Logger log = LoggerFactory.getLogger(ExecuteTimeFilter.class);
    public static final String START_TIME = "_start_time";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        long time = System.currentTimeMillis();
        request.setAttribute("_start_time", Long.valueOf(time));
        chain.doFilter(request, response);
        time = System.currentTimeMillis() - time;


        this.log.debug("process in {} ms: {}", Long.valueOf(time), request.getRequestURI());
    }

    public void init(FilterConfig arg0)
            throws ServletException {
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.filters.ExecuteTimeFilter

 * JD-Core Version:    0.7.0.1

 */