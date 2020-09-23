package com.alibaba.lcc.utils.odpscommom;

import com.aliyun.odps.Instance;
import com.aliyun.odps.Odps;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.Resource;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * odps 查询每个车每天过车量
 */
@Slf4j
public class odpsutils {

    private static final String accessId = "MbaLP7JZzzBmUUX5";
    private static final String accessKey = "it6Xk8RBzLG9LDBF7HSm1gUX7Eb0HS";
    private static final String endPoint = "http://service.cn-hangzhou-xszh-d01.odps.cloud.xszh.gov.hz/api";
    private static final String project = "xsjj";
    static Account account = new AliyunAccount(accessId, accessKey);
    public static Odps odps;
    private static odpsutils odpsutils;

    public odpsutils(){
        odps = new Odps(account);
        odps.setEndpoint(endPoint);
        odps.setDefaultProject(project);
    }
    public static odpsutils getSingletonOdps() {
        if (odpsutils == null) {
            synchronized (odpsutils.class) {
                if (odpsutils == null) {
                    odpsutils = new odpsutils();
                }
            }
        }
        return odpsutils;
    }

    @Value("${project_name}")
    private static String lcc_AccessId;

    public static void main(String[] args) {
        String sql = "select * from ods_oss_v1_datahub_result_video where " +
                "ds = '20190110' and vehicle_type = 'Car';";
        odpsutils odpsutils = getSingletonOdps();
        select(sql);

//        tables(odps);
    }
    public static void tables(Odps odps) {
        for (Resource r : odps.resources()) {
            log.info("{}<->{}<->{}<->{}",r.getComment(),r.getName(),r.getType(),r.getOwner());
            System.out.println();
        }
    }
    public static void select(String sql) {
        Instance i;
        try {
            i = SQLTask.run(odps, sql);
            i.waitForSuccess();
            List<Record> records = SQLTask.getResult(i);
            for(Record r:records){
                System.out.println(r.get("camera_id") +" " + r.get("camera_position")+ " "+ r.get("carossurl"));
            }
            if ( String.valueOf(records.toArray().length).equals("10000") ) {
                log.info("");
            }
        } catch (OdpsException e) {
            e.printStackTrace();
        }
    }
}
