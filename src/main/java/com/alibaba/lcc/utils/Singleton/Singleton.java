package com.alibaba.lcc.utils.Singleton;

import com.alibaba.lcc.utils.GetDataUtils;

public class Singleton {


    public DayFlag dayFlag;
    public  HourFlag hourFlag;
    //    public DBData dbData;
    private volatile static Singleton instance; //声明成 volatile
    private Singleton(Long initTime){
        System.out.println(initTime + "=====       initTime");
        this.dayFlag = new DayFlag(GetDataUtils.dayFdf.format(initTime));
        this.hourFlag = new HourFlag(GetDataUtils.hourSDF.format(initTime));
//        this.dbData = new DBData(EventUtils.flushDataFdf.format(initTime).substring(0, 3));
    }

    public static Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(System.currentTimeMillis());
                }
            }
        }
        System.out.println(instance + "====        instance");
        return instance;
    }

}
