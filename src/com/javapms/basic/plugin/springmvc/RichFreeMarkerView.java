package com.javapms.basic.plugin.springmvc;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RichFreeMarkerView
        extends FreeMarkerView {
    public static final String CONTEXT_PATH = "base";

    protected void exposeHelpers(Map model, HttpServletRequest request)
            throws Exception {
        super.exposeHelpers(model, request);
        model.put("base", request.getContextPath());
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.plugin.springmvc.RichFreeMarkerView

 * JD-Core Version:    0.7.0.1

 */