package com.alibaba.lcc.c.controller;


import com.alibaba.lcc.c.entity.FormMetadataInfo;
import com.alibaba.lcc.c.service.FormMetadataInfoService;
import com.alibaba.lcc.model.resp.Resp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;



/**
 * 任务上报参数配置,表单参数元数据
 *
 * @author lccsetsun
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/api/form-metadata-info")
public class FormMetadataInfoController {

    @Autowired
    private FormMetadataInfoService formMetadataInfoService;

    @GetMapping("/{id}")
    public Resp<FormMetadataInfo> get(@PathVariable Long id) {
        return Resp.success(formMetadataInfoService.getById(id));
    }

    @GetMapping
    public Resp<IPage<FormMetadataInfo>> page(FormMetadataInfo formMetadataInfo, Integer pageNo,Integer pageSize) {
        IPage<FormMetadataInfo> page = new Page<>(pageNo, pageSize);
        return Resp.success(formMetadataInfoService.page(page, new QueryWrapper<>(formMetadataInfo)));
    }

    @PostMapping
    public Resp<String> create(FormMetadataInfo formMetadataInfo) {
        return Resp.success(formMetadataInfoService.save(formMetadataInfo));
    }

    @PutMapping
    public Resp<String> update(@Validated() FormMetadataInfo formMetadataInfo) {
        return Resp.success(formMetadataInfoService.updateById(formMetadataInfo));
    }

    @DeleteMapping("/{id}")
    public Resp<String> delete(@PathVariable Long id) {
        return Resp.success(formMetadataInfoService.removeById(id));
    }
}
