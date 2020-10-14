package com.alibaba.lcc.common.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DateEntity implements Serializable {
    private static final long serialVersionUID = -2817722542718460285L;
    @TableField(
            fill = FieldFill.INSERT
    )
    private LocalDateTime createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private LocalDateTime updateTime;

    public DateEntity() {
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
