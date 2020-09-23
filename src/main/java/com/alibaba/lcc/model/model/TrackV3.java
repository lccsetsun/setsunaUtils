package com.alibaba.lcc.model.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TrackV3 {

    /**
     * 国标cameraID
     */
    private String cameraid;

    /**
     * 国标名称
     */
    private String topicName;

    /**
     * 视频流状态
     */
    private String inflow;

    /**
     * 断流时间统计
     */
    private String note_inflow_time;



}
