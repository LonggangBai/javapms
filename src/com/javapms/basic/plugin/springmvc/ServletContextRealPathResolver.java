package com.javapms.basic.plugin.springmvc;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class ServletContextRealPathResolver
        implements RealPathResolver, ServletContextAware {
    private ServletContext context;

    public String get(String path) {
        return this.context.getRealPath(path);
    }

    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.plugin.springmvc.ServletContextRealPathResolver

 * JD-Core Version:    0.7.0.1

 */