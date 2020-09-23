package com.alibaba.lcc.service.Impl;

import com.alibaba.lcc.model.resp.Resp;
import com.alibaba.lcc.service.RoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class RoadServiceImpl implements RoadService {


    static final Executor asyncExecutor = Executors.newScheduledThreadPool(5);

    @Override
    public void select_user() {
//        v3RoadCross s = crossMapper.selectByPrimaryKey(1375);
        System.out.println("=========");
        System.out.println(" this is platfrom ");
    }


    @Override
    public Resp MonitorList()throws Exception {
        // 异步查询
//        CompletableFuture<List<TrackV3>> listDO =
//                (CompletableFuture<List<TrackV3>>) CompletableFuture.supplyAsync(() ->
//                        crossMapper.MonitorList(),asyncExecutor);
//        System.out.println(listDO.get());

        return null;
    }
}
