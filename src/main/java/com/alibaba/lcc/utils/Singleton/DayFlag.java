package com.alibaba.lcc.utils.Singleton;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.lcc.utils.GetDataUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFlag {

    private Map<String, String> dayMapLock;
    private List<String> keyList;

    private String timeOld = "";
    private String timeNew = "";

    public DayFlag(String key){
        System.out.println(key +"=====>  key");
        this.dayMapLock = new HashMap<String, String>();
        this.keyList = new ArrayList<String>();
        keyList.add(key);
        dayMapLock.put(key, key);
    }

    public boolean checkDayChange(){

        String key = keyList.get(0);
        String dayString = dayMapLock.get(key);

        synchronized (dayString){
            String nowDay = GetDataUtils.dayFdf.format(System.currentTimeMillis());
            if(dayString.equals(nowDay)){
                return false;
            } else {
                timeOld = dayMapLock.get(key);
                dayMapLock.put(key, nowDay);
                timeNew = nowDay;
                return true;
            }
        }
    }


    public Map<String, String> getDayMapLock() { return dayMapLock; }
    public String dayMapLockJson(){ return JSONObject.toJSONString(this.dayMapLock); }

    public String getTimeOld() { return timeOld; }

    public void setTimeOld(String timeOld) { this.timeOld = timeOld; }

    public String getTimeNew() { return timeNew; }

    public void setTimeNew(String timeNew) { this.timeNew = timeNew; }
}
