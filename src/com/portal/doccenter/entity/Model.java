package com.portal.doccenter.entity;

import com.portal.doccenter.entity.base.BaseModel;
import org.apache.commons.lang.StringUtils;

public class Model
        extends BaseModel {
    private static final long serialVersionUID = 1L;
    public static final String[] DEF_NAMES = {"channelId", "title",
            "shortTitle", "titleColor", "subTitle", "tagStr", "description",
            "author", "origin", "style", "recommend", "showIndex", "redTape",
            "viewGroups", "tplContent", "atts", "releaseDate", "link",
            "commentControl", "updownControl", "txt", "picture", "pics"};
    public static final String[] DEF_LABELS = {"aa", "aa", "aaa", "aaaa",
            "aaa", "Tagaa", "aa", "aa", "aa", "aaaa", "aa", "aaaaa", "aaaa",
            "aaaa", "aaaa", "aa", "aaaa", "aaaa", "aaaa", "aaaa", "aa", "aaa",
            "aa"};
    public static final Integer[] DEF_DATA_TYPES = {Integer.valueOf(9), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1),
            Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(6), Integer.valueOf(1), Integer.valueOf(7), Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(10)};
    public static final Boolean[] DEF_REQUIREDS = {Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false),
            Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false),
            Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false)};

    public void init() {
        if (getDisabled() == null) {
            setDisabled(Boolean.valueOf(false));
        }
    }

    public String getModelIcon() {
        if (!StringUtils.isBlank(getIcon())) {
            int a = getIcon().lastIndexOf("/") + 1;
            int b = getIcon().lastIndexOf(".");
            if (b > a) {
                return getIcon().substring(a, b);
            }
        }
        return null;
    }

    public Model() {
    }

    public Model(Integer id) {
        super(id);
    }

    public Model(Integer id, String name, Integer priority, Boolean disabled) {
        super(id, name, priority, disabled);
    }
}



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.entity.Model

 * JD-Core Version:    0.7.0.1

 */