package com.alibaba.lcc.utils.Singleton;

import com.alibaba.lcc.utils.odpscommom.odpsutils;

import static com.alibaba.lcc.utils.odpscommom.odpsutils.getSingletonOdps;

public class demo {
    public static void main(String[] args) {
        //单利模式创建对象获取当天日期
        Singleton instance = Singleton.getSingleton();

        DayFlag dayFlag = instance.dayFlag;
        System.out.println(instance.dayFlag.getDayMapLock().get(0));
        System.out.println( dayFlag.checkDayChange());

    }
}
