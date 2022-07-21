package com.test.utils;

import com.test.base.entity.TreeEntity;

import java.util.Comparator;

/**
 * @author 陈晓程
 * 创建时间：2019年01月21日 09:55
 * 用途：
 */
public class TreeEntityComparator<T extends TreeEntity> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if(o1==null)
        {
            return -1;
        }
        if(o2==null)
        {
            return 1;
        }
        long millis1 = o1.getUpdateTime().getTime();
        long millis2 = o2.getUpdateTime().getTime();
        if(millis1<millis2)
        {
            return -1;
        }
        else if(millis1>millis2)
        {
            return 1;
        }
        return 0;
    }
}
