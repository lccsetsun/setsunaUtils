package com.alibaba.lcc.controller;

import com.alibaba.lcc.model.resp.Resp;
import com.alibaba.lcc.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/track")
public class ExportTrack {

    @Autowired
    private RoadService roadService;
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public Resp ExportTrack(){
        try {
            return roadService.MonitorList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Resp.success();
    }

}
