package com.alibaba.lcc.service;

import com.alibaba.lcc.model.resp.Resp;

public interface RoadService {

    void select_user();

    Resp MonitorList() throws Exception;

}
