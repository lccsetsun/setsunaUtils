package com.alibaba.lcc.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.lcc.cron.CronXiaohuaUtils;
import com.alibaba.lcc.model.resp.Resp;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * https://oapi.dingtalk.com/robot/send?access_token=28d27124f770d9e81bb4b4344fd1d74f88b0430cb111e90c8d63cef85a142483
 *
 */
@Slf4j
@RestController
@RequestMapping("/ding")
public class DingdingUtilsController {

    public static String sendUrl = "https://oapi.dingtalk.com/robot/send?access_token=4e4f1ee80c86ec7035e1f763bb15c7e0efdcb3d25ab42d321e352a2fc9d6023d";
    public static String gaoxUrl = "https://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=1&sort=rand&appkey=47ff67c189f9f311";
    @PostMapping("send")
    public Resp getOrgRootNodeAppointReturn() throws ApiException {

            DingTalkClient client = new DefaultDingTalkClient(sendUrl);
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype("markdown");
            OapiRobotSendRequest.At s =  new OapiRobotSendRequest.At();
            s.setIsAtAll(true);
            request.setAt(s);
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            String strBody = CronXiaohuaUtils.hitokotoUtils();
            markdown.setTitle("夕阳的每刻推送");
            markdown.setText("### 每刻推送  \n ##### 提醒一下，记得喝水哦！！！\n "+strBody);
            request.setMarkdown(markdown);
            OapiRobotSendResponse response = client.execute(request);
            log.info(JSONObject.toJSONString(response));
            log.info(strBody);
        return Resp.success();
    }
//
//    public static void main(String[] args) {
//        String body = HttpUtil.createGet(gaoxUrl).execute().body();
//        JSONArray json= JSONObject.parseObject(body).getJSONObject("result").getJSONArray("list");
//        JSONObject bodyJSON = JSONObject.parseObject(json.get(0).toString());
//        System.out.println(bodyJSON.get("content"));
//    }
}
