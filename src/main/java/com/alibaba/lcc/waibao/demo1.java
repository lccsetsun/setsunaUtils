package com.alibaba.lcc.waibao;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.lcc.utils.RequestUtils.RequestUtils;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * @Auther: apple
 * @Date: 2019/6/29 07:08
 * @Description:
 */
@Slf4j
public class demo1 {
    public static void main(String[] args) {
       String map = GET("https://rate.taobao.com/detailCommon.htm?auctionNumId=594278626918&userNumId=250280625&ua=098%23E1hvhQvUvbpvUvCkvvvvvjiPRFzw0jYbPsqytjEUPmPwzjlHPF5plji8RFqwsjtjiQhvCvvvpZptvpvhvvCvpvhCvvOvChCvvvmivpvUvvCC8I8iCDkEvpvVvpCmpasZKphv8vvvpHwvvvvvvvCHlQvvvj9vvhcDvvmCp9vvBJZvvUhyvvCHlQvv9BgEvpCW9masw1zUjLeARFxjKOmAdXuKNB3r1EkKHdUf8%2BCl5d8re361D704diTAVAdvaB4AdByaUExrV4Tx%2B3%2BKafm65i%2BwfCuYiLUpVE6Fp9GCvvpvvPMM&callback=json_tbc_rate_summary");
        System.out.println(map);
       JSONObject json = JSONObject.parseObject(map);;

        System.out.println(json);
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     */
    public static String GET(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            connection.setRequestProperty("eagleeye-traceid","0bb1c21115617641443014747e9f9f");
            connection.setRequestProperty("easytrace_app_name","tms");
            connection.setRequestProperty("server","Tengine/Aserver");
            connection.setRequestProperty("s","STATUS_NORMAL");
            //            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("Exception occur when send http get request!", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
