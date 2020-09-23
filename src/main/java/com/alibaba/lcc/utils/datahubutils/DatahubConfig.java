package com.alibaba.lcc.utils.datahubutils;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.DatahubConfiguration;
import com.aliyun.datahub.auth.AliyunAccount;

public class DatahubConfig {
    static final String endpoint = "http://dh-cn-hangzhou.aliyuncs.com";
    static final String accessId = "LTAI35f8RLNYhZKN";
    static final String accessKey = "fCIJK6SfDCzQnkQuDk2QbFOly5kst0";

    AliyunAccount account = new AliyunAccount(accessId, accessKey);
    DatahubConfiguration conf = new DatahubConfiguration(account, endpoint);
    DatahubClient client = new DatahubClient(conf);

}
