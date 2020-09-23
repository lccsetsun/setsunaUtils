package com.alibaba.lcc.mapper;

import com.alibaba.lcc.model.model.DatahubMonitorFow;
import com.alibaba.lcc.model.po.DatahubMonitorFowVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatahubMonitorFowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DatahubMonitorFow record);

    int insertSelective(DatahubMonitorFow record);

    DatahubMonitorFow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatahubMonitorFow record);

    int updateByPrimaryKey(DatahubMonitorFow record);

    List<DatahubMonitorFowVO> selectInflow();
}