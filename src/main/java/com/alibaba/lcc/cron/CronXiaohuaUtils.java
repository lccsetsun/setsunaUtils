package com.alibaba.lcc.cron;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Slf4j
@Component
public class CronXiaohuaUtils {
    public static String sendUrl = "https://oapi.dingtalk.com/robot/send?access_token=28d27124f770d9e81bb4b4344fd1d74f88b0430cb111e90c8d63cef85a142483";
    public static String gaoxUrl = "https://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=1&sort=rand&appkey=47ff67c189f9f311";
    public static String hitokoto_i_Url = "https://v1.hitokoto.cn?c=i"; // 诗词
    public static String hitokoto_a_Url = "https://v1.hitokoto.cn?c=i"; // 动画
    public static String hitokoto_b_Url = "https://v1.hitokoto.cn?c=i"; // 漫画
    public static String hitokoto_c_Url = "https://v1.hitokoto.cn?c=i"; // 游戏
    public static String hitokoto_d_Url = "https://v1.hitokoto.cn?c=i"; // 文学
    public static String hitokoto_h_Url = "https://v1.hitokoto.cn?c=i"; // 影视
    public static String hitokoto_k_Url = "https://v1.hitokoto.cn?c=i"; // 哲学
    public static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String English_url = "https://apiv3.shanbay.com/weapps/dailyquote/quote/?date=";

    @Scheduled(cron="0 0/30 * * * ?")
    public void cronutils() throws ApiException {
        LocalDateTime tme = LocalDateTime.now();
        if(tme.getHour()>8 || tme.getHour()<23){
            DingTalkClient client = new DefaultDingTalkClient(sendUrl);
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype("markdown");
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            String body = HttpUtil.createGet(gaoxUrl).execute().body();
            JSONArray json= JSONObject.parseObject(body).getJSONObject("result").getJSONArray("list");
            JSONObject bodyJSON = JSONObject.parseObject(json.get(0).toString());
            markdown.setTitle("亲爱的，记得喝水哦！走动一下");
            markdown.setText("## 夕阳提醒你！记得喝水水 \n  #### 每刻一笑 \n >"+bodyJSON.get("content"));
            request.setMarkdown(markdown);
            OapiRobotSendResponse response = client.execute(request);
        }
    }

    @Scheduled(cron="0 20 * * * ?")
    public void hitokoto() throws ApiException {
        LocalDateTime tme = LocalDateTime.now();
        if(tme.getHour()>8 && tme.getHour()<23){
            DingTalkClient client = new DefaultDingTalkClient(sendUrl);
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype("markdown");
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            markdown.setTitle("夕阳的每刻推送");
            String strBody = hitokotoUtils();
            log.info(strBody);
            if (StringUtils.isNotBlank(strBody)){
                markdown.setText("### 每刻推送  \n ##### 提醒一下，记得喝水哦！！！\n "+strBody);
                request.setMarkdown(markdown);
                OapiRobotSendResponse response = client.execute(request);
            }
        }
    }


    public static String hitokotoUtils() {
        StringBuffer str = new StringBuffer();
        Random r = new Random();
        LocalDateTime now = LocalDateTime.now();
        String English = HttpUtil.createGet(English_url+dtf2.format(now.plusDays(-(r.nextInt(300))))).execute().body();
        JSONObject cont = JSONObject.parseObject(English);
        String translation = cont.getString("translation");
        String content = cont.getString("content");
        String images = cont.getJSONArray("origin_img_urls").get(0).toString();
        str.append("> ### 唯美英语 \n  "+" \n ``` \n "+content+"\n  "+translation+"  \n ``` \n ![origin_img_urls]("+images+") \n ");
        JSONObject hitokoto_i = JSONObject.parseObject(HttpUtil.createGet(hitokoto_i_Url).execute().body());
        str.append("> ### 诗词 \n  "+"``` \n "+hitokoto_i.getString("hitokoto")+"\n       "+hitokoto_i.getString("from")+" \n ``` \n");
        JSONObject hitokoto_a = JSONObject.parseObject(HttpUtil.createGet(hitokoto_a_Url).execute().body());
        str.append("> ### 动画 \n  "+"``` \n "+hitokoto_a.getString("hitokoto")+"\n       "+hitokoto_a.getString("from")+" \n ``` \n");
        JSONObject hitokoto_b = JSONObject.parseObject(HttpUtil.createGet(hitokoto_b_Url).execute().body());
        str.append("> ### 漫画 \n  "+"``` \n "+hitokoto_b.getString("hitokoto")+"\n       "+hitokoto_b.getString("from")+" \n ``` \n");
        JSONObject hitokoto_c = JSONObject.parseObject(HttpUtil.createGet(hitokoto_c_Url).execute().body());
        str.append("> ### 游戏 \n  "+"``` \n "+hitokoto_c.getString("hitokoto")+"\n       "+hitokoto_c.getString("from")+" \n ``` \n");
        JSONObject hitokoto_d = JSONObject.parseObject(HttpUtil.createGet(hitokoto_d_Url).execute().body());
        str.append("> ### 文学 \n  "+"``` \n "+hitokoto_d.getString("hitokoto")+"\n       "+hitokoto_d.getString("from")+" \n ``` \n");
        JSONObject hitokoto_h = JSONObject.parseObject(HttpUtil.createGet(hitokoto_h_Url).execute().body());
        str.append("> ### 影视 \n  "+"``` \n "+hitokoto_h.getString("hitokoto")+"\n       "+hitokoto_h.getString("from")+" \n ``` \n");
        JSONObject hitokoto_k = JSONObject.parseObject(HttpUtil.createGet(hitokoto_k_Url).execute().body());
        str.append("> ### 哲学 \n  "+"``` \n "+hitokoto_k.getString("hitokoto")+" \n       "+hitokoto_k.getString("from")+" \n ``` \n");
        return str.toString();
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
      /*  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String url = "https://apiv3.shanbay.com/weapps/dailyquote/quote/?date="+dtf2.format(LocalDateTime.now());
        String body = HttpUtil.createGet(English_url).execute().body();
        JSONObject cont = JSONObject.parseObject(body);
        String translation = cont.getString("translation");
        String content = cont.getString("content");
        JSONArray images = cont.getJSONArray("origin_img_urls");
        log.info(images.get(0).toString());
      log.info(translation);
        log.info(content);

      */
//        JSONObject hitokoto_i = JSONObject.parseObject(HttpUtil.createGet(hitokoto_i_Url).execute().body());
//        log.info(hitokoto_i.toJSONString());
        Random r = new Random();
        LocalDateTime now = LocalDateTime.now();
//        now.plusDays(r.nextInt(500));

        log.info(dtf2.format(now.plusDays(-(r.nextInt(300)))));
    }

}
