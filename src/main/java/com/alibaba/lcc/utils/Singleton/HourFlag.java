package com.alibaba.lcc.utils.Singleton;


import com.alibaba.lcc.utils.GetDataUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HourFlag {

    private Map<String, String> hourMapLock;
    private List<String> keyList;
    private String timeOld = "";
    private String timeNew = "";

    public HourFlag(String key){
        this.hourMapLock = new HashMap<String, String>();
        this.keyList = new ArrayList<String>();
        keyList.add(key);
        hourMapLock.put(key, key);
    }

    public boolean checkHourChange(){
        String key = keyList.get(0);
        String hourString = hourMapLock.get(key);

        synchronized (hourString){
            String rtHour = GetDataUtils.hourSDF.format(System.currentTimeMillis());
            if(hourString.equals(rtHour)){
                return false;
            } else {
                timeOld = hourMapLock.get(key);
                hourMapLock.put(key, rtHour);
                timeNew = rtHour;
                return true;
            }
        }
    }

    public Map<String, String> getHourMapLock() {
        return hourMapLock;
    }

    public List<String> getKeyList() {
        return keyList;
    }

    public String getTimeOld() {
        return timeOld;
    }

    public String getTimeNew() {
        return timeNew;
    }

    public void setHourMapLock(Map<String, String> hourMapLock) {
        this.hourMapLock = hourMapLock;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public void setTimeOld(String timeOld) {
        this.timeOld = timeOld;
    }

    public void setTimeNew(String timeNew) {
        this.timeNew = timeNew;
    }
}
