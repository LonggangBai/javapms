package com.portal.extrafunc.entity;

import com.portal.extrafunc.entity.base.BaseSurveyTheme;

import java.util.HashSet;
import java.util.Set;

public class SurveyTheme
        extends BaseSurveyTheme {
    private static final long serialVersionUID = 1L;
    public static final Integer NORMAL = Integer.valueOf(1);
    public static final Integer WRITED = Integer.valueOf(2);
    public static final Integer CHECKED = Integer.valueOf(1);
    public static final Integer SELECTED = Integer.valueOf(2);
    public static final Integer TEXT = Integer.valueOf(3);
    public static final Integer ONLINE = Integer.valueOf(4);
    public static final Integer AREA = Integer.valueOf(5);

    public void init() {
        if (getSurveyType().equals(WRITED)) {
            setTotalCount(null);
            if (getMaxlength() == null) {
                setMaxlength(Integer.valueOf(50));
            }
        }
        if (getSurveyType().equals(NORMAL)) {
            setMaxlength(null);
            if (getTotalCount() == null) {
                setTotalCount(Integer.valueOf(1));
            }
        }
        if (getPriority() == null) {
            setPriority(Integer.valueOf(10));
        }
    }

    public String getShowString() {
        Integer showtype = getShowType();
        if (showtype.equals(CHECKED)) {
            return "单复选框显示";
        }
        if (showtype.equals(SELECTED)) {
            return "select show";
        }
        if (showtype.equals(TEXT)) {
            return "common input show";
        }
        if (showtype.equals(ONLINE)) {
            return "underline show";
        }
        return "text show";
    }

    public String getSurveyTypeString() {
        Integer surveytype = getSurveyType();
        if (surveytype.equals(NORMAL)) {
            return "select item class";
        }
        return "input class";
    }

    public void addToItems(String name, Integer votes, Integer priority) {
        Set<SurveyItem> items = getItems();
        if (items == null) {
            items = new HashSet();
            setItems(items);
        }
        SurveyItem item = new SurveyItem();
        item.setName(name);
        item.setVotes(votes);
        item.setPriority(priority);
        items.add(item);
    }

    public SurveyTheme() {
    }

    public SurveyTheme(Integer id) {
        super(id);
    }

    public SurveyTheme(Integer id, Questionnaire naire, String title, Integer surveyType, Integer priority) {
        super(id, naire, title, surveyType, priority);
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.entity.SurveyTheme

 * JD-Core Version:    0.7.0.1

 */