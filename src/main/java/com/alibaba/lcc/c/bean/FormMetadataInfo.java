package com.alibaba.lcc.c.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import cn.com.citydo.starter.mybatisPlus.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务上报参数配置,表单参数元数据
 * </p>
 *
 * @author lccsetsun
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_form_metadata_info")
public class FormMetadataInfo extends BasicEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("id")
    private Integer id;

    /**
     * 参数中文名称
     */
    private String paramChName;

    /**
     * 参数英文名称
     */
    private String paramEnName;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 参数说明
     */
    private String paramDesc;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 数据长度
     */
    private Integer dataLength;

    /**
     * 是否字典项(0-是，1-否)
     */
    private String isDictionary;

    /**
     * 是否为空(0-是，1-否)
     */
    private String isNull;

    /**
     * 是否主键(0-是，1-否)
     */
    private String isPrimaryKey;

    /**
     * 对象类型
     */
    private String objectType;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 绑定的模版id
     */
    private String formTpPid;

    /**
     * 是否通栏(0-是，1-否)
     */
    private String isBanner;

    /**
     * 是否显示(0-是，1-否)
     */
    private String isDisplay;

    /**
     * 字段排序asc
     */
    private Long paramSort;


}
