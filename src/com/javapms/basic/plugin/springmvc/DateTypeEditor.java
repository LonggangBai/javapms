package com.javapms.basic.plugin.springmvc;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTypeEditor
        extends PropertyEditorSupport {
    public static final DateFormat DF_LONG = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
    public static final int SHORT_DATE = 10;

    public void setAsText(String text)
            throws IllegalArgumentException {
        text = text.trim();
        if (!StringUtils.hasText(text)) {
            setValue(null);
            return;
        }
        try {
            if (text.length() <= 10) {
                setValue(new java.sql.Date(DF_SHORT.parse(text).getTime()));
            } else {
                setValue(new Timestamp(DF_LONG.parse(text).getTime()));
            }
        } catch (ParseException ex) {
            IllegalArgumentException iae = new IllegalArgumentException(
                    "Could not parse date: " + ex.getMessage());
            iae.initCause(ex);
            throw iae;
        }
    }

    public String getAsText() {
        java.util.Date value = (java.util.Date) getValue();
        return value != null ? DF_LONG.format(value) : "";
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.plugin.springmvc.DateTypeEditor

 * JD-Core Version:    0.7.0.1

 */