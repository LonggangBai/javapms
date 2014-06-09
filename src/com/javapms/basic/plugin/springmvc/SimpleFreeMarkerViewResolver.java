package com.javapms.basic.plugin.springmvc;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class SimpleFreeMarkerViewResolver
        extends AbstractTemplateViewResolver {
    public SimpleFreeMarkerViewResolver() {
        setViewClass(SimpleFreeMarkerView.class);
    }

    protected AbstractUrlBasedView buildView(String viewName)
            throws Exception {
        AbstractUrlBasedView view = super.buildView(viewName);
        if (viewName.startsWith("/")) {
            view.setUrl(viewName + getSuffix());
        }
        return view;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.plugin.springmvc.SimpleFreeMarkerViewResolver

 * JD-Core Version:    0.7.0.1

 */