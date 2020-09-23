package com.alibaba.lcc.utils;

import com.alibaba.lcc.model.model.TrackV3;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class PoJoSort {

    public static void main(String[] args) {
        List<TrackV3> list = new ArrayList<>();
        TrackV3 ts = new TrackV3();
        ts.setCameraid("60");
        ts.setTopicName("abc");
        list.add(ts);
        for (int i = 0; i <3 ; i++) {
            TrackV3 t = new TrackV3();
            t.setCameraid("2"+i);
            t.setTopicName("abc"+i);
            list.add(t);
        }
        Map<String,String> map = new HashMap<>();
        map.put("ceshi_key","ceshi_value");



//        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
//        try {
//            queue.put("ceshi");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<TrackV3> ls = sortList(list);
        System.out.println(ls);

    }

    /**
     * 排序
     * @param info
     * @return
     */
    private static List<TrackV3> sortList(List<TrackV3> info) {
        info.sort(Comparator.comparing(TrackV3::getCameraid));
        return info;
    }
}
