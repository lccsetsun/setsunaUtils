package com.alibaba.lcc.service;

import com.alibaba.lcc.model.model.DatahubMonitorFow;
import com.alibaba.lcc.model.po.DatahubMonitorFowVO;

import java.util.List;

public interface MonitorFowService {
    List<DatahubMonitorFowVO> selectInflow();
}
