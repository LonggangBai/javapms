package com.portal.sysmgr.utils;

import com.javapms.basic.plugin.springmvc.DateTypeEditor;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.support.RequestContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class TagModelTools {
    public static final String OUT_BEAN = "bean";
    public static final String OUT_LIST = "list";
    public static final String OUT_PAGINATION = "page";

    public static Map<String, TemplateModel> addParamsToVariable(Environment env, Map<String, TemplateModel> params)
            throws TemplateException {
        Map<String, TemplateModel> origMap = new HashMap();
        if (params.size() <= 0) {
            return origMap;
        }
        Set<Entry<String, TemplateModel>> entrySet = params.entrySet();
        for (Entry<String, TemplateModel> entry : entrySet) {
            String key = (String) entry.getKey();
            TemplateModel value = env.getVariable(key);
            if (value != null) {
                origMap.put(key, value);
            }
            env.setVariable(key, (TemplateModel) entry.getValue());
        }
        return origMap;
    }

    public static void removeParamsFromVariable(Environment env, Map<String, TemplateModel> params, Map<String, TemplateModel> origMap)
            throws TemplateException {
        if (params.size() <= 0) {
            return;
        }
        for (String key : params.keySet()) {
            env.setVariable(key, (TemplateModel) origMap.get(key));
        }
    }

    public static RequestContext getContext(Environment env)
            throws TemplateException {
        TemplateModel ctx = env
                .getGlobalVariable("springMacroRequestContext");
        if ((ctx instanceof AdapterTemplateModel)) {
            return (RequestContext) ((AdapterTemplateModel) ctx)
                    .getAdaptedObject(RequestContext.class);
        }
        throw new TemplateModelException("RequestContext 'springMacroRequestContext' not found in DataModel.");
    }

    public static String getString(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateScalarModel)) {
            return ((TemplateScalarModel) model).getAsString();
        }
        if ((model instanceof TemplateNumberModel)) {
            return ((TemplateNumberModel) model).getAsNumber().toString();
        }
        System.out.println("aaaaaaax");
        return null;
    }

    public static String[] getStringArray(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        String str = getString(name, params);
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String[] arr = StringUtils.split(str, ',');
        return arr;
    }

    public static Long getLong(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateScalarModel)) {
            String s = ((TemplateScalarModel) model).getAsString();
            if (StringUtils.isBlank(s)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(s));
            } catch (NumberFormatException e) {
                System.out.println("aaaaaaa");
                return null;
            }
        }
        if ((model instanceof TemplateNumberModel)) {
            return Long.valueOf(((TemplateNumberModel) model).getAsNumber().longValue());
        }
        System.out.println("aaaaaaa");
        return null;
    }

    public static Integer getInt(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateScalarModel)) {
            String s = ((TemplateScalarModel) model).getAsString();
            if (StringUtils.isBlank(s)) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("aaaaaaa");
                return null;
            }
        }
        if ((model instanceof TemplateNumberModel)) {
            return Integer.valueOf(((TemplateNumberModel) model).getAsNumber().intValue());
        }
        System.out.println("aaaaaaa");
        return null;
    }

    public static Integer[] getIntArray(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        String str = getString(name, params);
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String[] arr = StringUtils.split(str, ',');
        Integer[] ids = new Integer[arr.length];
        int i = 0;
        try {
            for (String s : arr) {
                ids[(i++)] = Integer.valueOf(s);
            }
            return ids;
        } catch (NumberFormatException e) {
            System.out.println("aaaaaaa,aaa,aa!");
        }
        return null;
    }

    public static Byte getByte(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateScalarModel)) {
            String s = ((TemplateScalarModel) model).getAsString();
            if (StringUtils.isBlank(s)) {
                return null;
            }
            try {
                return Byte.valueOf(Byte.parseByte(s));
            } catch (NumberFormatException e) {
                System.out.println("aaaaaaa");
                return null;
            }
        }
        if ((model instanceof TemplateNumberModel)) {
            return Byte.valueOf(((TemplateNumberModel) model).getAsNumber().byteValue());
        }
        System.out.println("aaaaaaa");
        return null;
    }

    public static Boolean getBool(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateBooleanModel)) {
            return Boolean.valueOf(((TemplateBooleanModel) model).getAsBoolean());
        }
        if ((model instanceof TemplateNumberModel)) {
            return Boolean.valueOf(((TemplateNumberModel) model).getAsNumber().intValue() != 0);
        }
        if ((model instanceof TemplateScalarModel)) {
            String s = ((TemplateScalarModel) model).getAsString();
            if (!StringUtils.isBlank(s)) {
                return Boolean.valueOf((!s.equals("0")) && (!s.equalsIgnoreCase("false")) && (!s
                        .equalsIgnoreCase("f")));
            }
            return null;
        }
        System.out.println("aaaaabooleana");
        return null;
    }

    public static Date getDate(String name, Map<String, TemplateModel> params)
            throws TemplateException {
        TemplateModel model = (TemplateModel) params.get(name);
        if (model == null) {
            return null;
        }
        if ((model instanceof TemplateDateModel)) {
            return ((TemplateDateModel) model).getAsDate();
        }
        if ((model instanceof TemplateScalarModel)) {
            DateTypeEditor editor = new DateTypeEditor();
            editor.setAsText(((TemplateScalarModel) model).getAsString());
            return (Date) editor.getValue();
        }
        System.out.println("aaaaaaaa");
        return null;
    }
}



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.sysmgr.utils.TagModelTools

 * JD-Core Version:    0.7.0.1

 */