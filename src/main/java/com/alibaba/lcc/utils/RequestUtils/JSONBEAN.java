package com.alibaba.lcc.utils.RequestUtils;

import com.alibaba.fastjson.JSON;

/**
 * @author: setsun
 * @create: 2018- 12-11
 * @description:
 * @program: spoperate
 **/
public class JSONBEAN {

    private static <T> T JsonGetBean(String s,Class<T> clazz){
        return JSON.parseObject(s,clazz);
    }
}
