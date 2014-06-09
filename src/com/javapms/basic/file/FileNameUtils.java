package com.javapms.basic.file;

import com.javapms.basic.utils.NumBeanUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtils {
    public static final DateFormat pathDf = new SimpleDateFormat("yyyyMM");
    public static final DateFormat nameDf = new SimpleDateFormat("ddHHmmss");

    public static String genPathName() {
        return pathDf.format(new Date());
    }

    public static String genFileName() {
        return
                nameDf.format(new Date()) + RandomStringUtils.random(4, NumBeanUtils.N36_CHARS);
    }

    public static String genFileName(String ext) {
        return genFileName() + "." + ext;
    }

    public static void main(String[] args) {
        System.out.println(genPathName());
        System.out.println(genFileName());
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.file.FileNameUtils

 * JD-Core Version:    0.7.0.1

 */