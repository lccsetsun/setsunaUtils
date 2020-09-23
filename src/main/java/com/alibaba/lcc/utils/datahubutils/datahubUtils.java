package com.alibaba.lcc.utils.datahubutils;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.DatahubConfiguration;
import com.aliyun.datahub.auth.AliyunAccount;
import com.aliyun.datahub.common.data.Field;
import com.aliyun.datahub.common.data.FieldType;
import com.aliyun.datahub.common.data.RecordSchema;
import com.aliyun.datahub.common.data.RecordType;
import com.aliyun.datahub.exception.DatahubClientException;
import com.aliyun.datahub.exception.InvalidCursorException;
import com.aliyun.datahub.model.*;

import java.util.List;

public class datahubUtils {
    static final String endpoint = "http://datahub.cn-hangzhou-xszh-d01.dh.cloud.xszh.gov.hz";
    static final String accessId = "hdIRlGqGmzgub8uf";
    static final String accessKey = "Ts6LSYrbItxM2Uy0r29XgUO9vUXwcb";

    AliyunAccount account = new AliyunAccount(accessId, accessKey);
    DatahubConfiguration conf = new DatahubConfiguration(account, endpoint);
    DatahubClient client = new DatahubClient(conf);

    public static void main(String[] args) {
        datahubUtils app = new datahubUtils();
        //app.connectDataHub();
        //app.insertData();
        app.downloadTopicData();
    }

    //从topic中取数据
    public void downloadTopicData(){
        RecordSchema schema;
        String topicName = "oss_v1_datahub_result";
        String projectName = "smart_city_test";
        ListShardResult listShardResult = client.listShard(projectName, topicName);
        String shardId = listShardResult.getShards().get(0).getShardId();
        GetCursorResult cursorRs = client.getCursor(projectName, topicName, shardId, GetCursorRequest.CursorType.OLDEST);
        schema = client.getTopic(projectName,topicName).getRecordSchema();
        int limit = 100;
        String cursor = cursorRs.getCursor();
        while (true) {
            try {
                GetRecordsResult recordRs = client.getRecords(projectName, topicName, shardId, cursor, limit, schema);
                List<RecordEntry> recordEntries = recordRs.getRecords();
                if (recordEntries.size() == 0) {
                    // 无最新数据，请稍等重试
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 拿到下一个游标
                System.out.println(recordEntries.get(1).getString("carossurl"));
                cursor = recordRs.getNextCursor();
            } catch (InvalidCursorException ex) {
                // 非法游标或游标已过期，建议重新定位后开始消费
                cursorRs = client.getCursor(projectName, topicName, shardId, GetCursorRequest.CursorType.OLDEST);
                cursor = cursorRs.getCursor();
            } catch (DatahubClientException ex) {
                // 发生异常，需要重试
                System.out.printf(ex.getMessage());
                ex.printStackTrace();
            }
        }


    }

}
