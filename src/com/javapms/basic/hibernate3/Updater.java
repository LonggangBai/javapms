package com.javapms.basic.hibernate3;

import java.util.HashSet;
import java.util.Set;

public class Updater<T> {
    private T bean;

    public Updater(T bean) {
        this.bean = bean;
    }

    public Updater(T bean, UpdateMode mode) {
        this.bean = bean;
        this.mode = mode;
    }

    public Updater<T> setUpdateMode(UpdateMode mode) {
        this.mode = mode;
        return this;
    }

    public Updater<T> include(String property) {
        this.includeProperties.add(property);
        return this;
    }

    public Updater<T> exclude(String property) {
        this.excludeProperties.add(property);
        return this;
    }

    public boolean isUpdate(String name, Object value) {
        if (this.mode == UpdateMode.MAX) {
            return !this.excludeProperties.contains(name);
        }
        if (this.mode == UpdateMode.MIN) {
            return this.includeProperties.contains(name);
        }
        if (this.mode == UpdateMode.MIDDLE) {
            if (value != null) {
                return !this.excludeProperties.contains(name);
            }
            return this.includeProperties.contains(name);
        }
        return true;
    }

    private Set<String> includeProperties = new HashSet();
    private Set<String> excludeProperties = new HashSet();
    private UpdateMode mode = UpdateMode.MIDDLE;

    public static enum UpdateMode {
        MAX, MIN, MIDDLE;
    }

    public T getBean() {
        return this.bean;
    }

    public Set<String> getExcludeProperties() {
        return this.excludeProperties;
    }

    public Set<String> getIncludeProperties() {
        return this.includeProperties;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.hibernate3.Updater

 * JD-Core Version:    0.7.0.1

 */