package com.javapms.basic.comparator;

import java.io.Serializable;
import java.util.Comparator;

public class BeanComparator
        implements Comparator<BeanInterface>, Serializable {
    public static final BeanComparator INSTANCE = new BeanComparator();

    public int compare(BeanInterface o1, BeanInterface o2) {
        Number v1 = o1.getPriority();
        Number v2 = o2.getPriority();
        if (v1 == null) {
            return 1;
        }
        if (v2 == null) {
            return -1;
        }
        if (v1.longValue() > v2.longValue()) {
            return 1;
        }
        if (v1.longValue() < v2.longValue()) {
            return -1;
        }
        return 0;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.comparator.BeanComparator

 * JD-Core Version:    0.7.0.1

 */