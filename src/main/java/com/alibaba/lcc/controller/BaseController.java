package com.alibaba.lcc.controller;

import com.alibaba.lcc.model.model.DatahubMonitorFow;
import com.alibaba.lcc.model.po.DatahubMonitorFowVO;
import com.alibaba.lcc.model.resp.Resp;
import com.alibaba.lcc.service.MonitorFowService;
import com.alibaba.lcc.service.RoadService;
import com.alibaba.lcc.utils.HomeCacheManager;
import com.alibaba.lcc.utils.ZipUtils.DownloadZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/d")
public class BaseController {

    @Autowired
    private RoadService roadService;

    @Autowired
    private MonitorFowService monitorFowService;

    @Value("${access_id}")
    private String lcc_AccessId;

    @RequestMapping("/getCount")
    public Resp downloadData() {
        //优先从缓存中读取
        if (HomeCacheManager.hasData(HomeCacheManager.INFLOW)) {
            System.out.println("HomeCacheManager.getCacheData");
            return Resp.success(HomeCacheManager.getCacheData(HomeCacheManager.INFLOW));
        }
        List<DatahubMonitorFowVO> list = monitorFowService.selectInflow();
        Map<String,Object> map = new HashMap<>(3);
        map.put("count",list.size());
        map.put("list",list);
        HomeCacheManager.loadData(HomeCacheManager.INFLOW, map);
        return Resp.success(map);
    }

    /**
     *  path = 文件路径／文件名称
     * @param httpServletRequest
     * @param path
     * @return
     */
    @RequestMapping(value = "/downZIP",method = RequestMethod.POST)
    public String downloadZIP(HttpServletResponse httpServletRequest,@RequestParam String path) {
        try {
            String str = path;
            File file = new File(str);
            System.out.println("解压路径创建成功");
            File files = new File("");
            String filePath =files.getCanonicalPath();
            System.out.println("当前路径 ： "+filePath);

            System.out.println(file.listFiles().length+file.list().length);
            for (File s:file.listFiles()
                 ) {
                System.out.println(s.getName());
            }
            DownloadZip.downloadZip(file, httpServletRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "解压OK ";
    }
}
