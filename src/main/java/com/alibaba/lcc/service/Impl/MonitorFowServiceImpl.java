package com.alibaba.lcc.service.Impl;

import com.alibaba.lcc.mapper.DatahubMonitorFowMapper;
import com.alibaba.lcc.model.model.DatahubMonitorFow;
import com.alibaba.lcc.model.po.DatahubMonitorFowVO;
import com.alibaba.lcc.service.MonitorFowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MonitorFowServiceImpl implements MonitorFowService {

    @Autowired
    private DatahubMonitorFowMapper datahubMonitorFowMapper;


    @Override
    public List<DatahubMonitorFowVO> selectInflow() {
        return datahubMonitorFowMapper.selectInflow();
    }
}
