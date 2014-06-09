package com.javapms.basic.plugin.springmvc;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public final class MessageResolver {
    public static String getMessage(HttpServletRequest request, String code, Object... args) {
        WebApplicationContext messageSource =
                RequestContextUtils.getWebApplicationContext(request);
        if (messageSource == null) {
            throw new IllegalStateException("WebApplicationContext not found!");
        }
        LocaleResolver localeResolver =
                RequestContextUtils.getLocaleResolver(request);
        Locale locale;
        if (localeResolver != null) {
            locale = localeResolver.resolveLocale(request);
        } else {
            locale = request.getLocale();
        }
        return messageSource.getMessage(code, args, locale);
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.plugin.springmvc.MessageResolver

 * JD-Core Version:    0.7.0.1

 */