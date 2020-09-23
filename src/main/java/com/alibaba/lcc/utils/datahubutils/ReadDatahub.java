package com.alibaba.lcc.utils.datahubutils;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.DatahubConfiguration;
import com.aliyun.datahub.auth.AliyunAccount;
import com.aliyun.datahub.common.data.RecordSchema;
import com.aliyun.datahub.model.ListShardResult;
import com.aliyun.datahub.model.PutRecordsResult;
import com.aliyun.datahub.model.RecordEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDatahub {
    public static void main(String[] args) throws InterruptedException {
        //初始化DataHub client和schema
        String endpoint = "http://datahub.cn-hangzhou-xszh-d01.dh.cloud.xszh.gov.hz";
        String accessId = "hdIRlGqGmzgub8uf";
        String accessKey = "Ts6LSYrbItxM2Uy0r29XgUO9vUXwcb";
        AliyunAccount account = new AliyunAccount(accessId, accessKey);
        DatahubConfiguration conf = new DatahubConfiguration(account, endpoint);
        DatahubClient dhClient = new DatahubClient(conf);
        RecordSchema dhSchema = new RecordSchema();
        String projectName = "city_video_lcc_2";
        String topicName = "testlcc_33010900001323572957";
        //向指定的 topicName 写入数据
        putRead(dhClient,topicName,projectName);


//        read_Datahub(dhClient);

    }

    private static void read_Datahub(DatahubClient dhClient) {

    }

    private static void putRead(DatahubClient client, String topicName, String projectName) {
        try {
//        dhSchema.addField(new Field("data", FieldType.STRING));
//            String path="D:\\code\\datahub\\dhubtest\\dhubtest\\src\\main\\java\\com\\alibaba\\dhubtest\\33010900001320000152.dat";
            String path="/Users/setsun/IdeaProjects/datahub/33010900001320000152.dat";
            FileReader fileReader = null;
            fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            String result = "";
            while( (line = br.readLine()) != null ){
                result+=line;
            }
            while(true){
                ListShardResult listShardResult = client.listShard(projectName, topicName);
                List<RecordEntry> recordEntries = new ArrayList<>(558);
                // 此处可选用listShardResult任意status为ACTIVE的shard进行写入，本例取第一个shard写入
                String shardId = listShardResult.getShards().get(0).getShardId();
                RecordSchema schema = client.getTopic(projectName, topicName).getRecordSchema();
                for (int i = 1; i < 557; i++) {
                    RecordEntry entry = new RecordEntry(schema);
                    entry.setString(0, result);
                    entry.setShardId(shardId);
                    recordEntries.add(entry);
                }
                long start = System.currentTimeMillis();
                PutRecordsResult results = client.putRecords(projectName, topicName, recordEntries);
                long end = System.currentTimeMillis();
                if (results.getFailedRecordCount() != 0) {

                }
                // 将写入错误的重新写入
                recordEntries.addAll(results.getFailedRecords());
                System.out.println("  写入延时 : " + (end - start) + "ms");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
