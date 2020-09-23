package com.alibaba.lcc.utils.tianqing;

import com.alibaba.lcc.utils.FileUtils.FileUtils;
import com.alibaba.lcc.utils.RequestUtils.RequestUtils;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 * 同步视在json线圈
 */
public class RsyncJson {

    private static String PATH = "/Users/setsun/IdeaProjects/school_code/alibaba_lcc_client/conf/json/";
    public static void main(String[] args) {
        String str = "33010900001321210487";

        String postUrl = "http://47.101.218.186:8701/v1/import_region";
        List<String> list = Arrays.asList(str.split("\n"));
        list.stream().forEach(s -> {
            String jsonstr =FileUtils.readFile(PATH+s+".json");
            String par = "cid="+s+"&jsonstr="+jsonstr;
//            map.put("cid",s);
//            map.put("jsonstr",jsonstr);
           String postrequest = RequestUtils.POST(postUrl,par);
            System.out.println(postrequest);
            try{
                sleep(1000);
            }catch (Exception e){
                e.getMessage();
            }
        });
    }
}
