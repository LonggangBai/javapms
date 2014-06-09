package com.javapms.basic.filters;

import com.ckfinder.connector.FileUploadFilter;

import javax.servlet.*;
import java.io.IOException;

public class UserFileUploadFilter
        extends FileUploadFilter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        super.doFilter(request, response, chain);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig)
            throws ServletException {
        super.init(fConfig);
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.filters.UserFileUploadFilter

 * JD-Core Version:    0.7.0.1

 */